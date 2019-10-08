<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit band name</title>
</head>
<body>
<form action = "editBandServlet" method="post">
		Band name: <input type ="text" name = "bandName" value="${bandToEdit.bandName}">
		<input type = "hidden" name = "id" value="${bandToEdit.id}">
		<input type = "submit" value="Save Edited Band">
	</form>
</body>
</html>