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
		<input type="hidden" name="petId" value="${petToEdit.petId}">
		 	Pet's Name: <input type="text" name="name" value="${petToEdit.name}"> <br />
			Birthday: 	<input type="text" name="month" placeholder="mm" size="4" value="${month}">  
						<input type="text" name="day" placeholder="dd" size="4" value="${date}">
						<input type="text" name="year" placeholder="yyyy" size="4" value="${year}"> <br />
			Species: 	<input type="text" name="species" value="${petToEdit.species}"> <br />
			Breed:		<input type="text" name="breed" value="${petToEdit.breed}"> <br />
						
			Available Owners:<br />
						<select name="allOwnersToAdd" multiple size="6">
							<c:forEach items="${requestScope.allOwners}" var="currentOwner">
								<option value = "${currentOwner.ownerId}">${currentOwner.name}</option>
							</c:forEach>
						</select> <br />
						<input type="submit" value="Update Pet"> 
	</form> <br/>
</body>
</html>
