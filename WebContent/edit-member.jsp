<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Band Member Page</title>
</head>
<body>
	<form action = "EditMemberServlet" method="post">
		Member name: <input type ="text" name = "memberName" value="${memberToEdit.memberName}">
		Member Role: <input type="text" name = "memberRole" value="${memberToEdit.memberRole}">
		<input type = "hidden" name = "id" value="${memberToEdit.memberId}">
		<input type = "submit" value="Save Edited Member">
	</form>

</body>
</html>