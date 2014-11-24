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
		String pass = "user123";

		try {
			Class.forName("org.postgresql.Driver");
			conn1 = DriverManager.getConnection(dbURL2, user, pass);
			st = conn1.createStatement();
			System.out.println("init"+conn1);

		}
		catch (Exception e) {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String jsp = request.getParameter("purpose");

		if(jsp.equals("login"))
		{
			login(request,response);
		}

	}

	private void login(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		try 
		{
			String userId = request.getParameter("UserId");
			String password = request.getParameter("Password");
			String type = request.getParameter("LoginAs");

			if(Users.authenticate(userId, password , type))
			{

				HttpSession session  = request.getSession();
				session.setAttribute("userId",userId);
				session.setAttribute("type",type);	
				

				if(type.equals("Player"))
				{
					session.setAttribute("pUserId",userId);
					response.sendRedirect("/iplBidding/playerHome.jsp");
				}
				if(type.equals("Team"))
				{
					
					session.setAttribute("pUserId",null);
					ResultSet rs;
					Statement st = conn1.createStatement();

					rs = st.executeQuery("SELECT * from playerBid");	

					if(!rs.next())
					{
						response.sendRedirect("/iplBidding/teamHomeOff.jsp");    	
					}

					else
					{
						response.sendRedirect("/iplBidding/bidFramework.jsp");///askto pande
					}
				}
				if(type.equals("Administrator"))
				{
					ResultSet rs;
					rs = st.executeQuery("SELECT * from playerBid");	

					if(!rs.next())
					{
						response.sendRedirect("/iplBidding/adminHomeOff.jsp");    	
					}

					else
					{
						response.sendRedirect("/iplBidding/adminHomeOn.jsp");///askto pande
					}
				}
			}

			else
			{
				response.sendRedirect("/iplBidding/error.jsp?reason="+"Authentication Failure !!!!");						
			}	

		} 

		catch (Exception e) {
			response.sendRedirect("/iplBidding/error.jsp?reason="+"Oops! Something went wrong");
			e.printStackTrace();
		}

	}
}
