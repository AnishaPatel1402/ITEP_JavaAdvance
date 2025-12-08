<%@page import="com.todoapp.entity.Task"%>
<%@page import="java.util.List"%>
<%@page import="com.todoapp.dao.TaskDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Task</title>
<%@include file="__bootstrap_link.jsp"%>
</head>
<body>

	<div class="container-fluid mt-5">
		<h1 style="color: green; text-align: center;">View all Task</h1>
		<%@include file="__navbar.jsp"%>
		
		
		<%List<Task> list = TaskDao.getTaskList();
			int i = 1;
		%>
		
		<table class="table table-striped">
			<tr>
				<th>Sno.</th>
				<th>Task Id</th>
				<th>Title</th>
				<th>Description</th>
				<th>Created Date</th>
				<th>End Date</th>
				<th>Task Priority</th>
				<th>Task Status</th>
				<th>Task Category</th>
				<th>User Id</th>
				<th>Action</th>
			</tr>
			
			<%
			for(Task t : list){ %>
				<tr>
					<td><%=i++%></td>
					<td><%=t.getId()%></td>
					<td><%=t.getTitle()%></td>
					<td><%=t.getDescription() %></td>
					<td><%=t.getCreatedDate() %></td>
					<td><%=t.getEndDate()%></td>
					<td><%=t.getPriority() %></td>
					<td><%=t.getStatus()%></td>
					<td><%=t.getCategory().getTaskCategory()%></td>
					<td><%=t.getUser()%></td>
					
					<td><a href="controller/deleteTaskController.jsp?id=<%=t.getId()%>" onclick="return confirm('Are you sure ?')">
						<button class="btn btn-danger">Delete</button>
				</a> <a href="edit_task.jsp?id=<%=t.getId()%>">
						<button class="btn btn-warning text-white">Edit</button>
				</a></td>
					
				</tr>
			<% }
			%>
			
		</table>
		
	</div>

</body>
</html>