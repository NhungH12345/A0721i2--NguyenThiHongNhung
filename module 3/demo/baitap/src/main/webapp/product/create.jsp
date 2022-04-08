<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 24/01/2022
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Add new product</h2>
<form action="/product" method="post">
    <input type="hidden" name="action" value="create"/>
    <label>Name</label><br>
    <input type="text" name="name"/><br>
    <label>Price</label><br>
    <input type="text" name="price"/><br>
    <label>Quantity</label><br>
    <input type="text" name="quantity"/><br>
    <label>Color</label><br><br>
    <input type="text" name="color"/><br>
    <label>Category</label><br>
    <select name="category">
        <c:forEach var="category" items="${listCategory}">
            <option value="${category.id_category}"> ${category.name_category}</option>
        </c:forEach>
    </select>
    <br>
    <br>
    <br>
    <button>Create</button>
    <button>Back</button>
    </div>
</form>
</body>
</html>


