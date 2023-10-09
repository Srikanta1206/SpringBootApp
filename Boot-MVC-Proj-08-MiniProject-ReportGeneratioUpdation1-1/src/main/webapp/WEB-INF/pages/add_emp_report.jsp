<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<h1 style="color: red; text-align: center">Adding new Employee</h1>
	<script type="text/javascript" src="script/validation.js">
	</script>
	<h1>Client side</h1>
	<form:form action="addEmpRecord" modelAttribute="employee" onsubmit="return validator(this)">
		<!-- * = all the form components -->
		<p style="color: red; text-align: center">
			<form:errors path="*" />
		</p>
		<table align=center>
			<tr>
				<td>Enter Employee Name</td>
				<td><form:input path="ename"/><span id="enameErr"></span></td>
			</tr>
			<tr>
				<td>Enter Employee Desg</td>
				<td><form:input path="desg" /><span id=desgErr></span></td>
			</tr>
			<tr>
				<td>Enter sal</td>
				<td><form:input path="sal" /><span id="salErr"></span></td>
			</tr>
			<tr>
				<td>Enter Deptno</td>
				<td><form:input path="deptno"/><span id="deptnoErr"></span></td>
			</tr>

			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>