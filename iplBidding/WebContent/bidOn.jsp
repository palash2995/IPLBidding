<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
PlayerId : <%=request.getParameter("player")%> <br/>
Time remaining : <%=request.getParameter("time")%> seconds <br/>

Current best bid <br/>
TeamId : <%=request.getParameter("squad")%> <br/>
Price : <%=request.getParameter("bid")%> <br/>

<form action="Player" method="post">
<input type="submit" value="PlayerStats"> <br/>
<input type="hidden" name="purpose" value="playerStats" >
</form>

</body>
</html>
