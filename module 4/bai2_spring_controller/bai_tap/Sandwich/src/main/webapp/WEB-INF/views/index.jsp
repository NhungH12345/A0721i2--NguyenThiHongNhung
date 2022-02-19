<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 17/02/2022
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Sanwich Condiments</h1>
  <form method="post" action="/save">
    <table>
      <tr>
        <td hidden name="condiment" value="null"></td>
        <td><input type="checkbox" name="condiment" value="Lettuce">Lettuce</td>
        <td><input type="checkbox" name="condiment" value="Tomato">Tomato</td>
        <td><input type="checkbox" name="condiment" value="Mustard">Mustard</td>
        <td><input type="checkbox" name="condiment" value="Sprouts">Sprouts</td>
      </tr>
    </table>
    <hr/>
      <input type="submit" value="save"></td>
    </table>
  </form>
  </body>
</html>
