<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Category</title>
<%@include file="__bootstrap_link.jsp" %>
</head>

<body>
	
	
	<div class="container mt-5">
	<h1 class="text-success mt-5 text-center">Add Category</h1>
	
	<%@include file="__navbar.jsp" %>
		
		<form action="controller/addCategoryController.jsp" method="post">
            
            <div class="form-group pt-3">
                <label for="category">Task Category</label>
                <input type="text" class="form-control" id="category" 
                    placeholder="Enter task category name" name="taskCategory">
            </div>
           
            <button type="submit" class="btn bg-success text-white">
                Add Category
            </button>
        </form>
	</div>
</body>
</html>