<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>
</head>
<body>
	<%
		session.setAttribute("userId",request.getParameter("userId"));
	 %>
	<form action="Updator" method="post">
		<p>Geek Quotient: 
			<select name="geek">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option></option>
			</select>  (3 being the highest)</p>
		<p>Fun Quotient: 
			<select name="fun">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option></option>
			</select> (3 being the highest)</p>
		<p>Sports Quotient: 
			<select name="sports">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option></option>
			</select> (3 being the highest)</p>
		<p>
		<br>Description: <input type="text" name="description">	  
		    Update <input type="checkbox" name="updateMessage">				 
		</p>
		<br><input type="submit" value="Submit">
	</form>
	<p>Click  <a href="welcome.html">here</a> to go back home.</p>
</body>
</html>