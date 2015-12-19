<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 921227
  Date: 11/25/2015
  Time: 8:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<c:choose>
    <c:when test="${param.identifier=='student'}">
        <jsp:useBean id="currentstudent" class="com.mahan.biz.Student" scope="request">
            <jsp:setProperty name="currentstudent" property="*"/>
        </jsp:useBean>
    </c:when>
    <c:when test="${param.identifier=='teacher'}">
        <jsp:useBean id="teacher" class="com.mahan.biz.Teacher" scope="request">
            <jsp:setProperty name="teacher" property="*"></jsp:setProperty>
        </jsp:useBean>
    </c:when>
    <c:when test="${param.identifier=='course'}">
        <jsp:useBean id="course" class="com.mahan.biz.Course" scope="request">
            <jsp:setProperty name="course" property="*"></jsp:setProperty>
        </jsp:useBean>
    </c:when>
</c:choose>
<%
    RequestDispatcher rd= request.getRequestDispatcher("/ObjectAdder");
    rd.forward(request,response);
  //  response.sendRedirect("/ObjectAdder");
    %>
</body>
</html>
