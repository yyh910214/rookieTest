<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="<c:url value='/js/validation.js'/>"></script>
<title>Insert Document</title>
</head>
<body>

	
	<c:if test="${!empty document.email}">
		<c:set var="targetURL" value="${pageContext.request.contextPath}/boards/${document.idx}"/>
	</c:if>
	<c:if test="${empty document.email }">
		<c:set var="targetURL" value="${pageContext.request.contextPath}/boards"/>
	</c:if>
	

	<h2 class="text-center">
		Guest Board 입력<small>NHN ent. pretest</small>
	</h2>
	<div class="container-fluid">
		<form:form modelAttribute="document"
			action="${targetURL}" method="post"
			onSubmit="return validateForm();">
			<table style="width: 80%">

				<tr>
					<td><form:label path="email">Email</form:label></td>
					<c:if test="${!empty document.email}">
					<td><form:input path="email" required="true" readonly="true"></form:input><form:errors path="email" /></td>
					</c:if>
					<c:if test="${empty document.email }">
					<td><form:input path="email" required="true"></form:input><form:errors path="email" /></td>
					</c:if>
				</tr>

				<tr>
					<td><form:label path="password">Password</form:label></td>
					<td><form:input path="password"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="content">Content</form:label></td>
					<td><form:input path="content"></form:input></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Add Document" />
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>