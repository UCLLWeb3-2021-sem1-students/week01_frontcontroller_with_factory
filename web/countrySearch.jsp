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
    <jsp:param name="title" value="Search Country"/>
</jsp:include>
<main id="container">
    <article>
        <form method="POST" action="Controller?command=Search">
            <fieldset>
                <legend>Identification</legend>
                <p class="form-grou">
                    <label class="control-label" for="name">Name (required): </label> <input
                        id="name" name="name" type="text"
                        value="">
                </p>
            </fieldset>

            <p>
                <label for="bewaar">&nbsp;</label><input id="bewaar" type="submit"
                                                         value="Search">
            </p>

        </form>
    </article>
</main>
</body>
</html>