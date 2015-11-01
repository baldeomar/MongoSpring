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
	    <form:form modelAttribute="person" method="POST" enctype="utf8">
	        <br>
	        <tr>
		        <td><label>First Name: </label></td>
		        <td><form:input path="firstName" autocomplete="off" /></td>
		        <form:errors cssClass="error" path="firstName" element="div"/>
	    	</tr>
	    	<tr>
		        <td><label>Last Name: </label></td>
		        <td><form:input path="lastName" autocomplete="off" /></td>
		        <form:errors cssClass="error" path="lastName" element="div" />
		    </tr>
		    <tr>
		        <td><label>Email: </label></td>
		        <td><form:input path="email" autocomplete="off"/></td>
		        <form:errors cssClass="error" path="email" element="div" />
		    </tr>
		    <tr>
		        <td><label>Password: </label></td>
		        <td><form:input path="password" type="password" /></td>
		        <form:errors cssClass="error" path="password" element="div" />
		    </tr>
		    <tr>
		        <td><label>Confirm password: </label></td>
		        <td><form:input path="matchingPassword" type="password" /></td>
		        <form:errors cssClass="error" path="matchingPassword" element="div" />
		    </tr>
		       <button type="submit">Send</button>
	    </form:form>
	    <br>
	    <a href="<c:url value="login.jsp" />">Sign in</a>
	</body>
</html>