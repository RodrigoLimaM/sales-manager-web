<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>


<link rel="stylesheet" href="/resources/css/bootstrap.css" />
<link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="all" />

<!DOCTYPE html>
<html>
    <head>
        <title>Sales Manager - ${product.name }</title>
    </head>
    <body>
        <header>
            <div class="topnav">
                <a class="active" href="/">Home</a>
                <a href="#orders">My Orders</a>
                <a href="#profile">Profile</a>
                <div class="rigth-topnav">
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
            <%--@elvariable id="quantityRequest" type="br.com.salesmanagerweb.model.QuantityRequest"--%>
            <form:form action="${s:mvcUrl('OC#createOrder').arg(0, product._id).build() }" method="POST" modelAttribute="quantityRequest">
                <div class="product-details">
                    <div class="product-name">${product.name }</div>
                    <div class="product-value">$ ${product.unitaryValue }</div>
                    <div class="product-description">${product.description}</div>
                    <div class="buy-quantity">
                        <label for="quantity">Quantity:</label>
                        <form:input type="number" min="1" max="${product.quantity }" path="quantity" cssClass="form-control text-center"/>
                    </div>
                    <div class="buy-button"><button type="submit" class="btn btn-dark btn-lg btn-block">BUY NOW!</button></div>
                </div>
            </form:form>
        </div>
    </body>
</html>