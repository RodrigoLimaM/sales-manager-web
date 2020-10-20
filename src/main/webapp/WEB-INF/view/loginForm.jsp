<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link rel="stylesheet" href="/resources/css/bootstrap.css" />
<link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="all" />

<!DOCTYPE html>
<html>
    <head>
        <title>Sales Manager - Login</title>
    </head>
    <body>
        <header>
            <div class="topnav">
                <a class="active" href="/">Home</a>
            </div>
        </header>
        <div class="container">
            <div class="login-form">
                <form:form servletRelativeAction="/login" method="post">
                    <div class="form-group">
                        <label>E-mail</label>
                        <input name="username" type="text" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <input name="password" type="password" class="form-control"/>
                    </div>
                    <button type="submit" class="btn btn-dark btn-lg btn-block">Login</button>
                </form:form>
                <c:if test="${ param.error ne null}">
                    <div class="login-error">Invalid username/password</div>
                </c:if>
            </div>
        </div>
    </body>
</html>