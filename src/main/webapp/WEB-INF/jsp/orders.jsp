<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

    <table class="table table-striped">
        <th>№</th>
        <th>User</th>
        <th>Addresses</th>
        <th>Price</th>
        <th>Discount</th>
        <th>Total price</th>
        <c:forEach items="${orders}" var="order" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${order.user.name}</td>
                <td>${order.address.postcode} ${order.address.city} ${order.address.district} ${order.address.street} ${order.address.apartments} </td>
                <td>${order.price}</td>
                <td>${order.discount}</td>
                <td>${order.price - order.discount}</td>
            </tr>
        </c:forEach>
    </table>