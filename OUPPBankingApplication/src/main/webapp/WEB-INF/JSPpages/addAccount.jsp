<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open an Account - SBI</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
<style>
.header {
	background-color: #f7f9fa;
	padding: 15px;
}

.logo {
	float: left;
}

.nav-links {
	float: right;
}
</style>
</head>
<body>
	<header class="header">
		<div class="logo">
			<img src="images/sbi.png" height="80px" width="200px"
				alt="[Bank Name] Logo">
		</div>
		<div class="nav-links">
			<a href="#">Contact Us</a> <a href="#">About Us</a> <a href="#">Locate
				Us</a>
		</div>
	</header>
	<div class="container mt-5">
		<br>
		<h2>Open Your Account Today</h2>
		<p>We're excited to welcome you to State Bank of India! Enter your
			information below to start your secure account registration.</p>
		<form modelAttribute="request" method="post">
			<div class="form-group">
				<label for="name">Name:</label> <input type="text"
					class="form-control" id="name" name="name" required>
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email" name="email" required>
			</div>

			<div class="form-group">
				<label for="email">Password:</label> <input type="password"
					class="form-control" id="password" name="password" required>
			</div>
			<div class="form-group">
				<label for="mobileNumber">Mobile Number:</label> <input type="tel"
					class="form-control" id="mobileNumber" name="mobileNumber" required>
			</div>
			<div class="form-group">
				<label for="address">Address:</label>
				<textarea class="form-control" id="address" name="address" required></textarea>
			</div>
			<div class="form-group">
				<label for="aadharNumber">Aadhar Number:</label> <input type="text"
					class="form-control" id="aadharNumber" name="aadharNumber" required>
			</div>
			<div class="form-group">
				<label for="accountType">Account Type:</label> <select
					class="form-control" id="accountType" name="accountType" required>
					<option value="">Select Account Type</option>
					<option value="savings">Savings Account</option>
					<option value="current">Current Account</option>
					<option value="current">Fixed Deposit Account</option>
				</select>
			</div>

			<div class="form-group">
				<label for="aadharNumber">Initial Deposit:</label> <input
					type="text" class="form-control" id="balance" name="balance"
					required>
			</div>

			<button type="submit" class="btn btn-primary">Next</button>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
