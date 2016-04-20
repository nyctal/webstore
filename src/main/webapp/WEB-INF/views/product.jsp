<%--
  Created by IntelliJ IDEA.
  User: Giacinto
  Date: 04/04/2016
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Products</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Products</h1>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <div class="col-md-5">
            <img src="<c:url value="/resource/images/${product.productId}.png"> </c:url>" alt="image" style = "width:100%"/>
        </div>
        <div class="col-md-5">
            <h3>${product.name}</h3>
            <p>${product.description}</p>
            <p>
                <strong>Item Code : </strong><span class="label labelwarning">${product.productId}</span>
            </p>
            <p>
                <strong>manufacturer</strong> : ${product.manufacturer}
            </p>
            <p>
                <strong>category</strong> : ${product.category}
            </p>
            <p>
                <strong>Availble units in stock </strong> : ${product.unitsInStock}
            </p>
            <h4>${product.unitPrice} USD</h4>
            <p>
                <a href="<spring:url value="/products" />" class="btn btn-default">
                    <span class="glyphicon-hand-left glyphicon"></span> back
                </a>
                <a href="#" class="btn btn-warning btn-large"> <span class="glyphicon-shopping-cart glyphicon"></span> Order Now </a>
            </p>
        </div>
    </div>
</section>
</body>
</html>
