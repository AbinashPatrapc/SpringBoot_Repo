<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<h1 style="color: red; text-align: center">Student Registration
	Page</h1>
<form action="register" method="post">
	<table align="center" border="3" bgcolor="yellow">
		<tr>
			<td>Student ID:</td>
			<td><input type="text" name="sid"></td>
		<tr>
			<td>Student Name:</td>
			<td><input type="text" name="sname"></td>
		</tr>

		<tr>
			<td>Student Address:</td>
			<td><input type="text" name="saddrs"></td>
		</tr>

		<tr>
			<td>Student CGPA:</td>
			<td><input type="text" name="cgpa"></td>
		</tr>

		<tr>
			<td colspan="2"><input type="submit" value="Register"></td>
		</tr>

	</table>
</form>
