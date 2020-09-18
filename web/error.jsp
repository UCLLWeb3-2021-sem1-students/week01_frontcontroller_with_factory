<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
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
	<jsp:param name="title" value="OEPS"/>
</jsp:include>
<main id="container">	<article>
	</article>
	<p>${error}</p>
	</main>
    </body>
</html>
