<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample"
            aria-labelledby="offcanvasExampleLabel">
            <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasExampleLabel">Last Video</h5>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="ms-3 offcanvas-body">
            	
	            	<div class=" mt-3">
	            		<c:forEach var="i" items="${ArrayLichSu}">
	                    <div class="card bg-secondary-subtle text-black border" style="width: 20rem;">
	                        <a href="#">
	                            <img src="${i.getVideo().getPoster()}"
	                                class="card-img-top img-fluid rounded" alt="...">
	                        </a>
	                        <div class="card-body">
	                            <p class="card-text text-danger fw-bold">${i.getVideo().getTitle()}</p>
	                        </div>
	                        <div class="d-flex justify-content-end me-3 mb-3 ">
                                    ${i.getViewedDate()}
                            </div>
	                    </div>
	                    </c:forEach>
	                </div>

            </div>
        </div>
</body>
</html>