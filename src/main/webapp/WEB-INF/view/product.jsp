<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
            </div>
        </header>
        <div class="container">
            <%--@elvariable id="quantityDTO" type="br.com.salesmanagerweb.model.dto.QuantityDTO"--%>
            <form:form action="${s:mvcUrl('OC#createOrder').arg(0, product._id).build() }" method="POST" modelAttribute="quantityDTO">
                <div class="product-details">
                    <div class="product-name">${product.name }</div>
                    <div class="product-value">R$ ${product.unitaryValue }</div>
                    <div class="product-description">${product.description}</div>
                    <div class="buy-quantity">
                        <label for="quantity">Quantidade:</label>
                        <form:select class="form-control btn-dark" path="quantity">
                            <c:forEach var="i" begin="1" end="${product.quantity }" step="1">
                                <form:option value="${i }" label="${i }" />
                            </c:forEach>
                        </form:select>
                    </div>
                    <div class="buy-button"><button type="submit" class="btn btn-dark btn-lg btn-block">BUY NOW!</button></div>
                </div>
            </form:form>
        </div>
    </body>
</html>