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
	<main>
		<c:url var="url" value="/HDTTube" />
		<div class="container" style="width: 25rem; backdrop-filter: blur(3px);">
			<form action="${url}/changepassword" method="POST">
				<div class="border border-danger-subtle border-3 p-5 mt-5">
					<div class="fs-2 text-danger fw-bolder mb-3">Change Password</div>
					<div class="text-center">
						<div class="form-floating mb-3">
							<input type="text" name="newpass" class="form-control"
								id="floatingInput" placeholder="New password" required>
							<label for="floatingInput">New password</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control" name="confirmnewpass"
								id="floatingPassword" placeholder="Confirm New password"
								required> <label for="floatingPassword">Confirm
								New password</label>
						</div>
						<div class="modal-body">
							<div class="form-floating mb-3">
								<input type="text" class="form-control" name="otp"
									id="floatingPassword" placeholder="OTP code"> <label
									for="floatingPassword">OTP code</label>
							</div>
						</div>
						<button class="btn btn-danger me-3" data-bs-toggle="modal"
							data-bs-target="#exampleModal" style="width: 70%;">OK</button>
					</div>
					<h3>${content}</h3>
					<h3>${message}</h3>
				</div>
			</form>
		</div>
	</main>

	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Please fill OTP code</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary">OK</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>