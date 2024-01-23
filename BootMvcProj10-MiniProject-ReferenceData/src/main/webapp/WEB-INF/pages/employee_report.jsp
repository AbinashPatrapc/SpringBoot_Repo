<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" />
<div class="container mt-5">
    <p:choose>
        <p:when test="${!empty List}">
            <h1 style="color: red; text-align: center;">Employee Details</h1>
            <hr class="border-top border-3">

            <!-- Move the Add Employee button here -->
            <div class="text-center">
                <a href="register" class="btn btn-primary mb-3">
                    <img alt="add" src="images/add.png" height="50" width="50" /><br>
                    <i>Add Employee</i>
                </a>
            </div>

            <table class="table">
                <thead class="table-dark">
                    <tr>
                        <th>EmpNo</th>
                        <th>EmpName</th>
                        <th>Job</th>
                        <th>Salary</th>
                        <th>Operation</th>
                    </tr>
                </thead>
                <tbody>
                    <p:forEach var="emp" items="${List}">
                        <tr>
                            <td class="table-primary">${emp.empno}</td>
                            <td class="table-warning">${emp.ename}</td>
                            <td class="table-secondary">${emp.job}</td>
                            <td class="table-success">${emp.sal}</td>
                            <td class="table-danger">
                                <a href="edit?no=${emp.empno}" class="btn btn-primary me-2">
                                    <img src="images/edit.png" height="30" width="30" />
                                </a>
                                <a onclick="confirm('Do You Really Want to Delete ?')" href="delete?no=${emp.empno}" class="btn btn-danger">
                                    <img alt="Delete Image" src="images/delete.png" height="30" width="30" />
                                </a>
                            </td>
                        </tr>
                    </p:forEach>
                </tbody>
            </table>
        </p:when>
        <p:otherwise>
            <h1 style="color: red; text-align: center;">Record Not Found</h1>
        </p:otherwise>
    </p:choose>

    <p:if test="${!empty resultMsg}">
        <h2 style="color: green; text-align: center;">${resultMsg}</h2>
    </p:if>

    <div class="text-center">
        <a href="./" class="btn btn-primary mb-3">
            <img alt="Home" src="images/home.png" height="50" width="50" /><br>
            <i>Home</i>
        </a>
    </div>
</div>
