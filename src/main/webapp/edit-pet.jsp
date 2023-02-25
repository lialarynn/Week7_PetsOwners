<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="editPetServlet" method="post">
		<h2> Let's change that pet's information </h2>
		
		Please enter the following information below: <br />
		 	Pet's Name: <input type="text" name="name" value="${petToEdit.name}"> <br />
			Birthday: 	<input type="text" name="month" placeholder="mm" size="4" value="${month}"> 
						<input type="text" name=day placeholder="dd" size="4" value="${day}">
						<input type="text" name="year" placeholder="yyyy" size="4" value="${year}"> <br />
			Weight: 	<input type="number" name="weight" value="${petToEdit.weight}" step="any" /> <br />
			
			<label for="gender">Gender:</label>
 				<select name="gender" id="gender">
			 		<option value="male">Male</option>
			 		<option value="female">Female</option>
 				</select>
						<input type="submit" value="Update Pet">
	</form> <br/>
</body>
</html>