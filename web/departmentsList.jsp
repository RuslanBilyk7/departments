<%--
  Created by IntelliJ IDEA.
  User: RUSLAN77
  Date: 29.01.2018
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@taglib prefix="guru" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Departments</title>
</head>

<body>
LIST OF DEPARTMENTS:   <br>  <br>

<c:forEach var="item" items="${listOfDepartments}">
    <table>
        <tr>
            <td>
                    <%--<a href="#?${item.id}">${item.name}</a>--%>
                <a href="/usersServlet?departmentId=${item.id}">${item.name}</a>
            </td>
            <td>
                    <%--<a href="#?${item.id}">Edit</a>--%>
                <a href="/addEditDepartment?departmentId=${item.id}">Edit</a>
            </td>
            <td>
                <a href="/removeDepartments?departmentId=${item.id}">Remove</a>
            </td>
        </tr>
    </table>
</c:forEach>

<a href="/addEditDepartment">Add Department</a>

</body>
</html>
