<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
   				 document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
    		}
  		}
		xmlhttp.open("POST","Dummy",true);
		xmlhttp.send();
		}, 5000);
</script>
</head>

<body>
<div id="myDiv">
<h2>Shows time remaining for current bid</h2>
</div>

<form action="BidStatus" method="post">
Exit Current Bid
<input type="submit" value="Exit Bid"> <br/>
<input type="hidden" name="purpose" value="exitBid" >
</form>
</body>
</html>