<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<form class="form-signin" action="<spring:url value="/app/register" />" method="POST">
    <h2 class="form-signin-heading">Registration</h2>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <label for="usernamefield" class="sr-only">Username</label>
    <input type="text" id="usernamefield" name="name" class="form-control" placeholder="Username" required autofocus>
    <label for="passwordfield" class="sr-only">Password</label>
    <input type="password" id="passwordfield" name="password" class="form-control" placeholder="Password" required>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
</form>

