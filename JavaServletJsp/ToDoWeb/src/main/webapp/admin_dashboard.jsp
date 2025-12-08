<!DOCTYPE html>
<html lang="en">
<head>
    <title>Admin Dashboard</title>
    <meta charset="utf-8">
    <meta name="viewport" 
        content="width=device-width, initial-scale=1">
    <%@include file="__bootstrap_link.jsp" %>
</head>
<body>
    <div class="container mt-5">
        <h1 style="color:green;text-align:center;">
            Admin Dashboard
        </h1>
        <%@include file="__navbar.jsp" %>
        
          <% String adminEmail = (String) session.getAttribute("adminEmail"); %>
        
        	<h2 class="text-center text-success mt-5">Welcome, <%= adminEmail%></h2>
       
    </div>
</body>
</html>