<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of all owners</title>
</head>
<body>
	<form method="post" action="navigationServlet">
		List of all owners
		<table>
			<c:forEach items="${requestScope.allOwners}" var="currentowner">
				<tr>
					<td><input type="radio" name="petId" value="${currentowner.ownerId}"></td>
					<td>${currentowner.name} | </td>
					<td>${currentowner.birthday} | </td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Edit" name="doThisToOwners">
		<input type="submit" value="Delete" name="doThisToOwners">
		<input type="submit" value="Add" name="doThisToOwners">
		<br/>
	</form>
</body>
</html>