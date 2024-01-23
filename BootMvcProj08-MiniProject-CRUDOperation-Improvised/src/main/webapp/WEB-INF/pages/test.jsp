<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reservation Form</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            padding-top: 50px;
        }
        .reservation-form {
            max-width: 500px;
            margin: auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="text-center" style="color: red;">Reservation Form</h1>
        <hr style="height: 1px; color: green;">
        <div class="reservation-form">
            <form action="processReservation.jsp" method="post">
                <div class="form-group">
                    <label for="id">ID:</label>
                    <input type="text" id="id" name="id" class="form-control">
                </div>
                <div class="form-group">
                    <label for="date">Date:</label>
                    <input type="date" id="date" name="date" class="form-control">
                </div>
                <div class="form-group">
                    <label for="time">Time:</label>
                    <input type="time" id="time" name="time" class="form-control">
                </div>
                <div class="form-group">
                    <label for="partySize">Party Size:</label>
                    <input type="text" id="partySize" name="partySize" class="form-control">
                </div>
                <div class="form-group">
                    <label for="customerName">Customer Name:</label>
                    <input type="text" id="customerName" name="customerName" class="form-control">
                </div>
                <div class="form-group">
                    <label for="phnNumber">Phone Number:</label>
                    <input type="text" id="phnNumber" name="phnNumber" class="form-control">
                </div>
                <div class="form-group">
                    <label for="tableId">Table ID:</label>
                    <input type="text" id="tableId" name="tableId" class="form-control">
                </div>
                <div class="text-center">
                    <input type="submit" value="SUBMIT" class="btn btn-primary">
                </div>
            </form>
        </div>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
