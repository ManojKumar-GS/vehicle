<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image: url(https://images.unsplash.com/photo-1619335680796-54f13b88c6ba?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80);background-size: cover;">
	<%String s=(String)session.getAttribute("login");
	if(s!=null){%>
<div style="margin: 100px 500px;">
    <div style="display: flex; flex-direction: column;height: 500px; width: 400px;border-radius: 15px; background-color: black; color: darkcyan; align-items: center; justify-content: center; border: 2px solid black; ">
        <h2 >FILL THE DETAILS</h2>
        <form action="insert">
        <label for="id" style="margin: 10px;">ID :</label> 
        <input type="number" name="id" id="" placeholder="enter unique NO"><br><br>
        <label for="name"  style="margin: 10px;">VEHICLE NAME :</label>
        <input type="text" name="name" id=""><br><br>
        <label for="age" style="margin: 10px;">COLOR :</label>
        <input type="text" name="color"><br><br>
        <label for="phno" style="margin: 10px;">CC :</label>
        <input type="number" name="cc"><br><br>
        <label for="email" style="margin: 10px;">MILAGE :</label>
        <input type="text" name="milage" id=""><br><br>
        <label for="insta" style="margin: 10px;">NO OF SEAT :</label>
        <input type="number" name="nos"><br><br>
        <input type="submit" value="REGISTER">
        </form>
    </div>
</div><%}else{ 
 response.sendRedirect("login.html");
} %>
</body>
</html>