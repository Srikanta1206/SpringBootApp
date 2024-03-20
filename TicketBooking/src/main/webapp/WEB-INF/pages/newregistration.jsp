<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.table{
margin-left: 40%;
}
.container{
margin: center;
background-color: transparent;

}
</style>
</head>
<body>
<div class="container">
<h2>Wel-Come to Sign up page</h2>
</div>
<table class="table" style="align-content: center;">
<spring:form action="./register" modelAttribute="customer">
<tr>
<td>Enter Full Name</td>
<td><spring:input path="name"/></td>
</tr>
<tr>
<td>Enter Name</td>
<td><spring:input path="name"/></td>
</tr>
<tr>
<td>Enter password</td>
<td><spring:input path="password"/></td>
</tr>
<tr>
<td>Enter Username</td>
<td><spring:input path="username"/></td>
</tr>
<tr>
<td>Enter Contact</td>
<td><spring:input path="contact"/></td>
</tr>
<tr>
<td>Enter Mail</td>
<td><spring:input path="email" type="email"/></td>
</tr>

<tr>
<td><input type="submit"></td>
<td><input type="reset"></td>
</tr>
</spring:form>
</table>
</body>
</html>