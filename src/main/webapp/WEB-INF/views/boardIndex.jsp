<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
	<title>Guest Board</title>
</head>
<body>
<h2 class="text-center">Guest Board <small>NHN ent. pretest</small></h2>

<div class="container">
	<a class="btn btn-primary" href="${pageContext.request.contextPath}/board/insert" role="button">삽입</a>
	<table class="table table-striped">
		<th>
			<td>email</td>
			<td style="width :60%">content</td>
			<td>modDate</td>
			<td>Modify</td>
		</th>
		<c:forEach items="${documentList }" var="document">
			<tr>
				<td>${document.idx }</td>
				<td>${document.email }</td>
				<td>${document.content }</td>
				<td>${document.modDate }</td>
				<td><a class="btn btn-default" href="${pageContext.request.contextPath}/board/update/${document.idx }" role="button">Link</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>
