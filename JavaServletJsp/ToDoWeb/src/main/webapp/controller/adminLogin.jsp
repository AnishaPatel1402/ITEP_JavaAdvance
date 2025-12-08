<%@page import="com.todoapp.dao.AdminDao"%>
<jsp:useBean id="admin"  class="com.todoapp.entity.Admin"></jsp:useBean>
<jsp:setProperty name="admin" property="*"></jsp:setProperty>
<%
	String method = request.getMethod();
	if(method.equalsIgnoreCase("POST")){
		try{
			admin = AdminDao.authenticate(admin);
			//track the admin
			session.setAttribute("adminEmail", admin.getEmail());
			if(admin != null) response.sendRedirect("../admin_dashboard.jsp");
			else out.print("<h1 style='color:red;'>Login Failed</h1>");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	else{
		out.print("Method is not post");
	}
%>