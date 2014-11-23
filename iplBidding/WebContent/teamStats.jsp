<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="main.Tuple" %>
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
      <h2>Details</h2>
      <table class="table table-bordered">
        <thead>
        </thead>
        <tbody>
          <tr>
            <td>Name</td>
            <td><%out.println( request.getParameter("teamName"));%></td>
          </tr>
          <tr>
            <td>Stadium</td>
            <td><%out.println( request.getParameter("stadium"));%></td>
          </tr>
          <tr>
            <td>Owner</td>
            <td><%out.println( request.getParameter("owner"));%></td>
          </tr>
        </tbody>
      </table>
    </div>

 <div class="container">
      <h2>Squad</h2>
<table class="table table-striped" id="table_div">
	
	 <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Price</td>
     </tr>

<%  


// retrieve your list from the request, with casting 
java.util.ArrayList<Tuple> list = (java.util.ArrayList<Tuple>)session.getAttribute("players");

// print the information about every category of the list
if(list!=null)
{	
for(Tuple tuple : list) 
{%>
	<tr>
    <td><%out.println(tuple.playerId + " ");%></td>
    <td><%out.println(tuple.playerName+ " " );%></td>
    <td><%out.println(tuple.price + " ");%></td>
	</tr>
<% 
}
}
%>


</table>
</div>

</body>
</html>