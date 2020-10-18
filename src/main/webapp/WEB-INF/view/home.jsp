<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<link rel="stylesheet" href="/resources/css/bootstrap.css" />
<link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="all" />

<!DOCTYPE html>
<html>
    <head>
        <title>Sales Manager</title>
    </head>
    <body>
        <header>
            <div class="topnav">
                <a class="active" href="#home">Home</a>
                <a href="#orders">My Orders</a>
                <a href="#profile">Profile</a>
            </div>
        </header>
        <div class="container">
            <div class="grid">
            <c:forEach items="${products }" var="product">
                <a href="#">
                    <div class="product-div">
                        <h2>${product.name }</h2>
                        <h4>R$ ${product.unitaryValue}</h4>
                    </div>
                </a>
            </c:forEach>
            </div>
        </div>
    </body>
</html>