<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transfer Form</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="text-center mb-4">Transfer Page</h1>
    <form action="transfer" method="post">
        <div class="form-group">
            <label for="sourceaccountNumber">Source Account Number:</label>
            <input type="text" class="form-control" id="sourceAccountNum" name="sourceAccountNum" required>
        </div>
        <div class="form-group">
            <label for="destinationaccountNumber">Destination Account Number:</label>
            <input type="text" class="form-control" id="destinationAccountNum" name="destinationAccountNum" required>
        </div>
        <div class="form-group">
            <label for="amount">Amount:</label>
            <input type="text" class="form-control" id="amount" name="amount" required>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
