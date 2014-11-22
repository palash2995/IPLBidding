package main;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class admin extends Home {
	private static final long serialVersionUID = 1L;
       
	/**
     * @see HttpServlet#HttpServlet()
     */
    public admin() {
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
		
		if(jsp.equals("NewMatch"))request.getParameter("matchId");
		{
			response.sendRedirect("/iplBidding/newMatch.jsp");	
		}
		if(jsp.equals("SaveMatch"))request.getParameter("matchId");
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
				int earlierRuns = 0, earlierWickets = 0, earlierCatches = 0;
				try {
					st = conn1.createStatement();
					ResultSet rs = st.executeQuery("Select runs, wickets, catches from PlayerPlays where player_id = '" + players[i] + "'");
					while(rs.next())
					{
						earlierRuns = rs.getInt("runs");
						earlierCatches = rs.getInt("wickets");
						earlierCatches = rs.getInt("catches");
					}
					earlierRuns = earlierRuns + Integer.parseInt(runs[i]);
					earlierCatches = earlierCatches + Integer.parseInt(catches[i]);
					earlierWickets = earlierWickets + Integer.parseInt(wickets[i]);

				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					st = conn1.createStatement();
					st.executeUpdate("Update PlayerPlays Set runs = " + earlierRuns + " ,wickets = " + earlierWickets + " ,catches = " + earlierCatches + " where player_id = '" + players[i] + "'");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			response.sendRedirect("/iplBidding/adminHome.jsp");	
		}
		if(jsp.equals("StartBidding"))
		{
			response.sendRedirect("/iplBidding/bidId.jsp");	
		}
		
	}

}
