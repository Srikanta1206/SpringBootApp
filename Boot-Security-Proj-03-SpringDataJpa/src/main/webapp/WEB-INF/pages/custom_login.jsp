<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:red;text-align:center">Login</h1>

<table>
<form action="/login" method="post">
<tr>
<td>Enter Username</td>
<td><input type="text" name="username"></td>
</tr>
<tr>
<td>Enter Password</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td><input type="submit" value="Login"></td>
</tr>
</form>
</table>
</body>
</html>