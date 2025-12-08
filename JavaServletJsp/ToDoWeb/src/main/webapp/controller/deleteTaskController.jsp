<%@page import="com.todoapp.dao.TaskDao"%>
<jsp:useBean id="task" class="com.todoapp.entity.Task"></jsp:useBean>
<jsp:setProperty name="task" property="id"></jsp:setProperty>
<% 
String methodType = request.getMethod();
if(methodType.equalsIgnoreCase("GET")){
	if(TaskDao.deleteTask(task)){%>
<script>
         window.alert("Task deleted successfully...");
         window.location.href="../view_task.jsp";
       </script>
<%}
} else{
	out.print("Method is not Get");
}
%>