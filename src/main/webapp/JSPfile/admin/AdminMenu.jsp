<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<c:url var="url" value="/HDTTube"/>
		<div class="container" style="max-width: 100%;">
			<nav class="navbar navbar-expand-lg bg-body-tertiary">
				<div class="container-fluid ms-5">
					<a class="navbar-brand" href="${url}/home">ONLINE ENTERTAINMENT</a>
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarScroll"
						aria-controls="navbarScroll" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarScroll">
						<ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll"
							style="-bs-scroll-height: 100px;">
							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="${url}/home">Home</a></li>
							<li class="nav-item dropdown"><a class="nav-link " href="${url}/videomanager"
								role="button" aria-expanded="page">Videos manager</a>
							</li>
							<li class="nav-item dropdown"><a class="nav-link " href="${url}/edit"
								role="button" aria-expanded="page">Users manager</a>
							</li>
							<li class="nav-item dropdown"><a class="nav-link " href="${url}/reports"
								role="button"  aria-expanded="page">Reports</a>
							</li>
							<li class="nav-item dropdown"><a class="nav-link " href="${url}/signout"
								role="button"  aria-expanded="page">Signout</a>
							</li>
						</ul>
						<form class="d-flex me-5" role="search">
							<input class="form-control me-2" type="search"
								placeholder="Search" aria-label="Search">
							<button class="btn btn-outline-success" type="submit">Search</button>
						</form>
					</div>
				</div>
			</nav>
		</div>
</body>
</html>