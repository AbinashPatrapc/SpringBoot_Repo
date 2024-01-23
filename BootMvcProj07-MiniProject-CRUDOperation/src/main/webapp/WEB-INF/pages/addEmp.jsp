<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<form:form modelAttribute="emp">
	<table border="2" align="center" bgcolor="gray">
		<tr>
			<td>Enter Employee Name</td>
			<td><form:input path="ename" /></td>
		</tr>

		<tr>
			<td>Enter Employee Job</td>
			<td><form:input path="job" /></td>
		</tr>
		<tr>
			<td>Enter Employee Salary</td>
			<td><form:input path="sal" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Register"></td>
		</tr>
	</table>
</form:form>