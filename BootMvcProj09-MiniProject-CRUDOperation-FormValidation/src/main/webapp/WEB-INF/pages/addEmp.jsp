<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" />
<div class="container">
<h1 style="color: red; text-align: center">Enter New Employee Details</h1>
<form:form modelAttribute="emp">
	<table border="2" align="center"  class="table table-dark">
		<tr>
			<td>Enter Employee Name</td>
			<td><form:input path="ename" /><form:errors path="ename"/></td>
		</tr>

		<tr>
			<td>Enter Employee Job</td>
			<td><form:input path="job" /><form:errors path="job"/></td>
		</tr>
		<tr>
			<td>Enter Employee Salary</td>
			<td><form:input path="sal" /><form:errors path="sal"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Register"></td>
		</tr>
	</table>
</form:form>
</div>