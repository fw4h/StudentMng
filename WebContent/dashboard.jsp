<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading">User Entry</div>
		<div class="panel-body">
			<form action="doupdate.do" method="post">

				<input type="hidden" name="id" class="form-control" id="id"
					value="${requestScope.userDTO.id}" />
				<div class="form-group">
					<label for="name">Name: </label> <input type="text" name="name"
						class="form-control" id="name"
						value="${requestScope.userDTO.name}" />
				</div>
				<div class="form-group">
					<label for="phone_no">Phone Number: </label> <input type="text"
						name="phone_no" class="form-control" id="phone_no"
						value="${requestScope.userDTO.phone_no}" />
				</div>
				<div class="form-group">
					<label for="dob">Date of Birth: </label> <input type="text"
						name="dob" class="form-control" id="dob"
						value="<fmt:formatDate value="${requestScope.userDTO.dob}" pattern="MM/dd/yyyy"/>">
				</div>
				<div class="form-group">
					<label for="username">Username: </label> <input type="text"
						name="username" class="form-control" id="username"
						value="${requestScope.userDTO.username}" />
				</div>
				<div class="form-group">
					<label for="password">Password: </label> <input type="text"
						name="password" class="form-control" id="password"
						value="${requestScope.userDTO.password}" />
				</div>
				<button class="btn btn-default" type="submit">Submit</button>
			</form>
		</div>
	</div>

	<div class="panel panel-primary">
		<div class="panel-heading">User List</div>
		<div class="panel-body">
			<table class="table">
				<thead>
					<tr>
						<th>ID
						<th>NAME
						<th>PHONE_NO
						<th>DOB
						<th>USERNAME
						<th>PASSWORD
						<th>ACTION
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.userList}" var="row">
						<tr>
							<td>${row.id}</td>
							<td>${row.name}</td>
							<td>${row.phone_no}</td>
							<td><fmt:formatDate value="${row.dob}" pattern="MM/dd/yyyy" />
							</td>
							<td><c:out value="${row.username}"></c:out></td>
							<td><c:out value="${row.password}"></c:out></td>
							<td><a href="dodisplay.do?id=${row.id}">Edit</a> / <a
								href="dodelete.do?id=${row.id}">Delete</a>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>


</body>
</html>