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
    <title>Sales Manager - Product Add</title>
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
            <div class="product-form">
                <%--@elvariable id="productRequest" type="br.com.salesmanagerweb.model.ProductRequest"--%>
                <form:form action="${s:mvcUrl('PC#addProduct').build() }" method="POST" modelAttribute="productRequest">
                    <div class="field-form">
                        <label>Name</label>
                        <form:input path="name" cssClass="form-control text-center"/>
                    </div>
                    <div class="field-form">
                        <label>Quantity</label>
                        <form:input path="quantity" type="number" cssClass="form-control text-center"/>
                    </div>
                    <div class="field-form">
                        <label>Unitary value</label>
                        <form:input path="unitaryValue" cssClass="form-control text-center"/>
                    </div>
                    <div class="field-form">
                        <label>Description</label>
                        <form:input path="description" cssClass="form-control text-center"/>
                    </div>
                    <div class="add-product-button"><button type="submit" class="btn btn-dark btn-lg btn-block">Add Product</button></div>
                </form:form>
            </div>
        </div>
    </body>
</html>