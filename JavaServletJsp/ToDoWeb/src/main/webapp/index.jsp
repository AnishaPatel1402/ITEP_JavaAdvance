<%@page import="jakarta.persistence.EntityManagerFactory"%>
<%@page import="com.todoapp.utility.JPAUtil"%>
<%@page import="jakarta.persistence.EntityManager"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Admin login</title>
    <meta charset="utf-8">
    <meta name="viewport" 
        content="width=device-width, initial-scale=1">
   	<%@include file="__bootstrap_link.jsp" %>
</head>
<body>
    <h1 class="text-success text-center mt-5">
       ToDo Admin Login
    </h1>
    <div class="container">
        <form action="controller/adminLogin.jsp" method="post">
            
            <div class="form-group">
                <label for="email">Email Id:</label>
                <input type="email" class="form-control" id="email" 
                    placeholder="Enter Email Id" name="email">
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" 
                    placeholder="Enter Password" name="password">
            </div>
            <div class="form-group form-check">
                <label class="form-check-label">
                    <input class="form-check-input" type="checkbox" 
                        name="remember"> 
                        Remember me
                </label>
            </div>
            <button type="submit" class="btn bg-success text-white">
                Login
            </button>
        </form>
    </div>
</body>
</html>
