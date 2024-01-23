<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" />
<div class="container">
<h1 style="color: red; text-align: center">Employee Edit page</h1>

<form:form modelAttribute="emp">
	<table border="2" align="center" class="table table-striped">
		<tr>
			<td class="table-success">Employee Number</td>
			<td><form:input path="empno" /></td>
		</tr>

		<tr>
			<td class="table-warning">Employee Name</td>
			<td><form:input path="ename" /></td>
		</tr>

		<tr>
			<td class="table-primary">Employee Designation</td>
			<td><form:input path="job" /></td>
		</tr>

		<tr>
			<td class="table-info">Employee Salary</td>
			<td><form:input path="sal" /></td>
		</tr>

		<tr class="table-dark">
			<td colspan="2" align="center"><input type="submit"
				value="Edit Employee"/></td>
		</tr>
	</table>
</form:form>
</div>