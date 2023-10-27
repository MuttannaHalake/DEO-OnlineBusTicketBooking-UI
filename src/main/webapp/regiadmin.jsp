<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
      body {
            background-image:url('admin.jpg'); 
            background-size: cover;
            background-repeat: no-repeat;
      }


		div
		{
			margin-left: 30%;
			margin-right: 30%;
			margin-top: 5%;
			padding: 3%;
			background-color:white;
		}
		h1{
			text-align: center;
			color: white;
			
		}
		.hi{
		   text-align: center;
		}
		
		
		
		
		
	</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.sql.*" %>
<h1>PASSENGER REGISTRATION DETAILS</h1>
<div>
<%
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/passenger","root","Mbhalake04@");
String st="select * from registration";
PreparedStatement pp=con.prepareStatement(st);
ResultSet rs=pp.executeQuery();
%>
<table border="">
<tr>
<th>UserName</th>
<th>Password</th>
<th>Email</th>

</tr>
<%
while(rs.next())
{%>
<tr>
 
	<td><%out.print(rs.getString(1));%></td>
	<td><%out.print(rs.getString(2));%></td>
	<td><%out.print(rs.getString(3));%></td>
	
	</tr>
<% 
}
con.close();
%>
</table><br>

        <a class="hi" href="admin.jsp">Back</a>
        
    



</div>

</body>
</html>