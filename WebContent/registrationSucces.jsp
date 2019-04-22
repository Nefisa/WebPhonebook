<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>


<br>You have successfully registered. Your USER ID number is 
<%=(int) request.getSession().getAttribute("sessionUserID")
%>

<br>Please remember it, as you will use it in the future for logins.

<br>To continue to main menu, click <a href="menu.jsp">here</a>.


</body>
</html>