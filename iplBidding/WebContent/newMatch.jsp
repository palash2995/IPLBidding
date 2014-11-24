<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=200, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<title>MATCH SCORECARD</title>
</head>
<body>

 <nav class="navbar navbar-inverse">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>                        
          </button>
          <a class="navbar-brand" href="#">IPL Player Auction</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="adminHomeOff.jsp"><span class="glyphicon glyphicon-user"></span>Home</a></li>
            <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-in"></span>Logout</a></li>
          </ul>
        </div>
      </div>
    </nav>

<div class="container">

	<form action = "Admin" method="post" role="form">
	
	
	   <div class="form-group">
          <label for="email">Enter the match ID:</label>
          <input type="text" class="form-control" name="matchId" id="email" placeholder="Enter matchID">
        </div>

	   <div class="form-group">
          <label for="email">Enter the stadium:</label>
          <input type="text" class="form-control" name="stadium" id="email" placeholder="Enter stadium">
        </div>

	   <div class="form-group">
          <label for="email">Enter team 1 ID:</label>
          <input type="text" class="form-control" name="team1Id" id="email" placeholder="Enter team1Id">
        </div>

	   <div class="form-group">
          <label for="email">Enter team 2 ID:</label>
          <input type="text" class="form-control" name="team2Id" id="email" placeholder="Enter team2Id">
        </div>
	
	
	
	
	Team 1 Scores
	
		<table class="table table-bordered">
        <thead>
        	<tr>
				<td>PlayerId</td>
				<td>Runs</td>
				<td>Wickets</td>
				<td>Catches</td>
			</tr>
        
        </thead>
        <tbody>


		
		<% for(int i=0;i<11;i++) 
		{%>
			<tr>
				<td><input type="text" name="players"  > </td>
				<td><input type="text" name="runs"  > </td>
				<td><input type="text" name="wickets"  > </td>
				<td><input type="text" name="catches"  > </td>
			</tr>
		<% 
		}%>
		        </tbody>		
	</table>
	
	Team 2 Scores
		<table class="table table-bordered">
        <thead>
        	<tr>
				<td>PlayerId</td>
				<td>Runs</td>
				<td>Wickets</td>
				<td>Catches</td>
			</tr>
        
        </thead>
        <tbody>
		
		<% for(int i=0;i<11;i++) 
		{%>
			<tr>
				<td><input type="text" name="players"  > </td>
				<td><input type="text" name="runs"  > </td>
				<td><input type="text" name="wickets"  > </td>
				<td><input type="text" name="catches"  > </td>
			</tr>
		<% 
		}%>		
		        </tbody>
	</table>
	
	<button type="submit" value="Save Match" class="btn btn-default">Save Match</button>
	<input type="hidden" name="purpose" value="saveMatch" >
	</form>
</body>
</html>