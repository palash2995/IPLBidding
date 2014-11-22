package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
			Users.conn = DriverManager.getConnection(dbURL2, user, pass);
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
		if(jsp.equals("newBid"))
		{
			String bidAmount = request.getParameter("bidAmount");
			int bids = Integer.parseInt(bidAmount);
			String playerId = null;
			try{
				st = conn1.createStatement();
				ResultSet rs = st.executeQuery("Select playerId from currbid");	
				while(rs.next()) playerId = rs.getString("playerId");
				HttpSession session = request.getSession();
				String teamId = (String) session.getAttribute("userId");
				st = conn1.createStatement();
				st.executeUpdate("Insert into bids values('" + playerId + "','" + teamId + "','" + bids + "')");	
			} catch (Exception e) 
			{ }
			response.sendRedirect("/iplBidding/bidDetails.jsp");
		}
	}

}
