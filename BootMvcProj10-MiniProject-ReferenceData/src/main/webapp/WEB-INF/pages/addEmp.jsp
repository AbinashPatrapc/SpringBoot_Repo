<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Link to Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" />

<div class="container mt-5">
    <h1 style="color: red; text-align: center;">Enter New Employee Details</h1>
    <form:form modelAttribute="emp"  name="frm">
        <table class="table table-bordered table-striped table-hover">
            <tr>
                <td>Enter Employee Name</td>
                <td><form:input path="ename" class="form-control" /> <form:errors path="ename" class="text-danger" /></td>
            </tr>
            <tr>
                <td>Enter Employee Job</td>
                <td><form:input path="job" class="form-control" /> <form:errors path="job" class="text-danger" /></td>
            </tr>
            <tr>
                <td>Enter Employee Salary</td>
                <td><form:input path="sal" class="form-control" /> <form:errors path="sal" class="text-danger" /></td>
            </tr>
            <script>
                function sendReqForState() {
                    frm.action = "stateurl";
                    frm.submit();
                }
            </script>
            <tr>
                <td>Select Your Country</td>
                <td>
                    <form:select path="country" class="form-control" onchange="sendReqForState()">
                        <form:options items="${countryinfo}" />
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Select Your State</td>
                <td>
                    <form:select path="state" class="form-control">
                        <form:options items="${statesInfo}" />
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Register" class="btn btn-primary" /></td>
            </tr>
        </table>
    </form:form>
</div>
