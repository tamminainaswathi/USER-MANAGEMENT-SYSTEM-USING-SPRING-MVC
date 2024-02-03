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

	<%
    Student s = (Student) request.getAttribute("student");
    if (s == null) {
%>

    <h1>Student Registration form</h1>
    <form action="reg" method="post">
        <div hidden>
            <input type="number" name="tbid">
        </div>
        Name: <input type="text" name="tbname"><br><br>
        Email: <input type="email" name="tbemail"><br><br>
        Password: <input type="password" name="tbpass"><br><br>
        Mobile: <input type="tel" name="tbmbl"><br><br>
        <input type="submit" name="btnreg" value="Click Here">
    </form>
    <%= request.getAttribute("res") %>

<%
    }
    if(s != null) {
%>

    <center>
        <h2>Student Edit Form here</h2>
        <form action="update" method="post">
            <div hidden>
                <input type="number" name="tbid" value="<%=s.getId()%>">
            </div>
            Name: <input type="text" name="tbname" value="<%=s.getName()%>"><br><br>
            Email: <input type="email" name="tbemail" value="<%=s.getEmail()%>"><br><br>
            Password: <input type="password" name="tbpass" value="<%=s.getPass()%>"><br><br>
            Mobile: <input type="tel" name="tbmbl" value="<%=s.getMobile()%>"><br><br>
            <input type="submit" name="btnreg" value="Click Here">
            <%= request.getAttribute("res") %>
        </form>
    </center>

<%
    }
%>
</body>
</html>