<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<center>Bidding process is paused.</center>
<div class="container">
      <h2>
 
Previous results </h2>
      <table class="table table-bordered">
<tr>
<td>PlayerId : </td> <td> <%=request.getParameter("player")%> </td>
</tr>
<tr>
<td> Squad : </td> <td>  <%=request.getParameter("squad")%>  </td>
</tr>
<tr>
<td> Price : </td> <td> <%=request.getParameter("price")%>  </td>
</tr>
<tr>
<td> Spending Cap : </td> <td>  <%=request.getParameter("cap")%>  </td>
</tr>
<tr>
<td> Foreign Players Cap : </td> <td>  <%=request.getParameter("foreign")%>  </td>
</tr>
</table>
</div>
</body>
</html>