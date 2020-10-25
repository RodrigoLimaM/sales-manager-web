<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link rel="stylesheet" href="/resources/css/bootstrap.css" />
<link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="all" />

<!DOCTYPE html>
<html>
    <head>
        <title>Sales Manager - Register</title>
    </head>
    <body>
        <header>
            <div class="topnav">
                <a class="active" href="/">Home</a>
            </div>
        </header>
        <div class="container">
            <div class="register-form">
                <%--@elvariable id="customerRequest" type="br.com.salesmanagerweb.model.CustomerRequest"--%>
                <form:form action="${s:mvcUrl('RC#registerUser').build() }" method="POST" modelAttribute="customerRequest">
                    <div class="field-form">
                        <label>Name</label>
                        <form:input path="name" cssClass="form-control text-center"/>
                    </div>
                    <div class="field-form">
                        <label>Email</label>
                        <form:input path="email" cssClass="form-control text-center"/>
                    </div>
                    <div class="field-form">
                        <label>Password</label>
                        <form:password path="password" cssClass="form-control text-center"/>
                    </div>
                    <form:hidden path="balance" value="0"/>
                    <div class="register-button"><button type="submit" class="btn btn-dark btn-lg btn-block">Register</button></div>
                </form:form>
            </div>
        </div>
    </body>
</html>