<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<title>Bid Details</title>
<script type="text/javascript">
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
		   			 document.getElementById("Div2").innerHTML=xmlhttp.responseText;
		    	}
		  	}
			xmlhttp.open("POST","Submit",true);
			xmlhttp.send();
		}, 10000);
</script>
</head>

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
	<li><a href="teamHomeOff.jsp"><span
		class="glyphicon glyphicon-user"></span>Home</a></li>
	<li><a href="logout.jsp"><span
		class="glyphicon glyphicon-log-in"></span>Logout</a></li>
</ul>
</div>
</div>
</nav>



<div id="Div1">
<center><h2></h2></center>
</div>
<div id="Div2">
<center><h2> </h2></center>
</div>

<div class="container"><br>
<form action="BidStatus" method="post" role="form">


<center>
<button type="submit" value="Exit Bid" class="btn btn-default btn-lg">Exit
Current Bid</button>
</center>

<input type="hidden" name="purpose" value="exitBid"></form>

</div>

</body>
</html>