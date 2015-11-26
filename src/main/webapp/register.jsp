<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>
			<spring:message code="label.form.title" />
		</title>
	</head>
	<body>
	    <H1>Welcome To Register</H1>
	    <form:form action="${pageContext.request.contextPath}${registerPostLink}" modelAttribute="person" method="POST" enctype="utf8">
	        <br>
			<table>
				<tbody>
					<tr>
						<td><label>Prenom: </label></td>
						<td><form:input path="prenom" autocomplete="off" /></td>
                        <td><form:errors path="prenom"/></td>
					</tr>
					<tr>
						<td><label>Nom: </label></td>
						<td><form:input path="nom" autocomplete="off" /></td>
                        <td><form:errors path="nom"/></td>
					</tr>
					<tr>
						<td><label>Email: </label></td>
						<td><form:input path="email" autocomplete="off"/></td>
						<td><form:errors cssClass="error" path="email"/></td>
					</tr>
					<tr>
						<td><label>Password: </label></td>
						<td><form:input path="password" type="password" /></td>
						<td><form:errors path="password" cssClass="error"/></td>
					</tr>
					<tr>
						<td><label>Confirm password: </label></td>
						<td><form:input path="matchingPassword" type="password" /></td>
						<td><form:errors path="matchingPassword" cssClass="error"/></td>
					</tr>
					<tr>
						<td colspan="2">
					   		<button type="submit">Send</button>
						</td>
					</tr>
				</tbody>
			</table>
	    </form:form>
	    <br>
	</body>
</html>