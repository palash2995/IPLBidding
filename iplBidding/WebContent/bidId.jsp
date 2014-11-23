<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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

<form action="BiddingManager" method="post">
Start Bid for player
<input type="text" name="playerId" size="20px"> <br/>
<input type="submit" value="Start Bid"> <br/>
<input type="hidden" name="purpose" value="startBid" >
</form>

<div id="Div1">
<h2></h2>
</div>

</body>
</html>
