<%@ page import="com.codegym.crud_product_servlet.service.ProductService" %>
<%@ page import="com.codegym.crud_product_servlet.model.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 22/12/2022
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Đây là Home</h1>
<h1>List Product</h1>
<div class="container mt-3">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>price</th>
            <th>Edit</th>
            <th>Delete</th>

        </tr>
        </thead>
        <tbody>
        <%! String str = "";%>
        <%
            for (Product p : ProductService.products) {
                str += "<tr>\n" +
                        "<td>" + p.getId() + "</td>\n" +
                        "<td>" + p.getName() + "</td>\n" +
                        "<td>" + p.getPrice() + "</td>\n" +
                        "<td><button type='button' class='btn btn-warning'>Edit</button></td>" +
                        "<td><button type='button' class='btn btn-danger'>Delete</button></td>" +
                        "</tr>";
            }
        %>
        <%=str%>


        <%
            request.setAttribute("products", ProductService.products);
        %>

        <c:forEach var="p" items="${products}">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.price}</td>
                <td>
                    <button type="button" class="btn btn-warning">Edit</button>
                </td>
                <td>
                    <button type="button" class="btn btn-danger">Delete</button>
                </td>
            </tr>
        </c:forEach>



        </tbody>
    </table>
</div>
</body>
</html>
