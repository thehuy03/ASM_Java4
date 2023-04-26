<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<c:url var="url" value="/HDTTube" />
	<main>
		<div class="container p-0 m-auto"
			style="width: 30rem; backdrop-filter: blur(3px);">
			<form action="${url}/signup" method="POST"
				class="border border-danger-subtle border-5 p-5 mt-5">
				<div class="fs-2 text-danger fw-bolder mb-3">Sign up</div>
				<div class="text-center">
					<div class="form-floating mb-3">
						<input name="id" type="text" class="form-control"
							id="floatingInput" placeholder="Fullname"> <label
							for="floatingInput">ID User</label>
					</div>
					<div class="form-floating mb-3">
						<input type="email" name="email" class="form-control"
							id="floatingInput" placeholder="name@example.com"> <label
							for="floatingInput">Email address</label>
					</div>
					<div class="form-floating mb-3">
						<input type="password" name="password" class="form-control"
							id="floatingPassword" placeholder="Password"> <label
							for="floatingPassword">Password</label>
					</div>
					<div class="d-flex mb-3 border-1">
						<div class="form-check me-3">
							<input class="form-check-input" type="radio" name="role" value="true"
								id="flexRadioDefault1"> <label class="form-check-label"
								for="flexRadioDefault1"> admin </label>
						</div>
						<div class="form-check me-3">
							<input class="form-check-input" type="radio" name="role" value="false"
								id="flexRadioDefault2" checked> <label
								class="form-check-label" for="flexRadioDefault2"> user </label>
						</div>
					</div>
					<button class="btn btn-danger" style="width: 70%;">Sign up</button>
					<h3 class="text-danger">${message}</h3>
				</div>
			</form>
		</div>
	</main>
</body>
</html>