<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<%@include file="__bootstrap.jsp"%>

<style>
.form-container {
	min-height: 250px;
	width: 35%;
}
input{
	width: 100%;
}
</style>
</head>
<body>
	<div
		class="container vh-100 d-flex justify-content-center align-items-center">
		<form action="${pageContext.request.contextPath}/admin/signin" method="post" class="form-control form-container">
			<div class="d-flex justify-content-center align-items-center bg-primary form-group">
				<h2 class="text-white">Sign In</h2>
			</div>
			<div class="form-group">
				<input type="email" placeholder="enter your email" name="email">
			</div>

			<div class="form-group">
				<input type="password" placeholder="enter your password" name="password">
			</div>
			
			<div class="form-group">
				<button type="submit" class="btn btn-primary text-white ml-10">Login</button>
			</div>
			
			<a href="${pageContext.request.contextPath}/create-new-account" class="mb-5">Create new account</a>
		</form>
		
		
		
	</div>
</body>
</html>