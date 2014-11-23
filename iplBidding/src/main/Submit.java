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

/**
 * Servlet implementation class Submit
 */
public class Submit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection conn1 =null;
	Statement st =null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Submit() {
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
		String bidStartTime = "";
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
			time = Long.parseLong(bidStartTime);
			if(!playerId.equals(""))
			{
				if((diff-time)<150000) response.sendRedirect("/iplBidding/bidSubmit.jsp?");
			}
		}catch (Exception e) 
		{ 
			response.sendRedirect("/iplBidding/error.jsp");
		}
	}

}
