<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=200, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<title>Insert title here</title>
</head>
<body>


    <nav class="navbar navbar-default">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="playerHome.jsp">HOME</a> </div>
        <div id="navbarCollapse" class="collapse navbar-collapse">
      <a class="navbar-brand pull-right" href="logout.jsp">LOGOUT</a> </div>
    </nav>


<center>
<form action="Player" method="post">
<button type="submit" name="PlayerStats" class="btn btn-info btn-lg">Statistics</button> 
<input type="hidden" name="purpose" value="playerStats" >
</form>
</center>
</body>
</html>