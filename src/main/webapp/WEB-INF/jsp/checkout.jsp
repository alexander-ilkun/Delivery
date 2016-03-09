<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<table class="table table-striped">
    <th>№</th>
    <th>Name</th>
    <th>Quantity</th>
    <th>Price per unit</th>
    <th>Price</th>
        <c:forEach items="${bucket.orderDetails}" var="ordDet" varStatus="loop">
        <tr>
            <td>${loop.index + 1}</td>
            <td>${ordDet.pizza.name}</td>
            <td>${ordDet.quantity}</td>
            <td>${ordDet.pizzaPrice}</td>
            <td>${ordDet.pizzaPrice * ordDet.quantity}</td>
        </tr>
    </c:forEach>
</table>
<p>Price: ${bucket.price}</p>
<p>Discount: ${bucket.discount}</p>
<p>Total price: ${bucket.totalPrice}</p>
<form action="<spring:url value="/app/order/checkout/" />" method="POST">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <select class="form-control" name="addressId">
        <c:forEach items="${user.addresses}" var="address">
            <option value="${address.id}">${address.postcode} ${address.city} ${address.district} ${address.street} ${address.apartments} </option>
        </c:forEach>
    </select>
    <input class="btn btn-primary btn-block" style="margin-bottom: 16px;" type="submit" value="Confirm" />
</form>