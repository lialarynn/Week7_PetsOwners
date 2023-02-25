<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of all pets</title>
</head>
<body>
	<form method="post" action="navigationServlet">
		List of all pets
		<table>
			<c:forEach items="${requestScope.allPets}" var="currentpet">
				<tr>
					<td><input type="radio" name="petId" value="${currentpet.petId}"></td>
					<td>${currentpet.name} | </td>
					<td>${currentpet.birthday} | </td>
					<td>${currentpet.weight} | </td>
					<td>${currentpet.gender} | </td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Edit" name="doThisToPets">
		<input type="submit" value="Delete" name="doThisToPets">
		<input type="submit" value="Add" name="doThisToPets">
		<br/>
	</form>
</body>
</html>