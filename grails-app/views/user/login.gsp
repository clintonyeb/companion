<%--
  Created by IntelliJ IDEA.
  User: clinton
  Date: 2/8/16
  Time: 3:25 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>LogIn:</title>
</head>

<body>
<h2>Login</h2>
<g:hasErrors>
    <g:renderErrors bean="${user}" as="list"/>
</g:hasErrors>
<g:if test="${flash.message}">
    <p class="alert-danger">${flash.message}</p>
</g:if>
<g:form action="loginUser">
    <ul>
        <li>
            <label for="nickName">Username:</label>
            <g:textField name="nickName" value="${nickNmae}"/>
        </li>
        <li>
            <label for="password">Password:</label>
            <g:passwordField name="password"/>
        </li>
        <li class="button button-default">
            <g:submitButton name="Login" value="Login" type="submit"/>
        </li>
    </ul>
</g:form>
</body>
</html>