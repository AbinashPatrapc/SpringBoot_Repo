<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bank Account Report</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css">  </head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4">Bank Account Report</h1>
    <c:choose>
        <c:when test="${!empty AccList}">
            <div class="card">
                <div class="card-header bg-light">
                    <h4 class="card-title">Account Details</h4>
                </div>
                <div class="card-body">
                    <dl class="row">
                        <dt class="col-sm-3">Account Number:</dt>
                        <dd class="col-sm-9">${AccList.accountNumber}</dd>
                        <dt class="col-sm-3">Balance:</dt>
                        <dd class="col-sm-9">${AccList.balance}</dd>
                        <dt class="col-sm-3">Account Type:</dt>
                        <dd class="col-sm-9">${AccList.accountType}</dd>
                        </dl>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <div class="alert alert-warning text-center">
                <h4 class="alert-heading">Record Not Found</h4>
                <p>The requested account information is not available.</p>
            </div>
        </c:otherwise>
    </c:choose>
    <p><a href="./">Return to Home Page</a></p>
</div>
</body>
</html>
