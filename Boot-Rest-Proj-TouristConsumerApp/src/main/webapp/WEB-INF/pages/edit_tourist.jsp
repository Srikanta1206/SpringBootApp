<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: red; text-align: center;">Edit Tourist Details</h1>
	<table align="center">
		<form:form modelAttribute="tourist">
			<tr>
				<td>Tourist ID</td>
				<td><form:input path="tId" readonly="true" /></td>
			</tr>
			<tr>
				<td>Enter Name</td>
				<td><form:input path="tName" /></td>
			</tr>
			<tr>
				<td>Enter Age</td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td>Enter Address</td>
				<td><form:input path="tAddress" /></td>
			</tr>
			<tr>
				<td>Enter ContactNo</td>
				<td><form:input path="contactNo" /></td>
			</tr>
			<tr>
				<td>Enter Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Enter JourneyStarts</td>
				<td><form:input path="journeyStarts" readonly="true" /></td>
			</tr>
			<tr>
				<td>Enter JourneyEnds</td>
				<td><form:input path="journeyEnds" readonly="true" /></td>
			</tr>
			<tr>
				<td>Enter Budget</td>
				<td><form:input path="budget" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</form:form>
	</table>
</body>
</html>