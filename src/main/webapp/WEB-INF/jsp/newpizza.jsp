<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="/Delivery/app/addnew" method="POST">
            <input type="hidden" name="id" value="${pizza.id}" />
            Name : <input type="text" name="name" value="${pizza.name}" />
            Type : <input type="text" name="name" value="${pizza.type}" />
            Price : <input type="text" name="name" value="${pizza.price}" />
            <input type="submit" value="Add" />
        </form>
    </body>
</html>
