<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<table
		class="table table-light border-danger table-bordered table-striped">
		<div class="d-flex justify-content-center" style="width: 100%;">
			<div class="ms-5 text-light">Video title:</div>
			<select class="form-select ms-3" aria-label="Default select example" onchange="location.href=window.location.href.split('?')[0]+'?TabReport=2&videoId='+this.value">
				<option selected>Open this select menu</option>
				<c:forEach var="i" items="${titleVideo}">
					<option value="${i.getId()}" ${videoId==i.id?'selected':''}>${i.title}</option>
				</c:forEach>
			</select>
		</div>
		<thead>
			<tr>
				<th scope="col">Username</th>
				<th scope="col">Fullname</th>
				<th scope="col">Email</th>
				<th scope="col">Likedday</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="i" items="${fvrt}">
				<tr>
					<th scope="row">${i.user.id}</th>
					<td>${i.user.email}</td>
					<td>${i.user.role}</td>
					<td>${i.likeDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>