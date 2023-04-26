<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<table class="table table-light border-danger table-bordered table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Video ID</th>
                            <th scope="col">Video title</th>
                            <th scope="col">Like</th>
                        </tr>
                    </thead>
                    <tbody>
					<c:forEach var="i" items="${RpVdLike}">
						<tr>
                            <th scope="row">${i.id}</th>
                            <td>${i.title}</td>
                            <td>${i.getFavorites().size()}</td>
                        </tr>
					</c:forEach>
                    </tbody>
                    <tfoot>
                        <th colspan="5" class="position-relative">
                            <span>${RpVdLike.size()} video</span>
                        </th>
                    </tfoot>
                </table>
</body>
</html>