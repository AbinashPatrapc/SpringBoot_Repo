<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${!empty jslist}">
		<table border="1" align="center">
			<tr>
			    <th>JobSeeker ID</th>
				<th>JobSeeker Name</th>
				<th>JobSeeker Address</th>
				<th>Resume</th>
				<th>Photo</th>
			</tr>
			<tr>
				<c:forEach var="info" items="${jslist}">
					<tr>
						<td>${info.jsId}</td>
						<td>${info.jsName}</td>
						<td>${info.jsAddrs}</td>
						<td><a href="downloadpage?jsId=${info.jsId}&type=resume">Download
								Resume</a></td>
						<td><a href="downloadpage?jsId=${info.jsId}&type=photo">Download
								Photo</a></td>

					</tr>
				</c:forEach>
			</tr>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color: red; text-align: center">Record Not Found</h1>
	</c:otherwise>
</c:choose>