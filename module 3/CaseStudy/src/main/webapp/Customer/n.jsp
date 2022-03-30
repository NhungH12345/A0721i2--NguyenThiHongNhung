<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 28/03/2022
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<title>Home Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%--    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"> &lt;%&ndash; icon--%>
</head>
<body>
<div class="main">
    <div class="header">
        <div class="header__wrapper">
            <div class="header__logo">
                <img src="/assets/img/logo/Codegym%20X.jpg" class="header__logo-img">
            </div>
            <ul class="header__user-function-list">
                <li class="header__user-function-item">
                    <a href="">Information</a>
                </li>
                <li class="header__user-function-item">
                    <a href="/home?action=logout">Log out</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="navbar">
    <div class="navbar__wrapper">
        <ul class="header__menu-list">
            <li class="header__menu-item">
                <a href="" class="header__menu-item-link">Home</a>
            </li>
            <li class="header__menu-item">
                <a href="/home?action=employee" class="header__menu-item-link">Employee</a>
            </li>
            <li class="header__menu-item">
                <a href="/home?action=customer" class="header__menu-item-link">Customer</a>
            </li>
            <li class="header__menu-item">
                <a href="/home?action=service" class="header__menu-item-link">Service</a>
            </li>
            <li class="header__menu-item">
                <a href="/home?action=contract" class="header__menu-item-link">Contract</a>
            </li>
        </ul>
        <form method="get" action="/customer" class="header__menu-search">
            <input type="hidden" name="action" value="search">
            <input type="text" name="search" placeholder="Enter customer's name u want to search">
            <button type="submit"><i class="ti-search">Search</i></button>
        </form>
        <c:if test="${listEmployees != null}">
            <form method="get" action="/employee" class="header__menu-search">
                <input type="hidden" name="action" value="search">
                <input type="text" name="search" placeholder="Enter employee's name u want to search">
                <button type="submit"><i class="ti-search"></i></button>
            </form>
        </c:if>
        <c:if test="${listServices != null}">
            <form method="get" action="/service" class="header__menu-search">
                <input type="hidden" name="action" value="search">
                <input type="text" name="search" placeholder="Enter service's name u want to search">
                <button type="submit"><i class="ti-search"></i></button>
            </form>
        </c:if>
    </div>
</div>
<!-- Body -->
<div class="body">
    <div class="navbar__left">
        <ul class="navbar__left-list">
            <li class="navbar__left-item">
                <a href="/home?action=most_used_as">Attachment services that are most commonly utilized</a>
            </li>
            <li class="navbar__left-item">
                <a href="/home?action=most_used_service">The most used services</a>
            </li>
            <li class="navbar__left-item">
                <a href="/home?action=customer_used_services">Customer are using the most services</a>
            </li>
            <li class="navbar__left-item">
                Item 1
            </li>
        </ul>
    </div>
    <div class="content__body">
        <div class="content__body-list">
            <!-- Customer -->
            <c:if test="${listCustomers != null}">
                <div class="header__top">
                    <h1>List Customers</h1>
                    <a href="/customer?action=create" class="create__btn">Create</a>
                </div>
                <c:if test="${createSuccess != null}">
                    <div class="create__success">
                        <span>${createSuccess}</span>
                    </div>
                </c:if>
                <c:if test="${editSuccess != null}">
                    <div class="create__success">
                        <span>${editSuccess}</span>
                    </div>
                </c:if>
                <table border="1" class="border">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Date</th>
                        <th>Gender</th>
                        <th>Identify Number</th>
                        <th>Phone number</th>
                        <th>Email Address</th>
                        <th>Address</th>
                        <th>Customer Type</th>
                        <th></th>
                        <th></th>
                    </tr>
                    <c:forEach items="${listCustomers}" var="customer">
                        <tr>
                            <td><c:out value="${customer.getId()}"></c:out></td>
                            <td><c:out value="${customer.getName()}"></c:out></td>
                            <td><c:out value="${customer.getDate_of_birth()}"></c:out></td>
                            <td><c:out value="${customer.getGender()}"></c:out></td>
                            <td><c:out value="${customer.getIdentify_number()}"></c:out></td>
                            <td><c:out value="${customer.getPhone_number()}"></c:out></td>
                            <td><c:out value="${customer.getEmail()}"></c:out></td>
                            <td><c:out value="${customer.getAddress()}"></c:out></td>
                            <td><c:out value="${customer.getCustomerTypeName()}"></c:out></td>
                            <td>
                                <a href="/customer?action=edit&id=${customer.getId()}">Edit</a>
                            </td>
                            <td>
                                <a data-delete="${customer.id}" class="js-delete">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <!-- Employee -->
            <c:if test="${listEmployees != null}">
                <div class="header__top">
                    <h1>List Employees</h1>
                    <a href="/employee?action=create" class="create__btn">Create</a>
                </div>
                <c:if test="${createSuccess != null}">
                    <div class="create__success">
                        <span>${createSuccess}</span>
                    </div>
                </c:if>
                <c:if test="${errorDelete != null}">
                    <div class="create__success">
                        <span>${errorDelete}</span>
                    </div>
                </c:if>
                <c:if test="${editSuccess != null}">
                    <div class="create__success">
                        <span>${editSuccess}</span>
                    </div>
                </c:if>
                <table border="1" class="border">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Date</th>
                        <th>Identify Number</th>
                        <th>Salary</th>
                        <th>Phone number</th>
                        <th>Email Address</th>
                        <th>Address</th>
                        <th>Position</th>
                        <th>Degree</th>
                        <th>Department</th>
                        <th></th>
                        <th></th>
                    </tr>
                    <c:forEach items="${listEmployees}" var="employee">
                        <tr>
                            <td><c:out value="${employee.getId()}"></c:out></td>
                            <td><c:out value="${employee.getName()}"></c:out></td>
                            <td><c:out value="${employee.getDate_of_birth()}"></c:out></td>
                            <td><c:out value="${employee.getIdentify_number()}"></c:out></td>
                            <td><c:out value="${employee.getSalary()}"></c:out></td>
                            <td><c:out value="${employee.getPhone_number()}"></c:out></td>
                            <td><c:out value="${employee.getEmail()}"></c:out></td>
                            <td><c:out value="${employee.getAddress()}"></c:out></td>
                            <td><c:out value="${employee.getPositionName()}"></c:out></td>
                            <td><c:out value="${employee.getDegreeName()}"></c:out></td>
                            <td><c:out value="${employee.getDepartmentName()}"></c:out></td>
                            <td>
                                <!-- Muốn action qua employee thì đổi chỗ này -->
                                <a href="/employee?action=edit&id=${employee.getId()}">Edit</a>
                            </td>
                            <td>
                                <a data-delete="${employee.getId()}" class="js-delete">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <!-- Service -->
            <c:if test="${listServices != null}">
                <div class="header__top">
                    <h1>List Services</h1>
                    <a href="/service?action=create" class="create__btn">Create</a>
                </div>
                <c:if test="${createSuccess != null}">
                    <div class="create__success">
                        <span>${createSuccess}</span>
                    </div>
                </c:if>
                <c:if test="${editSuccess != null}">
                    <div class="create__success">
                        <span>${editSuccess}</span>
                    </div>
                </c:if>
                <table border="1" class="border">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Area</th>
                        <th>Expense</th>
                        <th>Max people</th>
                        <th>Service Standard</th>
                        <th>Service Description</th>
                        <th>Pool Area</th>
                        <th>Floor</th>
                        <th>Rent Type</th>
                        <th>Service Type</th>
                        <th></th>
                        <th></th>
                    </tr>
                    <c:forEach items="${listServices}" var="service">
                        <tr>
                            <td><c:out value="${service.getId()}"></c:out></td>
                            <td><c:out value="${service.getName()}"></c:out></td>
                            <td><c:out value="${service.getArea()}"></c:out></td>
                            <td><c:out value="${service.getExpense()}"></c:out></td>
                            <td><c:out value="${service.getServiceMaxPeople()}"></c:out></td>
                            <td><c:out value="${service.getServiceStandard()}"></c:out></td>
                            <td><c:out value="${service.getServiceDescription()}"></c:out></td>
                            <td><c:out value="${service.getPool_area()}"></c:out></td>
                            <td><c:out value="${service.getFloor()}"></c:out></td>
                            <td><c:out value="${service.getRentTypeName()}"></c:out></td>
                            <td><c:out value="${service.getServiceTypeName()}"></c:out></td>
                            <td>
                                <!-- Muốn action qua employee thì đổi chỗ này -->
                                <a href="/service?action=edit&id=${service.getId()}">Edit</a>
                            </td>
                            <td>
                                <a data-delete="${service.getId()}" class="js-delete">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <!-- Contract -->
            <c:if test="${listContracts != null}">
                <div class="header__top">
                    <h1>List Contracts</h1>
                    <a href="/contract?action=create" class="create__btn">Create</a>
                </div>
                <c:if test="${createSuccess != null}">
                    <div class="create__success">
                        <span>${createSuccess}</span>
                    </div>
                </c:if>
                <c:if test="${editSuccess != null}">
                    <div class="create__success">
                        <span>${editSuccess}</span>
                    </div>
                </c:if>
                <table border="1" class="border">
                    <tr>
                        <th>ID</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Deposit</th>
                        <th>Employee Id</th>
                        <th>Customer Id</th>
                        <th>Service Id</th>
                        <th></th>
                        <th></th>
                    </tr>
                    <c:forEach items="${listContracts}" var="contract">
                        <tr>
                            <td><c:out value="${contract.getId()}"></c:out></td>
                            <td><c:out value="${contract.getStartDate()}"></c:out></td>
                            <td><c:out value="${contract.getEndDate()}"></c:out></td>
                            <td><c:out value="${contract.getDeposit()}"></c:out></td>
                            <td><c:out value="${contract.getEmployeeId()}"></c:out></td>
                            <td><c:out value="${contract.getCustomerId()}"></c:out></td>
                            <td><c:out value="${contract.getServiceName()}"></c:out></td>
                            <td>
                                <!-- Muốn action qua employee thì đổi chỗ này -->
                                <a href="/contract?action=edit&id=${service.getId()}">Edit</a>
                            </td>
                            <td>
                                <a data-delete="${contract.getId()}" class="js-delete">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <!-- The most used attachment services -->
            <c:if test="${serviceAttachmentList != null}">
                <div class="header__top">
                    <h1>The list of attachment services most used commonly</h1>
                </div>
                <table border="1" class="border">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                    </tr>
                    <c:forEach items="${serviceAttachmentList}" var="serviceAttachment">
                        <tr>
                            <td><c:out value="${serviceAttachment.getId()}"></c:out></td>
                            <td><c:out value="${serviceAttachment.getName()}"></c:out></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <!-- The most used services -->
            <c:if test="${mostServicesUsed != null}">
                <div class="header__top">
                    <h1>The most used services</h1>
                </div>
                <table border="1" class="border">
                    <tr>
                        <th>ID</th>
                        <th>Service Name</th>
                    </tr>
                    <c:forEach items="${mostServicesUsed}" var="mostServicesUsed">
                        <tr>
                            <td><c:out value="${mostServicesUsed.getId()}"></c:out></td>
                            <td><c:out value="${mostServicesUsed.getName()}"></c:out></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <!-- The customers most used services -->
            <c:if test="${listCustomersUsingServicesTheMost != null}">
                <div class="header__top">
                    <h1>The customers most used services</h1>
                </div>
                <table border="1" class="border">
                    <tr>
                        <th>ID</th>
                        <th>Customer's Name</th>
                    </tr>
                    <c:forEach items="${listCustomersUsingServicesTheMost}" var="listCustomersUsingServicesTheMost">
                        <tr>
                            <td><c:out value="${listCustomersUsingServicesTheMost.getId()}"></c:out></td>
                            <td><c:out value="${listCustomersUsingServicesTheMost.getName()}"></c:out></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </div>
</div>
</div>
<!-- Modal -->
<%--<div class="modal js-modal">--%>
<%--    <div class="modal__overlay"></div>--%>
<%--    <!-- Modal delete -->--%>
<%--    <div class="form__delete">--%>
<%--        <h3 class="form__delete-title">Confirmation</h3>--%>
<%--        <p class="form__delete-text">Are you sure you want to delete this customer ?</p>--%>
<%--        <c:if test="${listCustomers != null}">--%>
<%--            <form action="/customer?action=delete" method="post" class="form__delete-footer">--%>
<%--                <button class="form__delete-btn cancel js-cancel">Cancel</button>--%>
<%--                <input type="hidden" name="id" id="delete_detail">--%>
<%--                <button type="submit" class="form__delete-btn confirm">Yes</button>--%>
<%--            </form>--%>
<%--        </c:if>--%>
<%--        <c:if test="${listEmployees != null}">--%>
<%--            <form action="/employee?action=delete" method="post" class="form__delete-footer">--%>
<%--                <button class="form__delete-btn cancel js-cancel">Cancel</button>--%>
<%--                <input type="hidden" name="id" id="delete_detail">--%>
<%--                <button type="submit" class="form__delete-btn confirm">Yes</button>--%>
<%--            </form>--%>
<%--        </c:if>--%>
<%--        <c:if test="${listServices != null}">--%>
<%--            <form action="/service?action=delete" method="post" class="form__delete-footer">--%>
<%--                <button class="form__delete-btn cancel js-cancel">Cancel</button>--%>
<%--                <input type="hidden" name="id" id="delete_detail">--%>
<%--                <button type="submit" class="form__delete-btn confirm">Yes</button>--%>
<%--            </form>--%>
<%--        </c:if>--%>
<%--        <c:if test="${listContracts != null}">--%>
<%--            <form action="/contract?action=delete" method="post" class="form__delete-footer">--%>
<%--                <button class="form__delete-btn cancel js-cancel">Cancel</button>--%>
<%--                <input type="hidden" name="id" id="delete_detail">--%>
<%--                <button type="submit" class="form__delete-btn confirm">Yes</button>--%>
<%--            </form>--%>
<%--        </c:if>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<script src="/js/modal_click.js"></script>--%>
</body>
</html>
</body>
</html>
