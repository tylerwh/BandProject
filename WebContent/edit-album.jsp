<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Album Page</title>
</head>
<body>
	<form action = "EditAlbumServlet" method="post">
		Album name: <input type ="text" name = "albumName" value="${albumToEdit.albumName}">
		Release Date: <input type="text" name = "releaseDate" value="${albumToEdit.releaseDate}">
		<input type = "hidden" name = "id" value="${albumToEdit.albumId}">
		<input type = "submit" value="Save Edited Album">
	</form>

</body>
</html>