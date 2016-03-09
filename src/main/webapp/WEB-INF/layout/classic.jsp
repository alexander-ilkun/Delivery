<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="<spring:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
        <link href="<spring:url value="/resources/css/custom.css" />" rel="stylesheet">
        <title><tiles:getAsString name="title" /></title>
    </head>
    <body>
        <div class="container-fluid fill">
            <tiles:insertAttribute name="navbar" />
            <tiles:insertAttribute name="body" />
            <tiles:insertAttribute name="footer" />
        </div>
        <script src="<spring:url value="/resources/js/jquery.min.js" />"></script>
        <script src="<spring:url value="/resources/js/bootstrap.min.js" />"></script>
    </body>
</html>
