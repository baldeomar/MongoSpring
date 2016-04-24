<%@ page contentType="text/html; ISO-8859-1" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<title><spring:message code="page.login.title"/></title>
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
</head>
<body onload='document.loginForm.email.focus();'>
	<div id="login-box" class="container">
		<h2><spring:message code="page.login.form.title"/></h2>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty message}">
			<div class="error">${message}</div>
		</c:if>

		<form id="loginForm" name="loginForm" action="<c:url value='j_spring_security_check'/>" method='POST'>
			<div class="row">
				<div class="col-xs-6">
					<div class="col-sm-3">Email:</div>
					<div class="col-sm-3"><input type='text' name='email' value=''></div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-6">
					<div class="col-sm-3">Password:</div>
					<div class="col-sm-3"><input type='password' name='password' value=''></div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-9">
					<div class="col-sm-3">
						<input class="button" type="submit" value="Envoyer"/>
					</div>
					<div class="col-sm-6">
						<a href="<c:url value='${registerPage}'/>"><spring:message code="page.login.signup"/></a>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>