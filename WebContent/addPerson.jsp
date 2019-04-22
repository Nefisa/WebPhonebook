<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add person to PBAPP</title>
</head>
<body>

Please fill in fields bellow to add person to your phonebook list:

<form action="AddPersonController" method="post">
<br>First Name: <input type="text" name="firstName" />
<br>Last Name: <input type="text" name="lastName"  />
<br>Phone number: <input type="text" name="phone"  />
<br>Mobile number: <input type="text" name="mobile"  />
<br><input type="submit" value="Submit">
</form>


</body>
</html>