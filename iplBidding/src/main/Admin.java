package main;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Admin extends Home {
	private static final long serialVersionUID = 1L;
       
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
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
		System.out.println(jsp);
		if(jsp.equals("newMatch"))
		{
			response.sendRedirect("/iplBidding/newMatch.jsp");	
		}
		if(jsp.equals("saveMatch"))
		{
			String id = request.getParameter("matchId");
			String team1id = request.getParameter("team1Id");
			String team2id = request.getParameter("team2Id");
			String stadium = request.getParameter("stadium");
			String[] players = request.getParameterValues("players");
			String[] runs = request.getParameterValues("runs");
			String[] wickets = request.getParameterValues("wickets");
			String[] catches = request.getParameterValues("catches");
			
			try {
				st = conn1.createStatement();
				st.executeUpdate("Insert into Match values('" + id + "','" + stadium + "')");
				int team1score = 0, team2score = 0;
				for(int i = 0; i < 11; i++){
					runs[i]="0";
					wickets[i]="0";
					catches[i]="0";
					runs[i+11]="0";
					wickets[i+11]="0";
					catches[i+11]="0";
					team1score = team1score + Integer.parseInt(runs[i]);
					team2score = team2score + Integer.parseInt(runs[11+i]);
				}
				if(team1score>team2score){
					st = conn1.createStatement();
					st.executeUpdate("Insert into TeamResults values('" + id + "','" + team1id + "')");
				}
				else{
					st = conn1.createStatement();
					st.executeUpdate("Insert into TeamResults values('" + id + "','" + team2id + "')");
				}
			} catch (SQLException e1) {
			}
			for(int i = 0; i < 22; i++){
				int earlierRuns = 0, earlierWickets = 0, earlierCatches = 0,earlierMatches=0;
				try {
					st = conn1.createStatement();
					ResultSet rs = st.executeQuery("Select runs, wickets, catches,matches from playerStats where player_id = '" + players[i] + "'");
					while(rs.next())
					{
						earlierMatches= rs.getInt("matches");
						earlierRuns = rs.getInt("runs");
						earlierCatches = rs.getInt("wickets");
						earlierCatches = rs.getInt("catches");
					}
					earlierMatches = earlierMatches + 1;
					earlierRuns = earlierRuns + Integer.parseInt(runs[i]);
					earlierCatches = earlierCatches + Integer.parseInt(catches[i]);
					earlierWickets = earlierWickets + Integer.parseInt(wickets[i]);

				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					st = conn1.createStatement();
					st.executeUpdate("Update playerStats Set runs = " + earlierRuns + " ,wickets = " + earlierWickets + " ,catches = " + earlierCatches + " ,matches = " + earlierMatches + " where player_id = '" + players[i] + "'");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			response.sendRedirect("/iplBidding/adminHomeOff.jsp");	
		}
		if(jsp.equals("startBidding"))
		{
			System.out.println("Reached");
			response.sendRedirect("/iplBidding/bidId.jsp");	
		}
		
	}

}
