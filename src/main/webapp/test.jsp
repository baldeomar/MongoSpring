<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>metzojack: ${label}</title>
	</head>
	<body>
	    <H1>label ici: ${label}</H1>
	    <br>
	    <a href="<c:url value="login.jsp" />">Sign in</a>
	</body>
</html>