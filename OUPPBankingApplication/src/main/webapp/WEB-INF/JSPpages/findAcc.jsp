<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Credit Form</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2 class="text-center mb-4">Check Balance</h2>
		<form action="accountDetails" method="post">
			<div class="form-group">
				<label for="accountNumber">Account Number:</label> <input
					type="text" class="form-control" id="accountNumber"
					name="accountNumber" required>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>