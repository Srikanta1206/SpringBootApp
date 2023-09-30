<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#first{
text-align:center;
color:red;
background-color: green;

}
</style>
</head>
<body>

<div id="first">
<h1>Welcome to Registration page</h1>
</div>
<table align="center" color="cyan">
	<form:form modelAttribute="userRole">
		<tr>
			<td>Enter Name</td>
			<td><form:input path="name"/></td>
		</tr>
		<tr>
			<td>Enter Password</td>
			<td><form:input path="pwd"/></td>
		</tr>
		<tr>
			<td>Enter mail</td>
			<td><form:input path="mail" type="mail"/></td>
		</tr>
		<tr>
			<td>Enter contact</td>
			<td><form:input path="contact"/></td>
		</tr>
		<tr>
			<td>Enter Gender</td>
			<td><form:input path="Gender"/></td>
		</tr>
		<tr>
			<td>Choose role</td>
<!-- 			<td> -->
<%-- 				<form:select path="role" multiple="multiple" size="3"> --%>
<%-- 					<form:options items="${rolesinfo }"/> --%>
<%-- 				</form:select> --%>
<!-- 			</td> -->
		<td>
			<form:checkboxes items="${rolesinfo }" path="roles"/>
		</td>
		</tr>
		<tr>
			<td><input type="submit"></td>
		</tr>
	</form:form>
</table>
</body>
</html>