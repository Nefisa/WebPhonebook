
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration to PBApp</title>
</head>
<body>

To register to Phonebook Application, please fill fields below:

<form action="RegistrationController" method="post">
<br>Enter your first name: <input type="text" name="firstName"  />
<br>Enter your last name: <input type="text" name="lastName"  />
<br>Enter your password: <input type="password" name="password"  />
<br><input type="submit" value="Register" />
</form>


</body>
</html>