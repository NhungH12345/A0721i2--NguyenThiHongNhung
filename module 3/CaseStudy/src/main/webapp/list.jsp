<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 20/01/2022
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Customer Manager</h1>
<a href="/customer/add.jsp">Create Customer</a>
<div align="center">
    <table border="1" cellpadding="6">
        <caption><h2>List of Customer</h2></caption>
    <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Phone</th>
    <th>Email</th>
    <th>Address</th>
    <th>Action</th>
    </tr>
    <tbody>
    <c:forEach items="${customers}" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.phone}</td>
            <td>${c.email}</td>
            <td>${c.address}</td>
            <td>
                <a href="/customer?action=edit&id=${c.id}">Edit</a>
                <a href="/customer?action=delete&id=${c.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>
</div>

</body>
</html>
