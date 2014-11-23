<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=200, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>

<div class="container">

<form action="BidStatus" method="post" role="form">

		<div class="form-group">
          <label for="email">New Bid:</label>
          <input type="text" class="form-control" name="bidAmount" id="email" placeholder="Enter bidAmount">
        </div>
        
<center><button type="submit" value="Bid" class="btn btn-default btn-lg">Bid</button></center>


<input type="hidden" name="purpose" value="newBid" >
</form>
</div>
</body>
</html>
