package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Reached");
		Date date = new Date();
	    long diff = date.getTime();
	    System.out.print(diff);
	    if(diff>100)
		response.sendRedirect("/iplBidding/bidDummy.jsp?time="+diff);
	    else 
		response.sendRedirect("/iplBidding/submitBidDummy.jsp?time="+diff);

	}

}
