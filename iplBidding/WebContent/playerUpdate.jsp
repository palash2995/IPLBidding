<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Player" method="post">
<br/>
Please update your details <br/>
Your username was: <%=request.getParameter("userName") %> <br/>
Username <br/>
<input type="text" name="Username"size="20px"> <br/>
Your userId was: <%=request.getParameter("userID") %> <br/>
UserId <br/>
<input type="text" name="User Id"size="20px"> <br/>
Your country was: <%=request.getParameter("country") %> <br/>
Country <br/>
<input type="text" name="Country"size="20px"> <br/>
<input type="submit" value="Update"> <br/>
<input type="hidden" name="purpose" value="update" >
</form>

</body>
</html>