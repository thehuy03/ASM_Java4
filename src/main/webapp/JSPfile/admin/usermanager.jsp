<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<body>
<c:url var="url" value="/HDTTube"/>
	<main style="backdrop-filter: blur(3px);">
        <div class="container">
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item" role="presentation">
                    <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home-tab-pane"
                        type="button" role="tab" aria-controls="home-tab-pane" aria-selected="true">
                        User Edition
                    </button>
                </li>
                <li class="nav-item" role="presentation">
                    <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile-tab-pane"
                        type="button" role="tab" aria-controls="profile-tab-pane" aria-selected="false">
                        User List
                    </button>
                </li>
            </ul>
            <div class="tab-content" id="myTabContent">
            <form action="${url}/edit" method="POST">
	                <div class="tab-pane fade show active" id="home-tab-pane" role="tabpanel" aria-labelledby="home-tab"
	                    tabindex="0">
	                    <div class="d-flex mb-3" >
	                        <div class="form-floating me-5"style="width: 50%;">
	                            <input value="${us.getId()}" type="text" name="id" class="form-control" id="floatingInput" placeholder="Username">
	                            <label for="floatingInput">Username</label>
	                        </div>
	                        <div class="form-floating" style="width: 50%;">
	                            <input value="${us.getPassword()}" type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password">
	                            <label for="floatingPassword">Password</label>
	                        </div>
	                    </div>
	                    <div class="d-flex mb-3">
	                        <div class="form-floating me-5" style="width: 48%;">
	                            <input value="${us.getEmail()}" type="email" name="email" class="form-control" id="floatingInput" placeholder="name@example.com">
	                            <label for="floatingInput">Email address</label>
	                        </div>
	                        <div class="d-flex mb-3 border-1 fs-3">
	                            <div class="form-check  me-5" style="width: 50%;">
	                                <input ${us.getRole()?'checked':''} name="role" value="true" class="form-check-input" type="radio"  id="flexRadioDefault1">
	                                <label class="form-check-label text-light" for="flexRadioDefault1">admin</label>
	                              </div>
	                              <div class="form-check me-3">
	                                <input  class="form-check-input" name="role" value="false" type="radio" ${us.getRole()?'':'checked'}  id="flexRadioDefault2"\>
	                                <label class="form-check-label text-light" for="flexRadioDefault2">user </label>
	                              </div>
	                            </div>
	                    </div>
	                    <div>
	                        <button class="btn btn-danger"  formaction="${url}/edit/updateuser/${us.getId()}" >Update</button>
	                        <button formaction="${url}/edit/deleteuser/${us.getId()}"  class="btn btn-danger">Delete</button>
	                    </div>
	                </div>
                </form>
                <div class="tab-pane fade" id="profile-tab-pane" role="tabpanel" aria-labelledby="profile-tab"
                    tabindex="0">
                    <table class="table table-light border-danger table-bordered table-striped">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Password</th>
                                <th scope="col">Email</th>
                                <th scope="col">Role</th>
                                <th scope="col">edit</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="u" items="${item}" varStatus="loop">
	                        <tr>
	                                <th scope="row">${u.getId()}</th>
	                                <td>${u.getPassword()}</td>
	                                <td>${u.getEmail()}</td>
	                                <td>${u.getRole()}</td>
	                                <td><a href="${url}/edit/${u.getId()}">edit</a></td>
	                            </tr>
                        </c:forEach>
                            
                        </tbody>
                        <tfoot>
                            <th colspan="6" class="position-relative">
                                <span>${usSize} views</span>
                                
                            </th>
                        </tfoot>
                    </table>
                </div>
            </div>
        </div>
    </main>
</body>
</html>