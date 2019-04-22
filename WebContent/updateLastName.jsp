<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Last Name</title>
</head>
<body>

Please fill in:
<form action="LastNameController" method="post">
<br>Enter person's ID: <input type="text" name="personID" />
<br>Enter person's new last name: <input type="text" name="lastName" />
<br> <input type="submit" value="Submit" />
</form>

</body>
</html>