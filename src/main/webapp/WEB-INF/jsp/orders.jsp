<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

    <table class="table table-striped">
        <th>№</th>
        <th>Addresses</th>
            <c:forEach items="${orders}" var="order" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${order}</td>
            </tr>
        </c:forEach>
    </table>