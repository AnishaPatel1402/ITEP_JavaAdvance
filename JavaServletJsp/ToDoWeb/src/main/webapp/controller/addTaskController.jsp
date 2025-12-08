<%@page import="com.todoapp.dao.TaskDao"%>
<jsp:useBean id="task" class="com.todoapp.entity.Task"></jsp:useBean>
<jsp:setProperty name="task" property="*"></jsp:setProperty>


<%
String methodType = request.getMethod();
if (methodType.equalsIgnoreCase("POST")) {
	if (TaskDao.addTask(task)) {
%>
<script>
	window.alert("Task saved successfully...");
	window.location.href = "../add_task.jsp";
</script>
<%
} else {
out.print("task not added");
}
} else {
out.print("Method is not Post");
}
%>