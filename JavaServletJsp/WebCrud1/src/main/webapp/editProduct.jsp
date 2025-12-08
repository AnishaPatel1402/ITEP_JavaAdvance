<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<ul>
		<li><a href="./ViewProductServlet">viewAllProduct</a></li>
	</ul>
	<% int id = Integer.parseInt(request.getParameter("id")); %>
	<form method="post" action="./EditProductSevlet">
		
		<p>
			<input name='id' type="text" value="<%= id %>" />
		</p>
	
		<p>
			<input name='title' type="text" placeholder="Enter product title" />
		</p>
		<p>
			<input name="price" type="text" placeholder="Enter product price" />
		</p>
		<p>
			<input name="brand" type="text" placeholder="Enter Brand" />
		</p>
		<p>
			<button type="submit">Update</button>
		</p>
	</form>

</body>
</html>