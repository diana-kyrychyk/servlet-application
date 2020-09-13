<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<title>User List</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="../include/menu.jsp"/>

<div class="container-fluid">
		<table class="table table-hover">
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Second Name</th>
				<th>Login</th>
				<th>Teams</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.id}</td>
					<td>${user.firstName}</td>
					<td>${user.secondName}</td>
					<td>${user.login}</td>
					<td>
						<c:forEach var="team" items="${user.teams}">
							<span class="badge badge-primary">${team.name}</span>
						</c:forEach>
					</td>
					<td>
						<a href="user-edit?id=${user.id}" class="btn btn-info" role="button">Edit</a>
					</td>

				</tr>
			</c:forEach>
		</table>
</div>
<br />
</body>
</html>