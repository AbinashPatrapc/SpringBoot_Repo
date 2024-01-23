<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Banking Application</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
<header class="header">
    <div class="logo">
      <img src="images/sbi.png" height="80px" width="300px" alt="[Bank Name] Logo">
    </div>
    </header>
<br>
<div class="container-fluid">
    <header class="text-center py-4">
        <h1 class="display-4">Welcome to SBI Online Banking</h1>
    </header>

    <div class="d-grid gap-3 col-6 mx-auto">
        <a href="add" class="btn btn-primary btn-lg">Add Account</a>
        <a href="deposit" class="btn btn-success btn-lg">Deposit Amount</a>
        <a href="withdraw" class="btn btn-warning btn-lg">Withdraw Amount</a>
        <a href="transfer" class="btn btn-info btn-lg">Transfer Amount</a>
        <a href="accountDetails" class="btn btn-secondary btn-lg">View Account Balance</a>
    </div>

    <footer class="text-center pt-4">
    <br>
    <br>
    <p>© 2024 State Bank of India. All rights reserved.</p>
        </footer>
</div>

</body>
</html>
