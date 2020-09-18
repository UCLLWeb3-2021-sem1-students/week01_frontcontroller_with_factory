<%@page import="domain.model.Country" %>
<%@page import="java.util.Collection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/sample.css">
    <meta charset="UTF-8">
    <title>Countries</title>
</head>
<body>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="Countries"/>
</jsp:include>

<main id="container">
    <p>
        <a href="index.html">Home</a>
    </p>
    <article>
        <c:if test="${popular != null}">
            <p>
                The most popular country is
                    ${popular.name}
            </p>
        </c:if>
        <c:if test="${countries != null}">
            <table id="overview">
                <tr>
                    <th>Name</th>
                    <th>Capital</th>
                </tr>
                <c:forEach var="country" items="${countries}">
                    <tr>
                        <td>${country.name}</td>
                        <td>${country.capital}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <p>
            <a href="countryAdd.jsp">Add new country</a>
        </p>
        <p>
            <a href="countrySearch.jsp">Search country</a>
        </p>
    </article>
</main>
</body>
</html>