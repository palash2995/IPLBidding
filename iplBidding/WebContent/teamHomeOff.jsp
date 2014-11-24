<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=200, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<title>Insert title here</title>
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
            <li><a href="#"><span class="glyphicon glyphicon-user"></span>Home</a></li>
            <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-in"></span>Logout</a></li>
          </ul>
        </div>
      </div>
    </nav>


<br>
<br>

<center> <div class="container">
<form action="TeamOff" method="post" role="form">
<button type="submit" value="teamStats" class="btn btn-default btn-lg">Team Stats</button> 
<input type="hidden" name="userId" value=<%=session.getAttribute("userId")%> >
<input type="hidden" name="purpose" value="teamStats" >
</form>
</div>
</center>
<br>
<center>
<div class="container">
<form action="TeamOff" method="post">
<button type="submit" name="TeamUpdate" class="btn btn-default btn-lg">Update Details</button> 
<input type="hidden" name="userId" value=<%=session.getAttribute("userId")%> >
<input type="hidden" name="purpose" value="teamUpdate" >
</form>
</div>
</center>
<br>

<center> <div class="container">
<form action="TeamBidEntry" method="post" role="form">
<button type="submit" value="enterBid" class="btn btn-default btn-lg">Enter Bid</button> 
<input type="hidden" name="purpose" value="checkBid" >
</form>
</div>
</center>


</body>
</html>