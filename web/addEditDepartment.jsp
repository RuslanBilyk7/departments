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
<script type="text/javascript" src="departments.js"></script>

<html>
<head>
    <title>Departments</title>
</head>



<body>
<form action="/addEditDepartment?departmentId=${department.id}" onsubmit="return validateForm()" method="post" name="myForm">
    <%--<input type="text" maxlength="10" name="departmentName" required pattern="^[a-zA-Z]+$" value=${department.name}> Name (only letters!) </input >--%>
    <input type="text" maxlength="10" name="departmentName"  value=${department.name}>
    Name(only letters!)</input >
    <input type="submit" value="Save"/>

</form>

<%--<script>--%>
    <%--function validateForm() {--%>
<%--//    required pattern="^[a-zA-Z]+$"--%>
    <%--var x = document.departmentName.value;--%>
    <%--if (x.trim() == "") {--%>
        <%--alert("Name must be filled out");--%>
        <%--return false;--%>
    <%--}--%>
    <%--if (!x.trim().match('^[a-zA-Z]+$)')) {--%>
        <%--alert("wrong symbol");--%>
        <%--return false;--%>
    <%--}--%>
<%--}--%>
<%--</script>--%>

<a href="/departmentsServlet?departmentId=${departmentId}">Cancel</a>

</body>
</html>
