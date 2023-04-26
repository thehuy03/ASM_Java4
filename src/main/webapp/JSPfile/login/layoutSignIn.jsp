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
    <main>
        <div class="container p-0 m-auto" style="width: 30rem; backdrop-filter: blur(3px);">
            <form action="${url}/signin" method="POST" class="border border-danger-subtle border-3 p-5 mt-5">
                <div class="fs-2 text-danger fw-bolder mb-3">Sign In</div>
                <div class="text-center">
                    <div class="form-floating mb-3">
                        <input type="text" name="username" class="form-control" id="floatingInput"
                            placeholder="username">
                        <label for="floatingInput">User name</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="password" class="form-control" name="password" id="floatingPassword"
                            placeholder="Password">
                        <label for="floatingPassword">Password</label>
                    </div>
                    <div class="mb-3 form-check">
                        <div class="position-relative">
                            <input type="checkbox" class="form-check-input" id="exampleCheck1" name="chkCookie">
                            <label class="form-check-label position-absolute top-0 start-0 text-danger" for="exampleCheck1">Remember me</label>       
                        </div>
                    </div>
                    <div class="d-flex">
                        <button  class="btn btn-danger m-3" style="width: 90%;">Sign in</button>
                    </div>
                    <h3 class="text-danger">${message}</h3>
                </div>
            </form>
        </div>
    </main>

</body>
</html>