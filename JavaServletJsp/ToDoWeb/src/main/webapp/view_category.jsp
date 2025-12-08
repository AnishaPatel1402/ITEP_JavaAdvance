<%@page import="com.todoapp.entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.todoapp.dao.CategoryDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Category</title>
<%@include file="__bootstrap_link.jsp"%>
</head>
<body>

	<div class="container mt-5">
		<h1 style="color: green; text-align: center;">View all categories</h1>
		<%@include file="__navbar.jsp"%>

		<% List<Category> categoryList = CategoryDao.getCategoryList();
			int i = 1;
		%>

		<table class="table table-striped">
			<tr>
				<th>SNO.</th>
				<th>Category ID</th>
				<th>Task Category</th>
				<th>Action</th>
			</tr>

			<% 
				for(Category c: categoryList){%>
			<tr>
				<td><%=i++ %></td>
				<td><%=c.getId() %></td>
				<td><%=c.getTaskCategory() %></td>

				<td><a href="controller/deleteCategoryController.jsp?id=<%=c.getId()%>" onclick="return confirm('Are you sure ?')">
						<button class="btn btn-danger">Delete</button>
				</a> <a href="edit_category.jsp?id=<%=c.getId()%>">
						<button class="btn btn-warning text-white">Edit</button>
				</a></td>


			</tr>
			<%}
			%>

		</table>

	</div>

</body>
</html>