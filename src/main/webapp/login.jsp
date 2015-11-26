<%@ page contentType="text/html; ISO-8859-1" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<title><spring:message code="page.login.title"/></title>
	<link rel="stylesheet" href="resources/css/pages/login.css"/>
</head>
<body onload='document.loginForm.email.focus();'>
	<div id="login-box">
		<h2><spring:message code="page.login.form.title"/></h2>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty message}">
			<div class="msg">${message}</div>
		</c:if>

		<form name='loginForm'
		  action="<c:url value='j_spring_security_check' />" method='POST'>

		  <table>
			<tr>
				<td>Email:</td>
				<td><input type='text' name='email' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'>
					<input name="submit" type="submit" value="submit" />
				</td>
			</tr>
			  <tr>
				  <td colspan='2'>
					  <a href="<c:url value='${registerPage}'/>"/><spring:message code="page.login.signup"/> </a>
				  </td>
			  </tr>
		  </table>

		  <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

		</form>
	</div>
</body>
</html>