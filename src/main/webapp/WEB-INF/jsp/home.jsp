<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="well well-sm pre-scrollable col-sm-4" id="left" style="overflow-y: scroll; min-height: 80%;">
    <c:if test="${not empty bucket.orderDetails}">
        <a href="<spring:url value="/app/order/checkout/" />" class="btn btn-primary btn-block" style="margin-bottom: 16px;"value="">Checkout</a>
    </c:if>
    <c:forEach items="${bucket.orderDetails}" var="ordDet">
        <div class="col-sm-6 col-md-6">
            <div class="thumbnail">
                <img src="<spring:url value="/resources/img/pizza${ordDet.pizza.id % 4 + 1}.png" />" alt="pizza">
                <div class="caption">
                    <center>
                        <h4>${ordDet.pizza.name}</h4>
                        <p>Quantity: ${ordDet.quantity}</p>
                        <p>Price: ${ordDet.pizza.price * ordDet.quantity}$</p>
                    </center>
                    <p>
                    <form id="" action="<spring:url value="/app/order/add/" />" method="POST">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <input type="hidden" name="pizzaId" value="${ordDet.pizza.id}" />
                        <input type="number" class="form-control" style="margin-bottom: 16px;" name="quantity" value="1" />
                        <input class="btn btn-primary btn-block" style="margin-bottom: 16px;" type="submit" value="Add" />
                    </form>
                    <form id="" action="<spring:url value="/app/order/remove/" />" method="POST">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <input type="hidden" name="pizzaId" value="${ordDet.pizza.id}" />    
                        <input class="btn btn-primary btn-block" type="submit" value="Remove" />
                    </form>
                    </p>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<div class="well well-sm pre-scrollable col-sm-8" id="right" style="overflow-y: scroll; min-height: 80%;">
    <c:forEach items="${pizzas}" var="pizza">
        <div class="col-sm-4 col-md-4">
            <div class="thumbnail">
                <img src="<spring:url value="/resources/img/pizza${pizza.id % 4 + 1}.png" />" alt="pizza">
                <div class="caption">
                    <center>
                        <h3>${pizza.name}</h3>
                        <p>Type: ${pizza.type}</p>
                        <p>Price: ${pizza.price}$</p>
                    </center>
                    <p>
                    <form id="" action="<spring:url value="/app/order/add/" />" method="POST">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <input type="hidden" name="pizzaId" value="${pizza.id}" />
                        <input type="number" class="form-control" style="margin-bottom: 16px;" name="quantity" value="1" />
                        <input class="btn btn-primary btn-block" type="submit" value="Add" />
                    </form>
                    </p>
                </div>
            </div>
        </div>
    </c:forEach>
</div>