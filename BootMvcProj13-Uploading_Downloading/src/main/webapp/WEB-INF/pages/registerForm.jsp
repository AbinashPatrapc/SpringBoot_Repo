
<%@taglib uri="http://www.springframework.org/tags/form" prefix="c"%>

<c:form modelAttribute="js" enctype="multipart/form-data" method="POST">
	<table border="1" bgcolor="yellow" align="center">
		<tr>
			<td>Job Seeker Name:</td>
			<td><c:input path="jsName" /></td>
		</tr>

		<tr>
			<td>JobSeeker Address:</td>
			<td><c:input path="jsAddrs" /></td>
		</tr>

		<tr>
			<td>Upload Your Resume</td>
			<td><c:input type="file" path="resume" /></td>
		</tr>

		<tr>
			<td>Upload Your Photo</td>
			<td><c:input type="file" path="photo" /></td>
		</tr>

		<tr>
			<td colspan="2"><input type=submit value=register /></td>
		</tr>
	</table>
</c:form>