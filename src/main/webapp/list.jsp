<%--
  Created by IntelliJ IDEA.
  User: zxgak
  Date: 5/26/2023
  Time: 8:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books Store Application</title>
</head>
<body>
<center>
    <h1>Books Management</h1>
    <h2>
        <a href="/add.jsp">Add New staff</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/show-list">List All staff</a>
        &nbsp;&nbsp;&nbsp;
<%--        <a href="/sort-by-price">Sort By Price</a>--%>
    </h2>
</center>
<div align="center">
    <form action="/search" method="GET">
        <input type="text" name="name" placeholder="Search by Title"/>
        <input type="submit" value="Search"/>
    </form>
    <table border="1" cellpadding="5">
        <caption><h2>List of Books</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>PhoneNumber</th>
            <th>Salary</th>
            <th>Department</th>
        </tr>
        <c:forEach var="staff" items="${liststaff}">
            <tr>
                <td><c:out value="${staff.id}"/></td>
                <td><c:out value="${staff.name}"/></td>
                <td><c:out value="${staff.email}"/></td>
                <td><c:out value="${staff.address}"/></td>
                <td><c:out value="${staff.phoneNumber}"/></td>
                <td><c:out value="${staff.salary}"/></td>
                <td><c:out value="${staff.department.nameDepartment}"/></td>
                <td>
                    <a href="/update?id=${staff.id}">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/delete?id=${staff.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>