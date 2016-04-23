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
        <script type="text/javascript" src="resources/js/jquery.js"/>
        <script>
            jQuery(function($){
                $("#date_de_naissance").mask("99/99/9999",{placeholder:"mm/dd/yyyy"});
            });
        </script>
    </head>
    <body>
        <H1>Welcome To Register</H1>
        <form:form modelAttribute="personneForm" action="${pageContext.request.contextPath}${registerPost}" method="POST">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12">
                        <div id="email" class="col-sm-6">Email: </div>
                        <div class="col-sm-6 ${status.error ? 'has-error' : ''}">
                            <form:input path="email" id="inputEmail"/>
                            <form:errors cssClass="error" path="email"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <div id="password" class="col-sm-6">Password: </div>
                        <div class="col-sm-6">
                            <form:password path="password" id="inputPassword"/>
                            <form:errors cssClass="error" path="password"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <div id="passwordMatch" class="col-sm-6">Confirm password: </div>
                        <div class="col-sm-6">
                            <form:password path="matchingPassword" id="inputMatchingPassword"/>
                            <form:errors cssClass="error" path="matchingPassword"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <div id="prenom" class="col-sm-6">Prénom: </div>
                        <div class="col-sm-6">
                            <form:input path="prenom"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <div id="nom" class="col-sm-6">Nom: </div>
                        <div class="col-sm-6">
                            <form:input path="nom"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <div id="date_de_naissance" class="col-sm-6">Date de naissance: </div>
                        <div class="col-sm-6">
                            <form:input path="date_de_naissance" />
                        </div>
                    </div>
                </div>
                <div class="row">
                    <input type="submit" id="formSubmit" value="Send"/>
                </div>
            </div>
        </form:form>
    </body>
</html>