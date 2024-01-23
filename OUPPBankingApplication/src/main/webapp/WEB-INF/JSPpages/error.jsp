<%@ page isErrorPage="true" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>An Error Occurred</title>
<link rel="stylesheet" href="styles.css"> </head>
<body>

<div class="container">
    <h1>Oops! An Error Occurred</h1>
    <p>We apologize for the inconvenience. An error has occurred while processing your request.</p>

    <% if (exception != null) { %>
        <p><b>Error Message:</b> <%= exception.getMessage() %></p>
    <% } %>

    <p>Please try again later, or contact us for assistance.</p>
    <p><a href="./">Return to Home Page</a></p>
</div>

</body>
</html>
