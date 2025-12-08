
<%@page import="com.todoapp.dao.CategoryDao"%>
<jsp:useBean id="category" class="com.todoapp.entity.Category"></jsp:useBean>
<jsp:setProperty name="category" property="*"></jsp:setProperty>

<%
	String methodType = request.getMethod();
	if(methodType.equalsIgnoreCase("POST")){
		if(CategoryDao.addCategory(category)){%>
			<script>
	         window.alert("Category saved successfully...");
	         window.location.href="../add_category.jsp";
	       </script>
		<%} else{
			out.print("category not added");
		}
	}else{
		out.print("Method is not Post");
	}
%>