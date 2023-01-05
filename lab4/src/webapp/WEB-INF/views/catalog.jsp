<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, by.application.javaWeb.servlet.CatalogServlet, by.application.javaWeb.model.dto.AutoDto" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- jstl -->
<%
    String header = "Catalog Auto";
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>AutoCatalog</title>
</head>
<form action="CatalogServlet"/>
<%
    List<AutoDto> autoList = (List<AutoDto>) request.getAttribute("autoList");
%>
<body>
<h2><%= header %></h2>
<div class="container">
    CATALOG
    <table>
        <tr>
            <th>Name</th>
            <th>TransmissionType</th>
            <th>CarBodyType</th>
            <th>EngineType</th>
            <th>BrandType</th>
            <th>Country</th>
        </tr>
        <c:forEach var="auto" items="${autoList}">
            <tr>
                <td><c:out value="${auto.name}" /></td>
                <td><c:out value="${auto.transmissionType}" /></td>
                <td><c:out value="${auto.carBodyType}" /></td>
                <td><c:out value="${auto.engineType}" /></td>
                <td><c:out value="${auto.brandType}" /></td>
                <td><c:out value="${auto.country}" /></td>
            </tr>
        </c:forEach>
    </table><br>

    <form action="/Catalog" method="post">
        Name auto: <input name="name" /><br>
        TransmissionType: <input name="transmission" /><br>
        CarBodyType: <input name="car" /><br>
        EngineType: <input name="engine" /><br>
        BrandType: <input name="brand" /><br>
        Country: <input name="country" /><br>
        <input type="submit" value="Add Auto" />
    </form><br>

    <div id="content">
    </div>
</div>
</body>
</html>