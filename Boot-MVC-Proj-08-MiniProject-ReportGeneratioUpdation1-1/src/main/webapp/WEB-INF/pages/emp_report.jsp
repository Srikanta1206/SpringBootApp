<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.add {
	text-align: center;
}
</style>
</head>
<body>
	<h1 style="color: red; text-align: center">Employee Details</h1>
	<c:choose>
		<c:when test="${!empty empdata}">
			<table border="1" bgcolor=green align=center>
				<tr>
					<th>empno</th>
					<th>ename</th>
					 <th>Desg</th>
					<th>Sal</th>
					<th>DeptNo</th>
					<th>Operation</th>
				</tr>
				<c:forEach var="empobj" items="${empdata.getContent()}">
					<tr>
						<td>${ empobj.empno}</td>
						<td>${empobj.ename}</td>
						<td>${empobj.desg}</td>
						<td>${empobj.sal}</td>
						<td>${empobj.deptno }</td>

						<td><a href="edit_employee?eno=${empobj.empno }"><img
								src="images/edit.png" alt="edit" height=30px width=30px></a>&nbsp
							&nbsp; <a href="delete_employee?eno=${empobj.empno }" onclick="confirm('are you want to delete the record')"><img
								alt="delete" src="images/delete.png" height=30px width=30px></a></td>

					</tr>
				</c:forEach>
			</table>

			<p style="text-align: center">

				<c:if test="${!empdata.isFirst()}">
					<a href="emp_list?page=${0 }">First</a>
				</c:if>
				<c:if test="${!empdata.isLast()}">
					<a href="emp_list?page=${empdata.getNumber()+1}">Next</a>
				</c:if>

		<c:forEach var="i" begin="1" end="${empdata.getTotalPages()}"
					step="1">
					<a href="emp_list?page=${i-1}">${i}</a>&nbsp; &nbsp;
		</c:forEach>
		
		<c:if test="${!empdata.isLast() }">
			<a href="emp_list?page=${empdata.getTotalPages()-1 }">Last</a>
		</c:if>
		
		<c:if test="${!empdata.isFirst() }">
			<a href="emp_list?page=${empdata.getNumber()-1 }">Previous</a>
		</c:if>
		
			</p>
		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center">No record Found</h1>
		</c:otherwise>
	</c:choose>
	<br>
	<br>
	<div class=update>
		<h1 style="color: red; text-align: center">${ResultMsg }</h1>
	</div>
	<div class=add>
		<a href="add_employee">ADD EMPLOYEE DETAIL</a><br> <a href="./">Home</a>
	</div>

</body>
</html>