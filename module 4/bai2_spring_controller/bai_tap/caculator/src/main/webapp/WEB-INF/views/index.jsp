<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 18/02/2022
  Time: 6:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Simple Calculator</title>
  </head>
  <body>
  <h1>Calculator</h1>
  <form action="calculate" method="post">
    <input type="text" name="number1" value="${number1}">
    <input type="text" name="number2" value="${number2}">
    <p>
      <input type="submit" name="calcu" value="Addition(+)">
      <input type="submit" name="calcu" value="Subtraction(-)">
      <input type="submit" name="calcu" value="Multiplication(X)">
      <input type="submit" name="calcu" value="Division(/)">
    </p>
  </form>
  <h2>Result Division </h2>
  <c:forEach items="${caculator}" var="result">
    ${result}
  </c:forEach>
  </body>
</html>