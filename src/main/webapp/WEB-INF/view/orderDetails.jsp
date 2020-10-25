<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>

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
            <div class="order-details">
                <div class="address">
                    <div class="order-details-title">Product: ${productName }</div>
                    Quantity: ${orderRequest.productQuantity }<br>
                    TotalValue: ${orderRequest.orderTotalValue }<br>
                    Delivery address : ${orderRequest.address.street }, ${orderRequest.address.number }<br>
                    ${orderRequest.address.zipCode } - ${orderRequest.address.city } - ${orderRequest.address.state } - ${orderRequest.address.country }<br>
                    To: ${orderRequest.address.recipient }
                </div>
                <div class="tracking">
                    <c:if test="${tracking.steps != null}">
                        <div class="order-details-title">Tracking:</div>
                        <c:forEach items="${tracking.steps }" var="step" varStatus="status">
                            <c:if test="${step.finisher eq false}">
                                <div class="tracking-step">${step.description }: <javatime:format value="${step.date}" pattern="dd/MM/yyyy - HH:mm:ss" /></div>
                            </c:if>
                            <c:if test="${step.finisher eq true && step.description == 'Delivered'}">
                                <div class="tracking-step-good">${step.description }: <javatime:format value="${step.date}" pattern="dd/MM/yyyy - HH:mm:ss" /></div>
                            </c:if>
                            <c:if test="${step.finisher eq true && step.description != 'Delivered'}">
                                <div class="tracking-step-bad">${step.description }: <javatime:format value="${step.date}" pattern="dd/MM/yyyy - HH:mm:ss" /></div>
                            </c:if>
                            <c:if test="${!status.last }">
                                <img src="https://icons-for-free.com/iconfiles/png/512/Arrow+Down+Direction+Wayfinding+Download-131983793705547942.png" width="30" height="30">
                                <br>
                            </c:if>
                        </c:forEach>
                        <security:authorize access="hasAuthority('ADMIN')">
                            <%--@elvariable id="trackingRequest" type="br.com.salesmanagerweb.model.TrackingRequest"--%>
                            <form:form action="${s:mvcUrl('TC#changeOrderStatus').arg(0, orderRequest._id).build() }" method="POST" modelAttribute="trackingRequest">
                                <div class="select-step">
                                    <form:select class="form-control btn-dark" path="step">
                                        <c:forEach items="${statuses }" var="status">
                                            <form:option value="${status }" label="${status }"/>
                                        </c:forEach>
                                    </form:select>
                                </div>
                                <div class="update-button"><button type="submit" class="btn btn-dark btn-lg btn-block">Update</button></div>
                            </form:form>
                        </security:authorize>
                    </c:if>
                    <c:if test="${tracking.steps == null && orderRequest.orderStatus == 'CANCELLED'}">
                        <div class="order-details-title">Rejected payment :(</div>
                    </c:if>
                    <c:if test="${tracking.steps == null && orderRequest.orderStatus != 'CANCELLED'}">
                        <div class="order-details-title">Approved payment, wait for more information :)</div>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>