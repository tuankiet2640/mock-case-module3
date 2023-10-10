<%@ page import="com.example.mockcasemodule3.dao.impl.PropertyDAO" %>
<%@ page import="com.example.mockcasemodule3.model.properties.Property" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/6/2023
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    PropertyDAO propertyDAO= new PropertyDAO();
    List<Property> properties = propertyDAO.getAllProperty();
    request.setAttribute("properties", properties);
%>

<div class="property-list">

    <h2>Properties</h2>

    <c:forEach items="${properties}" var="property">
        <div class="property-item">
            <h3><c:out value="${property.propertyName}"/></h3
            <p>address: <c:out value="${property.address}"/></p>
            <p>area: <c:out value="${property.area}"/></p>
            <p>Price: <c:out value="${property.propertyPrice}"/></p>
        </div>

    </c:forEach>

</div>

</body>
</html>
