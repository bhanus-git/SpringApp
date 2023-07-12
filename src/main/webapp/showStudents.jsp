<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.jpa.demo.SpringApp.Student"%>

<% Iterator<Student> studentItr= (Iterator) request.getAttribute("student"); %>

<% while(studentItr.hasNext())
	{
	   out.println(studentItr.next());
	   out.print("<br>");
	}
	%>
<%-- <ul>
<c:forEach var="item" items="${obj}" >
    <li>${item}</li>
</c:forEach>
</ul> --%>
</body>
</html>