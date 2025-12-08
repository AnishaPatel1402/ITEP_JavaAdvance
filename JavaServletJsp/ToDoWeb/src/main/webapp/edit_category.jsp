
<%@page import="com.todoapp.entity.Category"%>
<%@page import="com.todoapp.dao.CategoryDao"%>

<jsp:useBean id="category" class="com.todoapp.entity.Category"></jsp:useBean>
<jsp:setProperty property="id" name="category"/>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Category</title>
<%@include file="__bootstrap_link.jsp" %>
</head>
<body>

	<% Category cat = CategoryDao.fetchCategoryById(category); %>

	<div class="container mt-5">
	<h1 class="text-success mt-5 text-center">Edit Category</h1>
	<%@include file="__navbar.jsp" %>
		
		<form action="controller/editCategoryController.jsp" method="post">
            
            <div class="form-group pt-3">
            	
            	<!-- this we keep hidden because id is not get update  -->
            	<input type="hidden" name="id" value="<%=cat.getId() %>"/> <br>
            
                <label for="category" >Task Category</label>
                <input type="text"  value="<%= cat.getTaskCategory() %>" class="form-control" id="category" 
                    placeholder="Enter task category name" name="taskCategory">
            </div>
           
            <button type="submit" class="btn bg-success text-white">
                Update Category
            </button>
        </form>
	</div>
	
</body>
</html>