<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
</head>
<body>
<main ng-app="myapp">
<c:url var="url" value="/HDTTube"/>
        <div class="container" ng-controller="myctrl">
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item" role="presentation">
                    <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home-tab-pane"
                        type="button" role="tab" aria-controls="home-tab-pane" aria-selected="true">
                        Video Edition
                    </button>
                </li>
                <li class="nav-item" role="presentation">
                    <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile-tab-pane"
                        type="button" role="tab" aria-controls="profile-tab-pane" aria-selected="false">
                        Video List
                    </button>
                </li>
            </ul>
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home-tab-pane" role="tabpanel" aria-labelledby="home-tab"
                    tabindex="0">
                    <div class="row mt-4">
                    <form class="d-flex" action="${url}/videomanager" method="POST">
                        <div class="col-7 me-2">
	                         <div class="form-floating mb-3">
	                                <input type="text" name="title" class="form-control" ng-init="title='${form.getTitle()}'" ng-model="title" id="floatingPassword" placeholder="Title" >
	                                <label for="floatingPassword">Video title</label>
	                        	</div>
	                            <div class=" form-floating mb-3">
	                                <textarea id="txtDiscription" placeholder="Discription" name="describe" type="text" class="form-control"
	                                    name="" style="height: 18rem;">${form.getDescribe()}</textarea>
	                                <label for="txtDiscription">Discription</label>
	                            </div>
	                            <div class="">
	                                <button formaction="${url}/videomanager/create"  class="btn btn-outline-danger btn-lg">Create</button>
	                                <button formaction="${url}/videomanager/update"  class="btn btn-outline-danger btn-lg">Update</button>
	                                <button formaction="${url}/videomanager/delete"  class="btn btn-outline-danger btn-lg">Delete</button>
	                                <button formaction="${url}/videomanager/reset"  class="btn btn-outline-danger btn-lg">Reset</button>
	                            </div>
                        </div>
                        <div class="col-5 me-2">
                            <!--<iframe width="100%" height="315" src="https://www.youtube.com/embed/${form.getId()}"> </iframe> -->
                            <img class="card-img-top" style="width=100%; height=315;"  src="{{'https://i3.ytimg.com/vi/'+idPoster+'/maxresdefault.jpg'}}">
                            <div class="mb-3">
                                <label for="basic-url" class="form-label">Your vanity URL</label>
                                <div class="input-group">
                                  <span class="input-group-text" id="basic-addon3">https://www.youtube.com/watch?v=</span>
                                  
                                  <input type="text" class="form-control" ng-init="idPoster='${form.getId()}'" ng-model="idPoster" name="id" id="basic-url">
                                </div>
                                <div class="form-text text-light" id="basic-addon4 ">{{title}}</div>
                              </div>
                        </div>
                        </form>
                    </div>
                </div>
                <div class="tab-pane fade" id="profile-tab-pane" role="tabpanel" aria-labelledby="profile-tab" tabindex="0">   
                    <table class="table table-light border-danger table-bordered table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Youtube ID</th>
                                <th scope="col">Video title</th>
                                <th scope="col">View count</th>
                                <th scope="col">edit</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="vd" items="${vd}">
                        <tr>
                             <th scope="row">${vd.getId()}</th>
                             <td>${vd.getTitle()}</td>
                             <td>${vd.getView().size()}</td>
                             <td><a href="${url}/videomanager/${vd.getId()}">edit</a></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                        <tfoot>
                            <th colspan="5" class="position-relative">
                                <span>${sizeVideo} Videos</span>
                                <!--  
	                            <div class="  position-absolute top-50 end-0 translate-middle">       
	                                    <button type="button" class="btn btn-primary"><i class="bi bi-arrow-bar-left"></i></button>
	                                    <button type="button" class="btn btn-primary"><i class="bi bi-arrow-left"></i></button>
	                                    <button type="button" class="btn btn-primary"><i class="bi bi-arrow-right"></i></button>
	                                    <button type="button" class="btn btn-primary"><i class="bi bi-arrow-bar-right"></i></button>
	                            </div>
	                            -->
                            </th>
                        </tfoot>
                    </table>
                </div>
            </div>
        </div>
    </main>
    
<script>
	var app = angular.module("myapp",[])
	app.controller("myctrl",function($scope){
		
	});
</script>
</body>
</html>