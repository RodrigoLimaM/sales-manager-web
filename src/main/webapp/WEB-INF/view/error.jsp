<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<link rel="stylesheet" href="/resources/css/bootstrap.css" />
<link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="all" />

<!DOCTYPE html>
<html>
    <head>
        <title>Sales Manager - Order</title>
    </head>
    <body>
        <header>
            <div class="topnav">
                <a class="active" href="/">Home</a>
                <security:authorize access="hasAuthority('ADMIN')">
                    <a href="/order/orderManagement">Manage Orders</a>
                    <a href="/product/add">Add Product</a>
                </security:authorize>
                <div class="rigth-topnav">
                    <security:authorize access="!isAuthenticated()">
                        <div class="login"><a href="/login">login</a></div>
                    </security:authorize>
                    <security:authorize access="isAuthenticated()">
                        <a href="/order/myOrders/<security:authentication property="principal._id" />">My Orders</a>
                        <a href="#">Welcome <security:authentication property="principal.name" />!</a>
                        <a href="#">Your balance: $ <security:authentication property="principal.balance" /></a>
                        <a href="/logout">logout</a>
                    </security:authorize>
                </div>
            </div>
        </header>
        <div class="container">
            <div class="error">Something went wrong, try again later. :(</div>
        </div>
    </body>
</html>