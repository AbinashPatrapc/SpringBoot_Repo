<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>

<p:choose>
	<p:when test="${!empty List}">
		<h1 style="color: red; text-align: center">Employee Details Are</h1>
		<hr border-top=3px>


		<table width="1000" border="2" align="center">
			<tr>
				<th>EmpNo</th>
				<th>EmpName</th>
				<th>Job</th>
				<th>Salary</th>
				<th>Operation</th>
			</tr>
			<p:forEach var="emp" items="${List}">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.ename}</td>
					<td>${emp.job}</td>
					<td>${emp.sal}</td>
					<td><a href="edit?no=${emp.empno}"><img
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
<h1 style="text-align: center">
	<a href="register"><img alt="add" src="images/add.png" height="50"
		width="50" /></a><br> <i>Add Employee</i>
</h1>
<a href="./"><img alt="Home" src="images/home.png" height="50"
	width="50" /></a>
<br>
<i>home</i>