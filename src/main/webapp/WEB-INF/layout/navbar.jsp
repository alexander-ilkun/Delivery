<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<tilesx:useAttribute name="current"/>
<nav class="navbar navbar-default navbar-static-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<spring:url value="/" />">Pizza Delivery</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="${current == 'home' ? 'active' : ''}"><a href="<spring:url value="/" />">Home</a></li>
                <security:authorize access="isAuthenticated()">
                    <li class="${current == 'personalinfo' ? 'active' : ''}"><a href="<spring:url value="/app/personalinfo.html" />">Personal info</a></li>
                    <li class="${current == 'orders' ? 'active' : ''}"><a href="<spring:url value="/app/orders.html" />">Orders</a></li>
                </security:authorize>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <security:authorize access="!isAuthenticated()">
                    <li class="${current == 'login' ? 'active' : ''}" ><a href="<spring:url value="/app/login.html" />">Login</a></li>
                    <li class="${current == 'register' ? 'active' : ''}" ><a href="<spring:url value="/app/register.html" />">Register</a></li>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
                    <li>
                        <a href="#" onclick="document.getElementById('logout-form').submit();" >
                            <form id="logout-form" action="<spring:url value="/logout" />" method="POST">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            </form>
                            Logout
                        </a>
                    </li>
                </security:authorize>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>