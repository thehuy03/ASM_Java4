<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>
<body>
	<c:url var="url" value="/HDTTube"/>
		<div class="card bg-secondary-subtle text-black border"
			style="width: 100%; backdrop-filter: blur(3px);">
			<div class="ratio ratio-16x9 "><iframe class="card-img-top img-fluid"
					src="https://www.youtube.com/embed/${vd.getId()}" allowfullscreen></iframe>
			</div>
			<div class="card-body">
				<p class="card-title">${vd.getTitle()}</p>	
			</div>
			<hr>
			<div class="d-flex justify-content-end me-3 mb-3 ">
				<form action="" method="POST">
					<button formaction="${url}/video=/${vd.getId()}" class="btn btn-success me-3">Like<span class="badge text-bg-secondary">${numberLike.size()}</span></button>	
				</form>
				<button class="btn btn-danger me-3" data-bs-toggle="modal"data-bs-target="#exampleModal">Share</button>
				<button class="btn btn-primary" type="button"data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample"aria-controls="offcanvasExample">history</button>
			</div>
			<p class="card-text">${vd.getDescribe()}</p>
		</div>
	
	<%@include file="videocanvas.jsp" %>
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Send video to your friend by Email</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<p>Your friend's mail :</p>
					<input type="email" name="email" id="" style="width: 100%;">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Send it</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>