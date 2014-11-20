<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Home" method="post">
Please login here, if you have been registered already <br/>
User Id <br/>
<input type="text" name="UserId"size="20px"> <br/>
Password <br/>
<input type="password" name="Password" size="20px"> <br/>
Login as <br/>
If you are a team fill in 't', if you are a player, fill in 'p' and 'a' for admin
<input type="text" name="LoginAs" size="20px"> <br/>
<input type="submit" value="login"> <br/>
<input type="hidden" name="purpose" value="login" >
</form>

<form action="Player" method="post">
<br/>
Else please register yourself with new Username and Password <br/>
Username <br/>
<input type="text" name="UserName"size="20px"> <br/>
UserId <br/>
<input type="text" name="UserId"size="20px"> <br/>
Country <br/>
<input type="text" name="Country"size="20px"> <br/>
Password <br/>
<input type="password" name="Password" size="20px"> <br/>
<input type="submit" value="register"> <br/>
<input type="hidden" name="purpose" value="register" >
</form>

</body>
</html>