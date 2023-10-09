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
	<h1 style="color: red; text-align: center">Updating Employee
		Details</h1>
	<script type="text/javascript" src="script/validation.js"></script>
	<form:form action="update_detail" modelAttribute="employee"
		onsubmit="return validator(this)">

		<table>
			<tr>
				<td>Enter EmpNo</td>
				<td><form:input path="empno" readonly="true" /></td>
			</tr>
			<tr>
				<td>Enter Employee Name</td>
				<td><form:input path="ename" /><br>
				<form:errors path="ename" cssStyle="color:red" /><span id="enameErr"></span></td>
			</tr>
			<tr>
				<td>Enter Employee Desg</td>
				<td><form:input path="desg" /><br>
				<form:errors path="desg" cssStyle="color:red" /><span id="desgErr"></span></td>
			</tr>
			<tr>
				<td>Enter sal</td>
				<td><form:input path="sal" /><br>
				<form:errors path="sal" cssStyle="color:red" /><span id="salErr"></span></td>
			</tr>
			<tr>
				<td>Enter Deptno</td>
				<td><form:input path="deptno" /><br>
				<form:errors path="deptno" cssStyle="color:red" /><span
					id="deptnoErr"></span>
				</form></td>
			</tr>

			<tr>
				<td><input type="submit" onclick="client side validation"></td>
			</tr>
		</table>
	</form:form>
	<div class=home>
		<h1 style="color: red; text-align: center">
			<a href="./">Home</a>
		</h1>
	</div>
</body>
</html>