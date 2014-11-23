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
          <a class="navbar-brand" href="#">IPL PORTAL</a>
        </div>
      </div>
    </nav>

 
    <div class="container">
      <h2>Login</h2>
      <form action="Home" method="post" role="form">
        <div class="form-group">
          <label for="email">UserId:</label>
          <input type="text" class="form-control" name="UserId" id="email" placeholder="Enter UserId">
        </div>
        <div class="form-group">
          <label for="pwd">Password:</label>
          <input type="password" name="Password" class="form-control" id="pwd" placeholder="Enter password">
        </div>

		<div class="form-group">
	        <select type="text" name="LoginAs" class="form-control" id="pwd" placeholder="type">
			  <option>p</option>
			  <option>t</option>
			  <option>a</option>
			</select>
		</div>        
        <div class="checkbox">
          <label><input type="checkbox"> Remember me</label>
        </div>
        <button type="submit" value="login" class="btn btn-default">Submit</button> 
		<input type="hidden" name="purpose" value="login" >
      </form>
    </div>


    <div class="container">
      <h2>Player Register</h2>
      <form action="Player" method="post" role="form">
        <div class="form-group">
          <label for="email">UserId:</label>
          <input type="text" class="form-control" name="UserId" id="email" placeholder="Enter UserId">
        </div>
        <div class="form-group">
                <div class="form-group">
          <label for="email">UserName:</label>
          <input type="text" class="form-control" name="UserName" id="email" placeholder="Enter UserName">
        </div>
        <div class="form-group">
                <div class="form-group">
          <label for="email">Country:</label>
          <input type="text" class="form-control" name="Country" id="email" placeholder="Enter Country">
        </div>
        <div class="form-group">
          <label for="pwd">Password:</label>
          <input type="password" name="Password" class="form-control" id="pwd" placeholder="Enter password">
        </div>

<button type="submit" value="register" class="btn btn-default">Register</button>
<input type="hidden" name="purpose" value="register" >
      </form>
    </div>




    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
 
</body>
</html>