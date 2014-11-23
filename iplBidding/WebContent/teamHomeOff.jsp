<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="TeamOff" method="post">
<input type="submit" value="teamStats"> <br/>
<input type="hidden" name="userId" value=<%=session.getAttribute("userId")%> >
<input type="hidden" name="purpose" value="teamStats" >
</form>
<form action="TeamOff" method="post">
<input type="submit" value="TeamUpdate"> <br/>
<input type="hidden" name="userId" value=<%=session.getAttribute("userId")%> >
<input type="hidden" name="purpose" value="teamUpdate" >
</form>
<a href="logout.jsp">Logout</a>
</body>
</html>