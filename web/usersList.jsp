<%--
  Created by IntelliJ IDEA.
  User: RUSLAN77
  Date: 23.02.2018
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
LIST OF USERS OF THE DEPARTMENT :
<c:out value="${departmentName}"/>

<br> <br>

<c:forEach var="item" items="${listOfUsers}">
    <table>
        <tr>
            <td>
                    ${item.userName}

                    <%--<a href="/usersList.jsp">${item.name}</a>--%>
                    <%--<a> ${item.name} </a>--%>
            </td>

            <td> ${item.age}</td>

            <td>
                    <%--<a href="#?${item.id}">Edit</a>--%>
                <a href="/addEditUser?userId=${item.userId}&departmentId=${departmentId}">Edit</a>
            </td>
            <td>
                <a href="/removeUsers?userId=${item.userId}&departmentId=${departmentId}">Remove</a>
            </td>
        </tr>
    </table>
</c:forEach>

<a href="/addEditUser?departmentId=${departmentId}">Add User</a>
<br>
<a href="/departmentsServlet?departmentId=${departmentId}"> List of departments</a>
</form>
</body>
</html>
