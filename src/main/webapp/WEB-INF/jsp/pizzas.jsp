<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Pizzas! ${name}</h1>
<table border="1">

    <th>Id</th>
    <th>Name</th>
    <th>Type</th>
    <th>Price</th>

    <c:forEach items="${pizzas}" var="pizza">
        <tr>
            <td>${pizza.id}</td>
            <td>${pizza.name}</td>
            <td>${pizza.type}</td>
            <td>${pizza.price}</td>
        </tr>
    </c:forEach>
</table>

