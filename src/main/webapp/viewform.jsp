<%@page import="com.js.dto.Vehicle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image: url(https://images.unsplash.com/photo-1577801601678-3b379e670f9d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80);background-size: cover;">
	>
	<div style="margin: 100px 500px;">
		<div style="display: flex; flex-direction: column; height: 500px; width: 400px; border-radius: 15px; background-color: black; color: darkcyan; align-items: center; justify-content: center; border: 2px solid black;">
			<h2>FILL THE DETAILS</h2>
			<%Vehicle v=(Vehicle)request.getAttribute("veh"); %>
			<form action="update2">
				<label for="id" style="margin: 10px;">ID :</label> <input
					type="number" name="id" id="" placeholder="enter unique NO" value="<%=v.getVid()%>"><br>
				<br> <label for="name" style="margin: 10px;">VEHICLE_NAME
					:</label> <input type="text" name="name" id="" value="<%=v.getVname()%>"><br>
				<br> <label for="age" style="margin: 10px;">COLOR :</label> <input
					type="text" name="color" value="<%=v.getVcolor()%>"><br>
				<br> <label for="phno" style="margin: 10px;">CC :</label> <input
					type="number" name="cc" value="<%=v.getCc()%>"><br>
				<br> <label for="email" style="margin: 10px;">MILAGE :</label>
				<input type="number" name="milage" id="" value="<%=v.getMilage()%>"><br>
				<br> <label for="insta" style="margin: 10px;">NO_OF_SEAT:</label>
				<input type="text" name="nos" value="<%=v.getNoseat()%>"><br>
				<br> <input type="submit" value="UPDATE">
			</form>
		</div>
</body>
</html>