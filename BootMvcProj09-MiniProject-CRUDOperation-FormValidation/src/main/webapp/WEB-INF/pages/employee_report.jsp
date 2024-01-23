<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" />
<div class="container">
<p:choose>
	<p:when test="${!empty List}">
		<h1 style="color: red; text-align: center">Employee Details</h1>
		<hr border-top=3px>
 <!-- Move the Add Employee button here -->
    <h1 style="text-align: center">
        <a href="register"><img alt="add" src="images/add.png" height="50" width="50" /></a><br>
        <i>Add Employee</i>
    </h1>

		<table width="1000" border="2" align="center" class="table">
			<tr class="table-dark">
				<th>EmpNo</th>
				<th>EmpName</th>
				<th>Job</th>
				<th>Salary</th>
				<th>Operation</th>
			</tr>
		
			<p:forEach var="emp" items="${List}">
				<tr class="table-info" >
					<td class="table-primary">${emp.empno}</td>
					<td class="table-warning">${emp.ename}</td>
					<td class="table-Secondary">${emp.job}</td>
					<td class="table-success">${emp.sal}</td>
					<td class="table-danger"><a href="edit?no=${emp.empno}"><img
							src="images/edit.png" height="50" width="50" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a onclick="confirm('Do You Really Want to Delete ?')"
						href="delete?no=${emp.empno}"><img alt="Delete Image"
							src="images/delete.png" height="50" width="50" /></a></td>
				</tr>
			</p:forEach>
		</table>
	</p:when>
	<p:otherwise>
		<h1 style="color: red; text-align: center">Record Not Found</h1>
	</p:otherwise>
</p:choose>

<p:if test="${!empty resultMsg}">
	<h2 style="color: green; text-align: center">${resultMsg}</h2>
</p:if>

<br>
<br>
<hr>
<!-- <h1 style="text-align: center">
	<a href="register"><img alt="add" src="images/add.png" height="50"
		width="50" /></a><br> <i>Add Employee</i>
</h1> -->

<h1 style="text-align: center">
<a href="./"><img alt="Home" src="images/home.png" height="50"
	width="50" /></a>
<br>
<i>Home</i>
</h1>
</div>