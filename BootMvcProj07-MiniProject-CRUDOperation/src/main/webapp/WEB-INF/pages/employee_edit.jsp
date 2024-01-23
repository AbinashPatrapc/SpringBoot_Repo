<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color: red; text-align: center">Employee Edit page</h1>

<form:form modelAttribute="emp">
	<table border="2" align="center">
		<tr>
			<td>Employee Number</td>
			<td><form:input path="empno" /></td>
		</tr>

		<tr>
			<td>Employee Name</td>
			<td><form:input path="ename" /></td>
		</tr>

		<tr>
			<td>Employee Designation</td>
			<td><form:input path="job" /></td>
		</tr>

		<tr>
			<td>Employee Salary</td>
			<td><form:input path="sal" /></td>
		</tr>

		<tr>
			<td clospan="2" align="center"><input type="submit"
				value="Edit Employee"></td>
		</tr>
	</table>
</form:form>