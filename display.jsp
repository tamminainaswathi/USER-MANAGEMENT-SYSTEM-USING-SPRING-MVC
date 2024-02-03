<%@page import="java.util.ArrayList"%>
<%@page import="com.techpalle.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>student details</h1>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Mobile</th>
			<th>Action</th>
		
		</tr>
		
		<%ArrayList<Student> al=(ArrayList<Student>) request.getAttribute("lst"); 
		
		for(Student s:al){
			%>
			
			<tr>
				<td><%=s.getId()%></td>
				<td><%=s.getName() %></td>
				<td><%=s.getEmail() %></td>
				<td><%=s.getPass()%></td>
				<td><%=s.getMobile()%></td>
				<td><a href="edit?id=<%=s.getId()%>">EDIT</a>
					<a href="delete?id=<%=s.getId()%>">DELETE</a>
				</td>
			</tr>
	
	
	<%} %>
	</table>
</body>
</html>