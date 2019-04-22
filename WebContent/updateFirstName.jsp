<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update first name</title>
</head>
<body>

<form action="FirstNameController" method="post">
<br>Insert person's ID: <input type="text" name="personID" />
<br>Insert new first name for person: <input type="text" name="firstName">
<br><input type="submit" value="Submit">
</form>

</body>
</html>