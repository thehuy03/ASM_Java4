<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<table class="table table-light border-danger table-bordered table-striped">
		<div class="d-flex justify-content-center" style="width: 100%;">
			<div class="ms-5">Video title:</div>
			<select class="form-select ms-3" name="cboVideo"
				onchange="location.href=window.location.href.split('?')[0]+'?TabReport=3&videoId='+this.value"
				aria-label="Default select example">
				<option selected disabled value="">Open this select menu</option>
				<c:forEach var="i" items="${titleVideo}">
					<option value="${i.getId()}" ${videoId==i.id?'selected':''}>${i.title}</option>
				</c:forEach>
			</select>
		</div>
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">View Count</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="i" items="${report}">
				<tr>
					<th scope="row">${i.user.getId()}</th>	
					<td>${report.size()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>