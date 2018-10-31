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
    <title>Users</title>
</head>
<body>
<form action="/addEditUser?userId=${user.userId}&departmentId=${departmentId}" method="post">
    <input type="text" maxlength="10" name="userName" required pattern="^[a-zA-Z]+$" value=${user.userName}> userName (only letters!)</input >
    <input type="number" size="3" name="age" required pattern="^[ 0-9]+$"  min="18" max="120" value="18"  value=${user.age}> userAge </input >


    <input type="submit" value="Save"/>


</form>

<a href="/usersServlet?departmentId=${departmentId}">Cancel</a>



</body>
</html>
