<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" />
<div class="container mt-5">
    <h1 style="color: red; text-align: center;">Employee Edit Page</h1>

    <form:form modelAttribute="emp">
    
       <%--This is to display all error message at top  
       <p style="color: red; text-align: center;">
            <form:errors path="*"/>
        </p> --%>
        <table class="table table-striped">
            <tr class="table-success">
                <td>Employee Number</td>
                <td><form:input path="empno" class="form-control" /></td>
            </tr>
            <tr class="table-warning">
                <td>Employee Name</td>
                <td><form:input path="ename" class="form-control" /></td>
            </tr>
            <tr class="table-primary">
                <td>Employee Designation</td>
                <td><form:input path="job" class="form-control" /></td>
            </tr>
            <tr class="table-info">
                <td>Employee Salary</td>
                <td><form:input path="sal" class="form-control" /></td>
            </tr>
            <tr class="table-dark">
                <td colspan="2" align="center">
                    <input type="submit" value="Edit Employee" class="btn btn-primary" />
                </td>
            </tr>
        </table>
    </form:form>
</div>
