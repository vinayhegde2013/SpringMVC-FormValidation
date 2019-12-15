<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="addStudent.htm" method="post" modelAttribute="s">

		<form:label path="id">Enter ID:</form:label>
		<form:input path="id" />
		<form:errors path="id" />
		<br>


		<form:label path="name">Enter Name:</form:label>
		<form:input path="name" />
		<form:errors path="name" />
		<br>

		<form:label path="pname">Enter Place</form:label>
		<form:select path="pname">
			<form:options items="${placeList}" itemLabel="pname"
				itemValue="pname" />
		</form:select>

		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>