<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<link rel="stylesheet" href="/resources/css/bootstrap.css" />
<link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="all" />

<!DOCTYPE html>
<html>
    <head>
        <title>Sales Manager - Orders</title>
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
                        <a href="/logout">logout</a>
                        <a href="/order/myOrders/<security:authentication property="principal._id" />">My Orders</a>
                        <a href="#">Welcome <security:authentication property="principal.name" />!</a>
                        <a href="#">Your balance: $ <security:authentication property="principal.balance" /></a>
                    </security:authorize>
                </div>
            </div>
        </header>
        <div class="container">
            <div class="orders-title">Orders:</div>
            <div class="orders-grid">
                <c:forEach items="${orders }" var="order">
                    <a href="${s:mvcUrl('OC#getOrderById').arg(0, order._id).build() }">
                        <div class="order-collection">
                            <h6>Order: ${order._id }</h6>
                            <h6>Customer: ${order.customerId }</h6>
                            <h6>Product: ${order.productId }</h6>
                        </div>
                    </a>
                </c:forEach>
            </div>
        </div>
    </body>
</html>