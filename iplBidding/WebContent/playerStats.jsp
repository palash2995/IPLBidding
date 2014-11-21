<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><h1>Your Details and Statistics</h1></center>
<table border="1" cellpadding="5" width="300">
	<tr>
		<td>Name </td>
		<td><%out.println( request.getParameter("userName"));%> </td>
	</tr>
	<tr>
		<td> Country </td>
		<td> <%out.println( request.getParameter("country"));%> </td>
	</tr>
</table>
<br>
<table border="1" cellpadding="5" width="300">
	<tr>
		<td> Matches </td>
		<td> <%out.println( request.getParameter("matches"));%> </td>
	</tr>
	<tr>
		<td> Runs </td>
		<td> <%out.println( request.getParameter("runs"));%></td>
	</tr>
	<tr>
		<td> Wickets </td>
		<td> <%out.println( request.getParameter("wickets"));%></td>
	</tr>
	<tr>
		<td> Catches</td>
		<td> <%out.println( request.getParameter("catches"));%></td>
	</tr>
</table>
<br>
<a href="playerHome.jsp">Go to Home</a>
<br>
<a href="logout.jsp">Logout</a>
</body>
</html>