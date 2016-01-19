<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maryam.kamali
  Date: 12/15/2015
  Time: 10:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <jsp:include page="header.jsp"></jsp:include>
</head>
<body>
<div class="container top-admin">
  <%--<div class="row">--%>
    <%--<div class="col-md-offset-4 col-md-4">--%>
      <%--<a href="/teacher/showCourses/">--%>
        <%--<button class="btn-my">--%>
          <%--Set Grades--%>
        <%--</button>--%>
      <%--</a>--%>
    <%--</div>--%>
  <%--</div>--%>
  </div>
</body>
<c:set var="role_course" scope="session" value="student"></c:set>
</html>
