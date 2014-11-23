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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Dummy
 */
public class Dummy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection conn1 =null;
	Statement st =null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Dummy() {
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date = new Date();
		long diff = date.getTime();
		String playerId = "";
		String teamId = "";
		String bidStartTime = "";
		String price = "";
		long time = 0;
		ResultSet rs;

		try
		{
			st = conn1.createStatement();
			rs = st.executeQuery("Select playerId, time from playerBid");	

			while(rs.next())
			{
				playerId = rs.getString("playerId");
				bidStartTime = rs.getString("time");
			}

			if(playerId.equals("") || playerId == null){
				response.sendRedirect("");
			}
			else
			{
				HttpSession session = request.getSession();
				session.setAttribute("pUserId",playerId);
				time = Long.parseLong(bidStartTime);
				if((diff-time)>150000){
					st = conn1.createStatement();
					rs = st.executeQuery("Select playerId, teamId, price from squad where playerId = '" + playerId + "'");
					while(rs.next())
					{
						teamId = rs.getString("teamId");
						price = rs.getString("price");
					}
					response.sendRedirect("/iplBidding/bidOff.jsp?price=" + price + "&player=" + playerId + "&squad=" + teamId);
				}
				else
				{
					st = conn1.createStatement();
					rs = st.executeQuery("Select teamId, price, time from bids where " +
							"time = (Select max(time) from bids where playerId ='" + playerId + "')");
					while(rs.next())
					{
						teamId = rs.getString("teamId"); 
						price = rs.getString("price");
					}
					diff = 150 - (diff - time)/1000;
					response.sendRedirect("/iplBidding/bidOn.jsp?time=" + diff + "&player=" + playerId + "&squad=" + teamId + "&bid=" + price);
				}
			}
		} catch (Exception e) {
			response.sendRedirect("/iplBidding/error.jsp");
		}
	}

}
