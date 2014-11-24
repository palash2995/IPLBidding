package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BiddingManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection conn1 =null;
	Statement st =null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BiddingManager() {
		super();
		String dbURL2 = "jdbc:postgresql://10.105.33.149/ipl";
		String user = "user1";
		String pass = "user123";

		try {
			Class.forName("org.postgresql.Driver");

			conn1 = DriverManager.getConnection(dbURL2, user, pass);
			st = conn1.createStatement();
			System.out.println("init"+conn1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = request.getParameter("purpose");
		if(jsp.equals("startBid")){
			String playerId = request.getParameter("playerId");
			Date date = new Date();
			long diff = date.getTime();
			try {
			st = conn1.createStatement();
			st.executeUpdate("Insert into playerBid values('" + playerId + "','" + diff + "')");
			Thread.sleep(150000);	
			st = conn1.createStatement();
			ResultSet rs = st.executeQuery("Select teamId, price, time from bids where " +
					"time = (Select max(time) from bids where playerId ='" + playerId + "')");
			String teamId = null;
			int price = 0;
			while(rs.next())
			{
				teamId = rs.getString("teamId"); 
				price = rs.getInt("price");
			}
			System.out.println(teamId + price + playerId);
			st = conn1.createStatement();
			
			rs = st.executeQuery("Select cap from teamDetails where teamId = '" + teamId + "'");
			int spendingCap=25000;
			while(rs.next()) spendingCap = rs.getInt("cap");
			
			
			st.executeUpdate("Update Squad set teamId = '" + teamId + "', price = " + price + " where playerId = '" + playerId + "'");
			st.executeUpdate("Update teamDetails set cap = " + (spendingCap - price) + " where teamId = '" + teamId + "'");	
			Thread.sleep(10000);	
			st = conn1.createStatement();
			st.executeUpdate("Delete from playerBid");
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("/iplBidding/error.jsp");
			}
			response.sendRedirect("/iplBidding/adminHomeOff.jsp");
		}
	}

}
