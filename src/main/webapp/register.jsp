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
		        <td><label>Prenom: </label></td>
		        <td><form:input path="prenom" autocomplete="off" /></td>
	    	</tr><br>
	    	<tr>
		        <td><label>Nom: </label></td>
		        <td><form:input path="nom" autocomplete="off" /></td>
		    </tr><br>
		    <tr>
		        <td><label>Email: </label></td>
		        <td><form:input path="email" autocomplete="off"/></td>
				<td><span id="errorEmail" class="error" style="visibility: hidden; color: red">
					<spring:message code="input.champs.incorrect"></spring:message></span></td>
		    </tr><br>
		    <tr>
		        <td><label>Password: </label></td>
		        <td><form:input path="password" type="password" /></td>
		    </tr><br>
		    <tr>
		        <td><label>Confirm password: </label></td>
		        <td><form:input path="matchingPassword" type="password" /></td>
		    </tr><br>
		       <button type="submit">Send</button>
	    </form:form>
	    <br>
	</body>
</html>