<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:url var="url" value="/HDTTube"/>
		<div class="ms-4">
			<div class=" mt-3">
			<c:forEach var="vid" items="${item}" varStatus="loop">
				<div class="card bg-secondary-subtle text-black border"
					style="width: 25rem;">
					<a href="${url}/video=/${vid.getId()}"> <img
						src="${vid.getPoster()}"
						class="card-img-top img-fluid rounded" alt="...">
					</a>
					<div class="card-body">
						<p class="card-title text-danger fw-bold">${vid.getTitle()}</p>
						<p class="card-text">${vid.getDescribe()}</p>
					</div>
					<hr>
					
				</div>
				</c:forEach>
			</div>
		</div>
</body>
</html>