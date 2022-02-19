<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 18/02/2022
  Time: 9:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Your Choice</h1>
<c:forEach items="${condiment}" var="choice">
    ${choice}
</c:forEach>

</body>
</html>
