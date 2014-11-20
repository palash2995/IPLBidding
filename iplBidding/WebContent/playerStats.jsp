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
<%=request.getParameter("playerDetails") %>
<br>
<%=request.getParameter("playerStats") %>
<br>
<form action="Player" method="post">
<input type="submit" value="GoToHome"> <br/>
<input type="hidden" name="userId" value=%=request.getParameter("userId")% >
<input type="hidden" name="purpose" value="playerHome" >
</form>
<br>
<form action="Player" method="post">
<input type="submit" value="GoToHome"> <br/>
<input type="hidden" name="userId" value=%=request.getParameter("userId")% >
<input type="hidden" name="purpose" value="playerHome" >
</form>
<br>
<a href="loginPage.jsp">Logout</a>
</body>
</html>