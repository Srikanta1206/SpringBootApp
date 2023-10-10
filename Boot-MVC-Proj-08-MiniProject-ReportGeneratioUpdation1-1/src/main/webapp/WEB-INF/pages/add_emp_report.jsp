<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
				<td>Enter name</td>
				<td><form:input path="ename"/><form:errors path="ename" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td>Enter Desgiation</td>
				<td><form:input path="desg" /><form:errors path="desg" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td>Enter sal</td>
				<td><form:input path="sal" /><form:errors path="sal" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td>Enter Deptno</td>
				<td><form:input path="deptno"/><form:errors path="deptno" cssStyle="color:red"/></td>
			</tr>

			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form:form>
	<a href="?lang=hi_IN">Hindi</a>
</body>
</html>