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
	<div class="mt-5">
		<div class="row  justify-content-center "
			style="width: 100%;">
			<c:forEach var="vd" items="${item}" varStatus="loop">
				<div class="card col-3 mb-4 ms-4 p-0" >
					<div class=" card-body text-black border m-auto"
						style="width: 20rem; ">
						<a href="${url}/video=/${vd.getId()}"> <img src="${vd.getPoster()}"
							class="card-img-top img-fluid rounded " alt="...">
						</a>
						<div class="mt-2" style="backdrop-filter: blur(3px);">
							<div class="card-title text-danger fw-bold">${vd.getTitle()}</div><hr>
							  <p class="card-title fw-light">${vd.getDescribe()}</p>
						</div>
					</div>
					
				</div>
			</c:forEach>
		</div>
		<div class=" d-flex justify-content-center">
			<c:forEach begin="1" end="${endPage}" var="i">
				<a class="btn btn-primary me-3" href="${url}/home?indexPage=${i}" role="button">${i}</a>
			</c:forEach>
		</div>
	</div>
</body>
</html>