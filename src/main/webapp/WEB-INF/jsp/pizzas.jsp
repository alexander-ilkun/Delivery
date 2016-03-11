<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<table class="table" >
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
<form action="<spring:url value="/app/pizza/add/" />" method="POST">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <label for="namefield" class="sr-only">Name</label>
    <input type="text" id="namefield" name="name" class="form-control" placeholder="Name" required autofocus>
    <label for="pricefield" class="sr-only">Price</label>
    <input type="number" id="pricefield" name="price" class="form-control" placeholder="Price" required>
    <select class="form-control" name="type">
        <option value="MEAT">MEAT</option>
        <option value="VEGETARIAN">VEGETARIAN</option>
        <option value="SEA">SEA</option>
    </select>
    <button class="btn btn-primary btn-block" type="submit">Add pizza</button>
</form>