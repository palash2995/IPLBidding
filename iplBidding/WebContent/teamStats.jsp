<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="main.Tuple" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<center><h1>Your Details</h1></center>
<table border="1" cellpadding="5" width="300">
	<tr>
		<td>Name </td>
		<td><%out.println( request.getParameter("teamName"));%> </td>
	</tr>
	<tr>
		<td> Stadium </td>
		<td> <%out.println( request.getParameter("stadium"));%> </td>
	</tr>
	<tr>
		<td> Owner </td>
		<td> <%out.println( request.getParameter("owner"));%> </td>
	</tr>
</table>
<br>



<%  

// retrieve your list from the request, with casting 
java.util.ArrayList<Tuple> list = (java.util.ArrayList<Tuple>)session.getAttribute("players");

// print the information about every category of the list
if(list!=null)
{	
for(Tuple tuple : list) {
    out.println(tuple.playerName + " ");
    out.println(tuple.price+ " " );
    out.println(tuple.playerId + " ");
    out.println("\n");
}
}
%>
<br>
<a href="teamHomeOff.jsp">Go to Home</a>
<br>
<a href="logout.jsp">Logout</a>


</body>
</html>