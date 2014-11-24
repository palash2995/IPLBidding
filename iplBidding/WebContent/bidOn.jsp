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
<div class="container">
      <h2> </h2>
      <table class="table table-bordered">
<tr>
<td>PlayerId : </td> <td> <%=request.getParameter("player")%> </td>
</tr>
<tr>
<td> Time remaining : </td> <td>  <%=request.getParameter("time")%>  </td>
</tr>
</table>
</div>

<div class="container">
      <h2> Current best bid </h2>
      <table class="table table-bordered">
<tr>
<td> TeamId : </td> <td> <%=request.getParameter("squad")%> </td>
</tr>
<tr>
<td> Price : </td> <td>  <%=request.getParameter("bid")%>  </td>
</tr>
<tr>
<td> Spending Cap : </td> <td>  <%=request.getParameter("cap")%>  </td>
</tr>
<tr>
<td> Foreign Players Cap : </td> <td>  <%=request.getParameter("foreignPlayers")%>  </td>
</tr>
</table>
</div>


<div class="container">
<div class="form-group">
<form action="Player" method="post" role="form">
<center>
<button type="submit" value="PlayerStats" class="btn btn-default btn-lg">Player Stats</button>
</center>
<input type="hidden" name="purpose" value="playerStats"></form>
</div>
</div>

</body>
</html>
