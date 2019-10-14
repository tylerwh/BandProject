<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Bands</title>
</head>
<body>
<form method = "post" action = "BandNavigationServlet">
	<table>
		<c:forEach items="${requestScope.allBands}" var="currentBand">
		<tr>
		 <td><input type="radio" name="id" value="${currentBand.bandId}"></td>
		 <td>${currentBand.bandName}</td>
		 </tr>
		</c:forEach>
	</table>
		<input type = "submit" value = "edit" name="doThisToBand">
		<input type = "submit" value = "delete" name="doThisToBand">
		<input type="submit" value = "add" name = "doThisToBand">
	</form>
	<a href="index.html">Go Back!</a><br />
	<a href = "viewAllAlbumsServlet">View all albums</a><br />
	<a href = "viewAllBandMembersServlet">View all band members</a><br />
</body>
</html>