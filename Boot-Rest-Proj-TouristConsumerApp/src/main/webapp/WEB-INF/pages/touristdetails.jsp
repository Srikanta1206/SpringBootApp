<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="jakarta.tags.core"  prefix="p"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<c:choose>
		<c:when test="${!empty objList }">
			<table border=1 align=center class="table table-hover">
				<tr class="table-warning">
					<th>TID</th>
					<th>Name</th>
					<th>Age</th>
					<th>Address</th>
					<th>ContactNo</th>
					<th>Email</th>
					<th>JourneyStart</th>
					<th>JourneyEnd</th>
					<th>Budget</th>
					<th>Operation</th>
				</tr>
				<c:forEach var="obj" items="${objList}">
					<tr>
						<td>${obj.tId}</td>
						<td>${obj.tName}</td>
						<td>${obj.age}</td>
						<td>${obj.tAddress}</td>
						<td>${obj.contactNo}</td>
						<td>${obj.email}</td>
						<td>${obj.journeyStarts}</td>
						<td>${obj.journeyEnds}</td>
						<td>${obj.budget}</td>
						<td><a href="edit?id=${obj.tId}">Edit</a> &nbsp; &nbsp;
						<a href="delete?id=${obj.tId}"  onclick="confirm('Do you want to delete')">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1>No Tourist Found</h1>
		</c:otherwise>
	</c:choose>
	<h1 style="color:red;text-align: center">${result }</h1>
	<div class=set>
		<a href="add_tourist">Add Tourist</a>
	</div>
</body>
</html>