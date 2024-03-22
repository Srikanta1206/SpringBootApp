<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Source and Destination Input</title>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

.container {
	width: 80%;
	margin: 50px auto;
	text-align: center;
}

h2 {
	margin-bottom: 20px;
}

form {
	display: inline-block;
	text-align: left;
}

label {
	display: block;
	margin-bottom: 5px;
}

input[type="text"] {
	width: 200px;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 5px;
	margin-bottom: 15px;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>

	<div class="container">
		<h2>Enter Source and Destination</h2>
		<spring:form modelAttribute="place" action="../scheduled/details">
			<label>Date:</label>
			<input type="date" name="date">
			<br>
			<br>

			<label for="source">Source:</label>
			<spring:select path="source">
				<spring:options items="${city}" />
			</spring:select>

			<br><br>
			
			<label for="source">Destination:</label>
			<spring:select path="destination">
				<spring:options items="${city}" />
			</spring:select>

			<input type="submit" value="Submit">

		</spring:form>
	</div>

</body>
</html>
