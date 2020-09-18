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
    <jsp:param name="title" value="Details Country"/>
</jsp:include>

<main id="container">
    <p>
        <a href="index.html">Home</a>
    </p>
    <article>
        <c:if test="${country != null}">
            <p>Name: ${country.name}</p>
            <p>Capital: ${country.capital}</p>
            <p>Inhabitants: ${country.numberInhabitants}</p>
            <p>Votes: ${country.votes}</p>
        </c:if>
        <p>
            <a href="Controller?command=Overview">Overview</a>
        </p>
    </article>
</main>
</body>
</html>