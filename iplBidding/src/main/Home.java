package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
public class Home extends HttpServlet{ 
	private static final long serialVersionUID = 1L;
       
	Connection conn1 =null;
	Statement st =null;

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
       
		String dbURL2 = "jdbc:postgresql://10.105.33.149/ipl";
        String user = "user1";
        String pass = "";

        try {
			Class.forName("org.postgresql.Driver");
			
			conn1 = DriverManager.getConnection(dbURL2, user, pass);
			Users.conn = DriverManager.getConnection(dbURL2, user, pass);
			st = conn1.createStatement();
			System.out.println("init"+conn1);
        	} catch (Exception e) {
			// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
	    }

	    public void destroy() {
	     //Close the connection here
	    	try{
	    		conn1.close();
	    		System.out.println("close");
	    	}catch(Exception e)
	    	{
	    		System.out.println(e);
	    	}
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String jsp = request.getParameter("purpose");
		
		if(jsp.equals("login"))
		{
			String userId = request.getParameter("UserId");
			String password = request.getParameter("Password");
			String type = request.getParameter("LoginAs");
			login(userId,password,type,response);
		}	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private void login(String userId,String password, String type,HttpServletResponse response) throws IOException
	{
		try 
		{
			
		if(Users.authenticate(userId, password , type))
		{
			response.sendRedirect("/iplBidding/loginPage.jsp");
		}
		
		else
		{
			response.sendRedirect("/iplBidding/error.jsp?reason="+"Oops! Something went wrong");						
		}	
		
		} 
		
		catch (IOException e) {
			
	// TODO Auto-generated catch block
			response.sendRedirect("/iplBidding/error.jsp?reason="+"Oops! Something went wrong");
			e.printStackTrace();
		}

	}
}
