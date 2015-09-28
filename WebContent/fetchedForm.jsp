<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User info</title>
</head>
<%@ page import="org.practice.webapp.dto.UserDetails" %>
<body>
<% 
	UserDetails details = (UserDetails)request.getAttribute("details");
	String userName = (String)request.getAttribute("userName");
	Integer year = (Integer)request.getAttribute("year");
%>
	<h3><u>User details</u></h3>
	<p>
	Name : <b><%=userName %></b>
	<br>Year : <b><%=year %></b>
	<br>Description : <%=details.getDescription() %>
	</p>
	<p>
	Geek quotient : <%=details.getGeek().getFeature() %>
	<br>Fun quotient : <%=details.getFun().getFeature() %>
	<br>Sports quotient : <%=details.getSports().getFeature() %>
	</p>
	<p>Click  <a href="welcome.html">here</a> to go back home.</p>
</body>
</html>