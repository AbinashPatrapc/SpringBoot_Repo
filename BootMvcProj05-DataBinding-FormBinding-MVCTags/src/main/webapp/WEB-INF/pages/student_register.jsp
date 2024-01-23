<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="p"%>
<h1 style="color: red; text-align: center">Student Registration
	Page</h1>
<p:form method="post" modelAttribute="stud">
	<table align="center" border="3" bgcolor="yellow">
		<tr>
			<td>Student ID:</td>
			<td><p:input path="sid" /></td>
		<tr>
			<td>Student Name:</td>
			<td><p:input path="sname" /></td>
		</tr>

		<tr>
			<td>Student Address:</td>
			<td><p:input path="saddrs" /></td>
		</tr>

		<tr>
			<td>Student CGPA:</td>
			<td><p:input path="cgpa" /></td>
		</tr>

		<tr>
			<td colspan="2"><input type="submit" value="Register"></td>
		</tr>

	</table>
</p:form>
