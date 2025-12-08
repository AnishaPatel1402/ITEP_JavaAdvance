<%@page import="com.todoapp.entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.todoapp.dao.CategoryDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Task</title>
<%@include file="__bootstrap_link.jsp" %>
</head>
<body>

	<div class="container mt-5">
	
		<h1 class="text-success mt-5 text-center">Add Task</h1>
		
		<%@include file="__navbar.jsp" %>
		
		<form action="controller/addTaskController.jsp" method="post">
            
            <div class="form-group pt-3">
                <label for="title">Task title</label>
                <input type="text" class="form-control" id="title" 
                    placeholder="Enter task title" name="title">
            </div>
            
            <div class="form-group pt-3">
                <label for="description">Task description</label>
                <textarea placeholder="Enter task description" name="description" id="description" class="form-control"></textarea>
            </div>
            
            <% List<Category> list = CategoryDao.getCategoryList(); %>
            
            <div class="form-group pt-3">
                <label >Select Task Category</label>
                <select  class="form-control" name="categoryId">
                	<option value="0">----------Select the Task Category-----------</option>
                	<%for(Category c : list){%>
                		<option value="<%= c.getId()%>"><%= c.getTaskCategory() %></option>
                	<% } %>
                	
                </select>
            </div>
            
            
            <div class="form-group">
            <label >Select Task Priority</label>
				<select class="form-control" name="priority">
					<option value="High">High</option>
					<option value="Medium">Medium</option>
					<option value="Low">Low</option>
				</select>
			</div>
			
			<div class="form-group">
			<label >Select End Date of Task</label>
				<input name="endDate" type="date" class="form-control" />
			</div>
           
            <button type="submit" class="btn bg-success text-white">
                Add Task
            </button>
        </form>
	</div>

</body>
</html>