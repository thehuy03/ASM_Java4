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
	<div class="mt-5">
		<div class="row  justify-content-center ms-4"
			style="width: 100%;">
			<c:forEach var="vd" items="${ArrayLichSu}" varStatus="loop">
				<div class="card col-3 mb-4 ms-4 p-0">
					<div class=" card-body bg-secondary-subtle text-black border m-auto"
						style="width: 20rem;">
						<a href="${url}/video=/${vd.getVideo().getId()}"> <img src="${vd.getVideo().getPoster()}"
							class="card-img-top img-fluid rounded " alt="...">
						</a>
						<div class="mt-2">
							<div class="card-title text-danger fw-bold">${vd.getVideo().getTitle()}</div>
						</div>
						<div class="d-flex justify-content-end me-3 mb-3 ">${vd.getViewedDate()}</div>
					</div>
				</div>
			</c:forEach>
		</div>
		</div>
</body>
</html>