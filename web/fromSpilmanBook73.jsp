<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: RUSLAN77
  Date: 05.02.2018
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Example</title>
</head>
<body>

<c:set var="totalSize" scope="session" value="40"/>
<c:set var="chunkSize" scope="session" value="10"/>
<c:set var="start" scope="page" value="1"/>
<c:set var="finish" value="${start+chunkSize-1}"/>


<jsp:useBean id="selection" class="java.util.Vector"/>
<%
    selection.add("apple1");
    selection.add("apple2");
    selection.add("apple3");
    selection.add("apple4");
    selection.add("apple5");
    selection.add("apple6");
    selection.add("apple7");
    selection.add("apple8");
    selection.add("apple9");
    selection.add("apple10");
    selection.add("apple11");
    selection.add("apple12");
    selection.add("apple13");
    selection.add("apple14");
    selection.add("apple15");
    selection.add("apple16");
    selection.add("apple17");
%>

<%--<jsp:useBean id="start" class="java.util.Vector"/>--%>
<%--<%--%>
    <%--start.add(1);--%>
    <%--start.add(2);--%>
    <%--start.add(3);--%>
    <%--start.add(4);--%>
    <%--start.add(5);--%>
    <%--start.add(6);--%>
    <%--start.add(7);--%>
    <%--start.add(8);--%>
    <%--start.add(9);--%>
    <%--start.add(10);--%>
    <%--start.add(11);--%>
    <%--start.add(12);--%>
    <%--start.add(13);--%>
    <%--start.add(14);--%>
    <%--start.add(15);--%>
    <%--start.add(16);--%>
    <%--start.add(17);--%>

<%--%>--%>


<c:forEach var="item" varStatus="current"
           begin="${start}" end="${finish}">

    Item: <c:out value="$ {item}"/>
    Current count: <c:out value="$ {current.count}"/>
    Current index: <c:out value="$ {current.index}"/>
    <br>

    <c:if test="${current.index==finish}">
        <c:out value="__________________________________"/>
    </c:if>

</c:forEach>

<c:if test="${param.start>0}">
    <c:set var="start" scope="page" value="${param.start}"/>
</c:if>


<c:forEach var="selection" begin="1" end="totalSize-1" step="chunkSize">
    <a href="?start= <c:out value="${selection}"/>">
    <a href=" <c:out value="${selection}"/>">
       <a>
    <b>
            <c:out value="${selection}"/>
            <c:out value="${selection+chunkSize-1}"/>
        </b>

    </a>

</c:forEach>




</body>
</html>



