<%--
  Created by IntelliJ IDEA.
  User: Giacinto
  Date: 26/04/2016
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link rel="stylesheet"href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Welcome</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1 class="alert alert-danger"> There is no product found with the Product id ${invalidProductId}</h1>
        </div>
    </div>
</section>
<section>
    <div class="container">
        <p>${url}</p>
        <p>${exception}</p>
    </div>
    <div class="container">
        <p>
            <a href="<spring:url value="/products" />"class="btn btn-primary">
                <span class="glyphicon-hand-left glyphicon"></span>
                products
            </a>
        </p>
    </div>
</section>
</body>
</html>
