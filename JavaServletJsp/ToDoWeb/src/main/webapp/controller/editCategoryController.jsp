<%@page import="com.todoapp.entity.Category"%>
<%@page import="com.todoapp.dao.CategoryDao"%>
<jsp:useBean id="category" class="com.todoapp.entity.Category"></jsp:useBean>
<jsp:setProperty property="*" name="category"/>
<%
String methodType = request.getMethod();
if(methodType.equalsIgnoreCase("POST")){
		if(CategoryDao.updateCategory(category)){%>
			<script>
	         window.alert("Category udated successfully...");
	         window.location.href="../view_category.jsp";
	       </script>
		<%} else {
			out.print("couldn't update");
		}
} else{
	out.print("Method is not Get");
}
%>