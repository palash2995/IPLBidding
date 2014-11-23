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
<br/>
Please update your details <br/>
Your teamname was: <%=request.getParameter("teamName") %> <br/>
Teamname <br/>
<input type="text" name="TeamName"size="20px"> <br/>
Stadium <br/>
<input type="text" name="Stadium"size="20px"> <br/>
Owner <br/>
<input type="text" name="Owner"size="20px"> <br/>
<input type="submit" value="Update"> <br/>
<input type="hidden" name="purpose" value="update" >
</form>
<a href="logout.jsp">Logout</a>
</body>
</html>