<%@page import="com.js.dto.Vehicle"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image: url(https://preview.redd.it/a3v6a1rdb9841.jpg?width=640&crop=smart&auto=webp&s=04c8dbed4ddc10fe2338dfb6da8c809ee3f348c6);background-size: cover;">
	<body>
    <div style="display: flex; flex-direction: column; width: 110vh; justify-content: center;align-items: center;margin: 100px;color: rgb(33, 33, 7); border: 0px solid black; border-top-left-radius: 50px;border-bottom-right-radius: 50px;/*background-color: rgb(149, 205, 205)*/;margin-left: 250px;">
        <h1 style="color: white"><u> AVAILABEL LIST OF VEHICLE</u></h1>
        <table border="3px solid black" style="border-radius: 10px; margin-bottom: 30px; background-color: rgb(243, 255, 255);">
        <tr>
            <th style="padding: 10px;">ID</th>
            <th style="padding: 10px;">VEHICLE</th>
            <th style="padding: 10px;">COLOR</th>
            <th style="padding: 10px;">CC</th>
            <th style="padding: 10px;">MILAGE</th>
            <th style="padding: 10px;">NO_OF_SEAT</th>
            <th style="padding: 10px;">UPDATE</th>
            <th style="padding: 10px;">DELETE</th>
        </tr>
        <%ArrayList<Vehicle> vh=(ArrayList)request.getAttribute("data");
        for(Vehicle veh: vh){%>
        <tr>
            <td><%=veh.getVid() %></td>
            <td><%= veh.getVname()%></td>
            <td><%= veh.getVcolor()%></td>
            <td><%=veh.getCc() %></td>
            <td><%=veh.getMilage() %></td>
            <td><%=veh.getNoseat() %></td>
            <td ><button style="font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif; margin-left: 10px;"><a href="update1?id=<%=veh.getVid() %>" style="text-decoration: none;color: blue;">UPDATE</a></button></td>
            <td><button style="font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;margin-left: 10px;"><a href="delete?id=<%=veh.getVid() %>" style="text-decoration: none;color: rgb(255, 0, 0);">DELETE</a></button></td>
        </tr>
        <%} %>
    </table>
</div>
    <h2 style="text-align: center;"><a href="home.html"><input type="button" value="HOME"></a></h2>
</body>
</html>