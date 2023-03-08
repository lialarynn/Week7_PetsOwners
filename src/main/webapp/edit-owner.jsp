<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit existing Owner</title>
</head>
<body>
	<form action="editOwnerServlet" method="post">
		<h2> Change your personal information </h2>
		
		Please enter the following information below: <br />
		<input type="hidden" name="ownerId" value="${ownerToEdit.ownerId}">
		 	Your name: <input type="text" name="name" value="${ownerToEdit.name}"> <br />
			Your birthday: 	<input type="text" name="month" placeholder="mm" size="4" value="${month}">  
						<input type="text" name="day" placeholder="dd" size="4" value="${date}">
						<input type="text" name="year" placeholder="yyyy" size="4" value="${year}"> <br />
						<input type="submit" value="Update Owner"> <!--Julie added-->
	</form> <br/>
</body>
</html>