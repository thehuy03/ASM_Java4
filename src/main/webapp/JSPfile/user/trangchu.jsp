<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	
	<div class="tab-content" id="v-pills-tabContent">
		<div class="tab-pane fade show active" id="v-pills-home"
			role="tabpanel" aria-labelledby="v-pills-home-tab" tabindex="0">
			<%@include file="tab1.jsp" %>
		</div>
		<div class="tab-pane fade" id="v-pills-profile" role="tabpanel"
			aria-labelledby="v-pills-profile-tab" tabindex="0">...</div>
		<div class="tab-pane fade" id="v-pills-disabled" role="tabpanel"
			aria-labelledby="v-pills-disabled-tab" tabindex="0">...</div>
		<div class="tab-pane fade" id="v-pills-messages" role="tabpanel"
			aria-labelledby="v-pills-messages-tab" tabindex="0">...</div>
		<div class="tab-pane fade" id="v-pills-settings" role="tabpanel"
			aria-labelledby="v-pills-settings-tab" tabindex="0">...</div>
	</div>

</body>
</html>