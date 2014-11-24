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
 * Servlet implementation class BidStatus
 */
public class BidStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection conn1 =null;
	Statement st =null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BidStatus() {
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
		String jsp = request.getParameter("purpose");
		System.out.println("Why only here?");
		if(jsp.equals("newBid"))
		{
			Date date = new Date();
			long diff = date.getTime();
			String bidAmount = request.getParameter("bidAmount");
			int bids = Integer.parseInt(bidAmount);
			String playerId = null;
			String bidStartTime = null;
			long time = 0;
			ResultSet rs;
			try
			{
				st = conn1.createStatement();
				rs = st.executeQuery("Select playerId, time from playerbid");	
				while(rs.next())
				{
					playerId = rs.getString("playerId");
					bidStartTime = rs.getString("time");
				}
				time = Long.parseLong(bidStartTime);
				int bestPrice = 0;
				HttpSession session = request.getSession();
				String teamId = (String) session.getAttribute("userId");
				st = conn1.createStatement();
				
				rs = st.executeQuery("Select max(price) as bestPrice from bids where playerId ='" + playerId + "'");
				while(rs.next()) bestPrice = rs.getInt("bestPrice");
				
				rs = st.executeQuery("Select cap from teamDetails where teamId = '" + teamId + "'");
				int spendingCap = 25000;
				while(rs.next()) spendingCap = rs.getInt("cap");
				
				int foreignPlayers = 0, newPlayer = 0;
				rs = st.executeQuery("Select country from squad natural join playerDetails where teamId = '" + teamId + "'");
				while(rs.next())
				{
					String nationality = rs.getString("country");
					if(!(nationality.equals("India") || nationality.equals("Indian"))) foreignPlayers ++;
				}
				
				rs = st.executeQuery("Select country from squad natural join playerDetails where playerId = '" + playerId + "'");
				while(rs.next())
				{
					String nationality = rs.getString("country");
					if(!(nationality.equals("India") || nationality.equals("Indian"))) newPlayer = 10;
				}
				
				if((diff-time)<150000 && bids>bestPrice && spendingCap>bids && ((newPlayer-foreignPlayers)>=0 || newPlayer ==0)){
					st = conn1.createStatement();
					st.executeUpdate("Insert into bids values('" + playerId + "','" + teamId + "'," + bids + ",'" + diff + "')");
				}
			} catch (Exception e) 
			{ 
				response.sendRedirect("/iplBidding/error.jsp");
			}
			response.sendRedirect("/iplBidding/bidFramework.jsp");
		}
		if(jsp.equals("exitBid"))
		{
			response.sendRedirect("/iplBidding/teamHomeOff.jsp");
		}
	}

}
