package main;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Player extends Home{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Player()
	{
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub

	//	String jsp = (String) request.getAttribute("jsp");
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		
		String jsp = request.getParameter("purpose");
		
		if(jsp.equals("register"))
		{			
			playerSignUp(request,response);
		}	

		else if(jsp.equals("playerUpdate"))
		{
			playerUpdate(request,response);			
		}
		
		else if(jsp.equals("playerStats"))
		{
			playerStats(request,response);						
		}

		else if(jsp.equals("update"))
		{	
			updatePlayer(request,response);
		}
	}

	
	
	
	private void playerSignUp(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		
		String userId = request.getParameter("UserId");
		String password = request.getParameter("Password");
		String name = request.getParameter("UserName");
		String country = request.getParameter("Country");

		
		try 
		{
			st = conn1.createStatement();
			st.executeUpdate("insert into  players values('" + userId + "','" + password + "')");	
			st.executeUpdate("insert into  playerDetails values('" + userId + "','" + name + "','" + country + "')");	
			response.sendRedirect("/iplBidding/loginPage.jsp"); ///successful login later		
		
		}

		
		catch (Exception e) 
		{
			response.sendRedirect("/iplBidding/error.jsp?reason="+"Oops! Something went wrong");		
			e.printStackTrace();
		}
			
		
	}
	
	
	private void playerStats(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		try 
		{
			
		HttpSession session  = request.getSession();
		String  id = (String) session.getAttribute("pUserId");
		
		st = conn1.createStatement();
		
		//OLAP remaining 
		ResultSet rs = st.executeQuery("select * from playerDetails where id = '" + id + "'");	
		if(!rs.next())
		{
			System.out.println("Not a player dude");
		}
		String name = rs.getString("name");
		String country = rs.getString("country");		
		ResultSet rs2 = st.executeQuery("select * from playerStats where id = '" + id + "'");	
		if(!rs2.next())
		{
			System.out.println("Chal jhoote");
		}
		String matches = rs2.getString("matches");
		String runs    = rs2.getString("runs");
		String wickets = rs2.getString("wickets");
		String catches = rs2.getString("catches");		
		response.sendRedirect("/iplBidding/playerStats.jsp?userName=" + name + "&country=" + country + "&matches=" + matches + "&runs=" +  runs + "&wickets=" +wickets + "&catches=" +catches );	
		} 
		catch (Exception e)
		{		
			response.sendRedirect("/iplBidding/error.jsp?reason="+"Oops! Something went wrong");		
			e.printStackTrace();
		}		
		
	}

	private void playerUpdate(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		try 
		{
		
		st = conn1.createStatement();
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("userId");
		String type = (String) session.getAttribute("type");
		
		if(type.equals("p"))
		{
			ResultSet rs = st.executeQuery("select * from playerDetails where id = '" + id + "'");	
			if(!rs.next())
			{
				System.out.println("isliye hi to");
			}	
			String name = rs.getString("name");
			String country = rs.getString("country");		
			response.sendRedirect("/iplBidding/playerUpdate.jsp?userName=" + name + "&country=" + country);	
		}

		} 
		catch (Exception e)
		{		
			response.sendRedirect("/iplBidding/error.jsp?reason="+"Oops! Something went wrong");		
			e.printStackTrace();
		}
	}


	private void updatePlayer(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		try 
		{
			HttpSession session = request.getSession();
			String userId = (String) session.getAttribute("userId");
			System.out.println("isliye "+userId);
			String name = request.getParameter("UserName");
			String country = request.getParameter("Country");
			System.out.println("dj");

			st = conn1.createStatement();
			st.executeUpdate("update playerDetails set name = '" + name + "', country = '" + country + "' where id = '" + userId +"'");	
			System.out.println("statement created");
			response.sendRedirect("/iplBidding/playerHome.jsp");		
		}
		
		catch (Exception e) 
		{
			response.sendRedirect("/iplBidding/error.jsp?reason="+"Oops! Something went wrong");		
			e.printStackTrace();
		}
		
	}	
}
