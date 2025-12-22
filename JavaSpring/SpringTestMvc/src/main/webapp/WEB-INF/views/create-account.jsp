<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Account</title>
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
		<form action="${pageContext.request.contextPath}/admin/signup" method="post" class="form-control form-container ">
			<div class="d-flex justify-content-center align-items-center bg-primary form-group">
				<h2 class="text-white bg-primary">Sign Up</h2>
			</div>
			<div class="form-group">
				<input type="email" placeholder="enter your email" name="email">
			</div>

			<div class="form-group">
				<input type="password" placeholder="enter your password" name="password">
			</div>
			
			<div class="form-group">
				<button type="submit" class="btn btn-primary text-white ml-10">Register</button>
			</div>
			
			<a href="${pageContext.request.contextPath}/home" class="mb-5">Already have account</a>
		</form>
	</div>
</body>
</html>