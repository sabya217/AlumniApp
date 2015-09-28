<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alumni registration page</title>
</head>
<body>
	<%
		out.println("<h4>Registration unsuccessful!</h4>"+(String)request.getAttribute("message"));
		String userId=request.getParameter("userId");
		String userName=request.getParameter("userName");
		String course=request.getParameter("course");
		String year=request.getParameter("year");
		String phoneNo=request.getParameter("phoneNo");
	%>
	
	<form action="Office" method="post">
		<br>User Id*: <input type="text" name="userId" value=<%=userId %>>
		<br>User Name*: <input type="text" name="userName" value=<%=userName %>>
		<br>Year of passing*: <input type="text" name="year" value=<%=year %>>
		<br>Specialization: <input type="text" name="course" value=<%=course %>>
		<br>Phone No: <input type="text" name="phoneNo" value=<%=phoneNo %>>
		<br><input type="submit" value="submit">
	</form>
	<p>Click  <a href="welcome.html">here</a> to go back home.</p>
</body>
</html>