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
        <title>Sales Manager - Order</title>
    </head>
    <body>
        <header>
            <div class="topnav">
                <a class="active" href="/">Home</a>
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
            <div class="order-form">
                <%--@elvariable id="orderRequest" type="br.com.salesmanagerweb.model.OrderRequest"--%>
                <form:form action="${s:mvcUrl('OC#requestOrder').build() }" method="POST" modelAttribute="orderRequest">
                    <div class="field-form">
                        <label>Recipient</label>
                        <form:input path="address.recipient" cssClass="form-control text-center"/>
                    </div>
                    <div class="field-form">
                        <label>Street</label>
                        <form:input path="address.street" cssClass="form-control text-center"/>
                    </div>
                    <div class="field-form">
                        <label>Number</label>
                        <form:input type="number" path="address.number" cssClass="form-control text-center"/>
                    </div>
                    <div class="field-form">
                        <label>ZipCode</label>
                        <form:input path="address.zipCode" cssClass="form-control text-center"/>
                    </div>
                    <div class="field-form">
                        <label>City</label>
                        <form:input path="address.city" cssClass="form-control text-center"/>
                    </div>
                    <div class="field-form">
                        <label>State</label>
                        <form:input path="address.state" cssClass="form-control text-center"/>
                    </div>
                    <div class="field-form">
                        <label>Country</label>
                        <form:input path="address.country" cssClass="form-control text-center"/>
                    </div>
                    <security:authentication property="principal._id" var="customerId"/>
                    <form:hidden path="customerId" value="${customerId }"/>
                    <form:hidden path="productId" value="${product_id }"/>
                    <form:hidden path="productQuantity" value="${quantity }"/>
                    <div class="buy-button"><button type="submit" class="btn btn-dark btn-lg btn-block">ORDER NOW!</button></div>
                </form:form>
            </div>
        </div>
    </body>
</html>