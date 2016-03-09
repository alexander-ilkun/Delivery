<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="col-sm-6 col-md-6">
    <p>Name: ${user.name}</p>
    <p>Bonus card amount: ${user.bonusCard.amount}</p>
</div>
<div class="col-sm-6 col-md-6">
    <table class="table table-striped">
        <th>№</th>
        <th>Addresses</th>
            <c:forEach items="${user.addresses}" var="address" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${address.postcode} ${address.city} ${address.district} ${address.street} ${address.apartments} </td>
            </tr>
        </c:forEach>
    </table>
    <form action="<spring:url value="/app/address/add" />" method="POST">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <label for="postcodefield" class="sr-only">Postcode</label>
        <input type="text" id="postcodefield" name="postcode" class="form-control" placeholder="Postcode" required autofocus>
        <label for="cityfield" class="sr-only">City</label>
        <input type="text" id="posctcodefield" name="city" class="form-control" placeholder="City" required>
        <label for="districtfield" class="sr-only">Disctrict</label>
        <input type="text" id="districtfield" name="district" class="form-control" placeholder="District" required>
        <label for="streetfield" class="sr-only">Street</label>
        <input type="text" id="streetfield" name="street" class="form-control" placeholder="Street" required>
        <label for="apartmentsfield" class="sr-only">Apartments</label>
        <input type="text" id="apratmentsfield" name="apartments" class="form-control" placeholder="Apartments" required>
        <input class="btn btn-primary btn-block" type="submit" value="Add new address" />
    </form>
</div>