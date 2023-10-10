<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
				<td><spring:message code="com.cust.name" /></td>
				<td><form:input path="empno" readonly="true" /></td>
			</tr>
			<tr>
				<td>Enter Employee Name</td>
				<td><form:input path="ename" /><br> <form:errors
						path="ename" cssStyle="color:red" /><span id="enameErr"></span></td>
			</tr>
			<tr>
				<td><spring:message code="com.cust.desg" /></td>
				<td><form:input path="desg" /><br> <form:errors
						path="desg" cssStyle="color:red" /><span id="desgErr"></span></td>
			</tr>
			<tr>
				<td><spring:message code="com.cust.sal" /></td>
				<td><form:input path="sal" /><br> <form:errors path="sal"
						cssStyle="color:red" /><span id="salErr"></span></td>
			</tr>
			<tr>
				<td><spring:message code="com.cust.deptno" /></td>
				<td><form:input path="deptno" /><br> <form:errors
						path="deptno" cssStyle="color:red" /><span id="deptnoErr"></span>
					</form></td>
			</tr>

			<tr>
				<td><input type="submit" onclick="client side validation"></td>
			</tr>
		</table>
	</form:form>
	<a href="?lang=en_US">English</a>
	<a href="?lang=od_IN">Odia</a>
	<a href="?lang=hi_IN">Hindi</a>
	<a href="?lang=de_DE">German</a>
	<a href="?lang=zh_CN">Chinese</a>
	<a href="?lang=jpn_JA">Japanese</a>
	<div class=home>
		<h1 style="color: red; text-align: center">
			<a href="./">Home</a>
		</h1>
	</div>
</body>
</html>