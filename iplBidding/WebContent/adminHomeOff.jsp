<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>

<body>
Welcome Admin.
<form action="Admin" method="post">
<input type="submit" value="Turn Bidding On"> <br/>
<input type="hidden" name="purpose" value="startBidding" >
</form>
<form action="Admin" method="post">
<input type="submit" value="Enter New Match Details"> <br/>
<input type="hidden" name="purpose" value="newMatch" >
</form>
<a href="logout.jsp">Logout</a>

</body>
</html>