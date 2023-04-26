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
        <div class="container m-0 p-0" style="max-width: 100%;">
            <nav class="navbar navbar-expand-lg bg-body-tertiary">
                <div class="container-fluid ms-5">
                    <a class="navbar-brand" href="${url}/home">ONLINE ENTERTAINMENT</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false"
                        aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarScroll">
                        <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll"
                            style="--bs-scroll-height: 100px;">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">My favorite</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">My Account</a>   
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="${url}/signin">sign in</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="${url}/signout">sign out</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="${url}/signup">Sign Up</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="${url}/changepassword">Change Password</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="${url}/history">History</a></li>
                                </ul>
                            </li>
                        </ul>
                        <form class="d-flex me-5" role="search">
                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-danger" type="submit">Search</button>
                        </form>
                    </div>
                </div>
            </nav>
        </div>
</body>
</html>