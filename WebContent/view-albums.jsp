<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Albums</title>
</head>
<body>
	<form method = "post" action = "navigationServlet">
	<table>
		<c:forEach items="${requestScope.allAlbums}" var="currentAlbum">
		<tr>
		 <td><input type="radio" name="id" value="${currentAlbum.albumId}"></td>
		 <td>${currentAlbum.albumName}</td>
		 <td>${currentAlbum.releaseDate}</td>
		 </tr>
		</c:forEach>
	</table>
		<input type = "submit" value = "edit" name="doThisToAlbum">
		<input type = "submit" value = "delete" name="doThisToAlbum">
		<input type="submit" value = "add" name = "doThisToAlbum">
	</form>

</body>
</html>