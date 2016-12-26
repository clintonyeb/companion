<%--
  Created by IntelliJ IDEA.
  User: clinton
  Date: 31/7/16
  Time: 4:22 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Search News</title>
    <meta name="layout" content="main"/>
</head>

<body>
<h2>Search News Here:</h2>
<formset>
    <g:form action="search">
        <label for="sectionQuery"></label>
        <g:textField name="sectionQuery" value="${searchQuery ?: 'Search'}"/>
        <g:submitButton name="search" value="Search"/>
    </g:form>
</formset><br/>
<hr>
<g:if test="${newsItems && searchQuery}">
    <h2>Search Results For <em>${searchQuery}</em>: <b>${newsItems.size()}</b></h2>
    <ol>
        <g:each in="${newsItems}">

            <li>
                <h2>${it.webTitle}</h2>

                <p>${it.trailText}</p>
                <em>${it.tag}</em>
            </li>
        </g:each>
    </ol>
</g:if>
</body>
</html>