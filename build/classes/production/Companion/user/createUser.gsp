<%--
  Created by IntelliJ IDEA.
  User: clinton
  Date: 1/8/16
  Time: 9:47 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>New Account</title>
</head>

<body>
<div>
    <g:form action="newUser">
        <ul>
            <li>
                <label for="nickName">Username:</label>
                <g:textField name="nickName" value="${nickNmae}"/>
            </li>
            <li>
                <label for="password">Password:</label>
                <g:passwordField name="password"/>
            </li>
            <li>
                <g:submitButton name="Register" value="Register" type="submit"/>
            </li>
        </ul>
    </g:form>
</div>

</body>
</html>