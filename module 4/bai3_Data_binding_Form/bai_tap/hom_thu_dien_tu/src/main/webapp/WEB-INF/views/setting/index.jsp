<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 23/02/2022
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<head>
    <title>$Title$</title>
</head>
<body>
<table>
    <tr>
        <td>Languages:</td>
        <td>${languages}</td>
    </tr>
    <tr>
        <td>Page Size:</td>
        <td>${pagesize}</td>
    </tr>
    <tr>
        <td>Spams filter:</td>
        <td>${spamsfilter}</td>
    </tr>
    <tr>
        <td>Signature:</td>
        <td>${sigbature}</td>
    </tr>
    <tr>
        <td>Update</td>
        <td>${update}</td>
    </tr>
    <tr>
        <td>Cancel</td>
        <td>${cancel}</td>
    </tr>
</table>
</body>
</html>
