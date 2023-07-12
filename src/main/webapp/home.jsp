<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form action="addStudent">
     <input type="text" name="sid"/><br>
     <input type="text" name="sname"/><br>
     <input type="text" name="course"/><br>     
     <input type="submit"/>
   </form>
   
   <form action="getStudent">
     <input type="text" name="sid"/><br>
     <input type="submit" value="Search..."/>
   </form>
   
   <form action="getAllStudents">
      <input type="submit" value=" Get ALL Students..."/>
   </form>
   
</body>
</html>