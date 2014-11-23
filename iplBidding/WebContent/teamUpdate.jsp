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
          <a class="navbar-brand" href="teamHomeOff.jsp">HOME</a> </div>
        <div id="navbarCollapse" class="collapse navbar-collapse">
      <a class="navbar-brand pull-right" href="logout.jsp">LOGOUT</a> </div>
    </nav>


    <div class="container">
	<h2 class="text-center"> Hi , <%=request.getParameter("teamName") %></h2>
    </div>


<div class="container">
      <h2>Update Details</h2>
      <form action="TeamOff" method="post" role="form">
        <div class="form-group">
          <label for="email">Teamname:</label>
          <input type="text" class="form-control" name="TeamName" id="email" placeholder="Enter TeamName">
        </div>
        <div class="form-group">
          <label for="pwd">Stadium:</label>
          <input type="text" name="Stadium" class="form-control" id="pwd" placeholder="Enter Stadium">
        </div>
        <div class="form-group">
          <label for="pwd">Owner:</label>
          <input type="text" name="Owner" class="form-control" id="pwd" placeholder="Enter Owner">
        </div>
        <button type="submit" value="Update" class="btn btn-default">Submit</button> 
		<input type="hidden" name="purpose" value="update" >
      </form>
</div>





</body>
</html>