<%@page import="com.todoapp.entity.Category"%>
<%@page import="com.todoapp.dao.CategoryDao"%>
<jsp:useBean id="category" class="com.todoapp.entity.Category"></jsp:useBean>
<jsp:setProperty property="id" name="category"/>
<%
	String methodType = request.getMethod();
	if(methodType.equalsIgnoreCase("GET")){
		if(CategoryDao.deleteCategory(category)){%>
			<script>
	         window.alert("Category deleted successfully...");
	         window.location.href="../view_category.jsp";
	       </script>
		<%}
	} else{
		out.print("Method is not Get");
	}
%>