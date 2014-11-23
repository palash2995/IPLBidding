<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<script>
	setInterval(function ()
		{
			var xmlhttp;
			if (window.XMLHttpRequest)
	  		{// code for IE7+, Firefox, Chrome, Opera, Safari
	 			 xmlhttp=new XMLHttpRequest();
	  		}
			else
	  		{// code for IE6, IE5
	  			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  		}
			xmlhttp.onreadystatechange=function()
	  		{
	  			if (xmlhttp.readyState==4 && xmlhttp.status==200)
	   			{
	   				 document.getElementById("Div1").innerHTML=xmlhttp.responseText;
	    		}
	  		}
			xmlhttp.open("POST","Dummy",true);
			xmlhttp.send();
			}, 1000);
</script>
<body>
<nav class="navbar navbar-inverse">
<div class="container-fluid">
<div class="navbar-header">
<button type="button" class="navbar-toggle" data-toggle="collapse"
	data-target="#myNavbar"><span class="icon-bar"></span> <span
	class="icon-bar"></span> <span class="icon-bar"></span></button>
<a class="navbar-brand" href="#">IPL Player Auction</a></div>
<div class="collapse navbar-collapse" id="myNavbar">
<ul class="nav navbar-nav navbar-right">
	<li><a href="adminHomeOff.jsp"><span
		class="glyphicon glyphicon-user"></span>Home</a></li>
	<li><a href="logout.jsp"><span
		class="glyphicon glyphicon-log-in"></span>Logout</a></li>
</ul>
</div>
</div>
</nav>

<div class="container">

<div class="form-group">
<form action="BiddingManager" method="post" role="form">

<label for="pwd">Start Bid for player:</label>
<input type="text" name="playerId" class="form-control" id="pwd" placeholder="Enter playerId">
</div>

<center>
<button type="submit" value="Start Bid" class="btn btn-default btn-lg">Start Bid</button>
</center>
<input type="hidden" name="purpose" value="startBid"></form>

</div>

<div id="Div1">
<h2></h2>
</div>

</body>
</html>
