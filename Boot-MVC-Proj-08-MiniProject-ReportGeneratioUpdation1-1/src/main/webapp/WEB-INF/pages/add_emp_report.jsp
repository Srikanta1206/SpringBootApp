<%@ page language="java" contentType="text/html; charset=UTF-8"
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
	
	
	<form:form action="addEmpRecord" modelAttribute="employee" onsubmit="return validator(this)">
		<!-- * = all the form components -->
		

		<table align=center>
			<tr>
				<td><spring:message code="com.cust.name"/></td>
				<td><form:input path="ename"/><form:errors path="ename" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td><spring:message code="com.cust.desg"/></td>
				<td><form:input path="desg" /><form:errors path="desg" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td><spring:message code="com.cust.sal"/></td>
				<td><form:input path="sal" /><form:errors path="sal" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td><spring:message code="com.cust.deptno"/></td>
				<td><form:input path="deptno"/><form:errors path="deptno" cssStyle="color:red"/></td>
			</tr>

			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form:form>
	

<a href="?lang=en_US">English</a>
<a href="?lang=od_IN">Odia</a>
<a href="?lang=hi_IN">Hindi</a>
<a href="?lang=de_DE">German</a>
<a href="?lang=zh_CN">Chinese</a>
<a href="?lang=jpn_JA">Japanese</a>
</body>
</html>