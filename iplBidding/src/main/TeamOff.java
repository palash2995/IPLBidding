package main;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TeamOff extends Home{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public TeamOff()
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
		
		if(jsp.equals("teamUpdate"))
		{
			teamUpdate(request,response);			
		}
		
		else if(jsp.equals("teamStats"))
		{
			teamStats(request,response);						
		}

		else if(jsp.equals("update"))
		{	
			updateTeam(request,response);
		}
	}

	
	
	private void teamStats(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		try 
		{
			
		HttpSession session  = request.getSession();
		String  teamId = (String) session.getAttribute("userId");
		System.out.println("Hello TeamId "+teamId);
		st = conn1.createStatement();
		
		//OLAP remaining 
		ResultSet rs = st.executeQuery("select * from teamDetails where teamId = '" + teamId + "'");	
		
		if(!rs.next())
		{
			System.out.println("Not a team dude");
		}
		System.out.println("Hello Team name1 ");
		String name = rs.getString("teamName");
		System.out.println("Hello Team name "+name);
		String owner = rs.getString("Owner");
		String stadium = rs.getString("Stadium");
		
		ResultSet rs2 = st.executeQuery("select * from Squad where teamId = '" + teamId + "'");	
		System.out.println("Squad is empty? ");
		List<Tuple> players = new ArrayList<Tuple>(); 
		

		List<String>  ids = new ArrayList<String >();
		ArrayList<String>  prices = new ArrayList<String >();

		
		while(rs2.next())
		{
			String playerId = rs2.getString("playerId");
			String price   = rs2.getString("price");						
			ids.add(playerId);
			prices.add(price);
			
		}
		
		int i = 0;
		
		for(String pId : ids)
		{	
			ResultSet rs3 = st.executeQuery("select name from playerDetails where id = '" + pId + "'");	

			rs3.next();			
			String playerName = rs3.getString("name");
			Tuple temp = new Tuple(playerName,prices.get(i),pId);
			players.add(temp);
			System.out.println("tuple created");
			
		}
		System.out.println("after while loop");

		System.out.println("size " + players.size());
		
		for(Tuple tuple : players) {
		    System.out.println(tuple.playerName + " ");
		    System.out.println(tuple.price+ " " );
		    System.out.println(tuple.playerId + " ");
		}
		
		System.out.println("after while loop2");
		
		request.getSession().setAttribute("players",players);
		response.sendRedirect("/iplBidding/teamStats.jsp?teamName=" + name + "&owner=" + owner + "&stadium=" + stadium);	
		}
		catch (Exception e)
		{		
			response.sendRedirect("/iplBidding/error.jsp?reason="+"Oops! Something went wrong");		
			e.printStackTrace();
		}		
		
	}

	private void teamUpdate(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		try 
		{
		
		st = conn1.createStatement();
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("userId");
		String type = (String) session.getAttribute("type");
		
		if(type.equals("t"))
		{
			ResultSet rs = st.executeQuery("select * from teamDetails where teamId = '" + id + "'");	
			System.out.println("isliye hi to");

			if(!rs.next())
			{
				System.out.println("isliye hi to");
			}	
			String name = rs.getString("teamName");
			String stadium = rs.getString("Stadium");
			String owner = rs.getString("Owner");		
			
			response.sendRedirect("/iplBidding/teamUpdate.jsp?teamName=" + name + "&stadium=" + stadium + "&owner=" + owner);	
		}

		} 
		catch (Exception e)
		{		
			response.sendRedirect("/iplBidding/error.jsp?reason="+"Oops! Something went wrong");		
			e.printStackTrace();
		}
	}


	private void updateTeam(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		try 
		{
			HttpSession session = request.getSession();
			String userId = (String) session.getAttribute("userId");
			String teamname = request.getParameter("TeamName");
			String stadium = request.getParameter("Stadium");
			String owner = request.getParameter("Owner");			

			st = conn1.createStatement();
			st.executeUpdate("update teamDetails set teamName = '" + teamname + "', Owner = '" + owner + "', Stadium = '" + stadium + "' where teamId = '" + userId +"'");	
			System.out.println("statement created");
			response.sendRedirect("/iplBidding/teamHomeOff.jsp");		
		}
		
		catch (Exception e) 
		{
			response.sendRedirect("/iplBidding/error.jsp?reason="+"Oops! Something went wrong");		
			e.printStackTrace();
		}		
	}	
}
