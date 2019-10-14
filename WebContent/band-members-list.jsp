<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Band Members List</title>
</head>
<body>
	<form method = "post" action = "MemberNavigationServlet">
	<table>
		<c:forEach items="${requestScope.allMembers}" var="currentMember">
		<tr>
		 <td><input type="radio" name="id" value="${currentMember.memberId}"></td>
		 <td>${currentMember.memberName}</td>
		 <td>${currentMember.memberRole}</td>
		 </tr>
		</c:forEach>
	</table>
		<input type = "submit" value = "edit" name="doThisToMember">
		<input type = "submit" value = "delete" name="doThisToMember">
		<input type="submit" value = "add" name = "doThisToMember">
	</form>
	<a href="index.html">Go Back!</a>
	<a href = "viewAllBandsServlet">View all bands</a>
	<a href = "viewAllAlbumsServlet">View all albums</a><br />
</body>
</html>