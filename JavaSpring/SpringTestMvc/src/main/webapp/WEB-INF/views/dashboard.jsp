<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<%@include file="__bootstrap.jsp"%>

</head>
<body>
	<div class="container">
		
		<%@ include file="__header.jsp" %>
		
		<h1>Admin Dashboard</h1>
		<%
		String currAdmin = (String) session.getAttribute("currAdmin");
		%>
		<h2>
			Current Admin :
			<%=currAdmin%></h2>
		
	</div>

</body>
</html>