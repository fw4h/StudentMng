<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #eee;
}

.form-login {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-login .form-login-heading, .form-login .checkbox {
	margin-bottom: 10px;
}

.form-login .checkbox {
	font-weight: normal;
}

.form-login .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}

.form-login .form-control:focus {
	z-index: 2;
}

.form-login input[type="text"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-login input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.3/examples/sign-in/">
</head>
<body class="text-center">
	<form class="form-login" method="post" action="dologin.do">
		<img class="mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg"
			alt="" width="72" height="72">
		<h1 class="h3 mb-3 font-weight-normal">Please log in</h1>
		<label for="Username" class="sr-only">Username</label> <input
			type="text" name="Username" id="inputUsername" class="form-control" placeholder="Username"
			required autofocus> <label
			for="Password" class="sr-only">Password</label> <input
			type="password" name="Password" id="inputPassword" class="form-control" placeholder="Password"
			required>
		<div class="checkbox mb-3">
			<label> <input type="checkbox" value="remember-me">
				Remember me
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Log
			in</button>
		<p class="mt-5 mb-3 text-muted">&copy; 2019</p>
	</form>
</body>
</html>