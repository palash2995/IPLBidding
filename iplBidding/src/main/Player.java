package main;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Player extends Home{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	Player()
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
	
		
		String jsp = request.getParameter("purpose");
		
		if(jsp.equals("register"))
		{
			String userId = request.getParameter("UserId");
			String password = request.getParameter("Password");
			String name = request.getParameter("UserName");
			String country = request.getParameter("Country");
			
			PlayerDetailsObject obj = new PlayerDetailsObject(userId,password,name,country);
			
			playerSignUp(obj,response);
		}	

		else if(jsp.equals("playerUpdate"))
		{
			String userId = request.getParameter("UserId");
			playerUpdate(userId,response);			
		}
		
		else if(jsp.equals("playerStats"))
		{
			
		}

		else if(jsp.equals("update"))
		{

			String userId = request.getParameter("UserId");
			String name = request.getParameter("UserName");
			String country = request.getParameter("Country");

			PlayerDetailsObject obj = new PlayerDetailsObject(userId,"",name,country);			
			updatePlayer(obj,response);

		}
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	
	private void playerSignUp(PlayerDetailsObject player,HttpServletResponse response) throws IOException
	{
		try 
		{
			st = conn1.createStatement();
			
			st.executeQuery("insert into  players values('" + player.userId + "','" + player.password + "')");	
			st.executeQuery("insert into  playerDetails values('" + player.userId + "','" + player.name + "','" + player.country + "')");	
			response.sendRedirect("/iplBidding/playerHome.jsp?userId="+ player.userId);		
		}
		
		catch (Exception e) 
		{
			response.sendRedirect("/iplBidding/error.jsp?reason="+"Oops! Something went wrong");		
			e.printStackTrace();
		}
			
		
	}
	
	
	private void playerStats(String id)
	{
		
	}

	private void playerUpdate(String id,HttpServletResponse response) throws IOException
	{
		try 
		{
		
		st = conn1.createStatement();
		
		ResultSet rs = st.executeQuery("select * from playerDetails where id = '" + id);	
		String name = rs.getString("name");
		String country = rs.getString("country");		
		response.sendRedirect("/iplBidding/playerUpdate.jsp?userId="+ id + "userName=" + name + "country=" + country);	

		} 
		catch (Exception e)
		{		
			response.sendRedirect("/iplBidding/error.jsp?reason="+"Oops! Something went wrong");		
			e.printStackTrace();
		}
	}


	private void updatePlayer(PlayerDetailsObject player,HttpServletResponse response) throws IOException
	{
		try 
		{
			st = conn1.createStatement();
			st.executeQuery("update playerDetails where id = '" + player.userId + "' set name = '" + player.name + "' country = '" + player.country + "'");	
			response.sendRedirect("/iplBidding/playerHome.jsp?userId="+ player.userId);		
		} 
		catch (Exception e) 
		{
			response.sendRedirect("/iplBidding/error.jsp?reason="+"Oops! Something went wrong");		
			e.printStackTrace();
		}
		
	}	
}
