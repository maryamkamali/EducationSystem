<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mahan.biz.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 921227
  Date: 11/29/2015
  Time: 7:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
<div class="container">
  <jsp:include page="header.jsp"></jsp:include>
  <table class="table-my" style="width:100%" border="1">
    <tr>
      <th>Course ID</th>
      <th>Course Name</th>
      <th>Teacher</th>
      <th>Point</th>
      <th></th>

    </tr>
    <c:forEach var="course" items="${teachercourses}">
      <tr>
        <td>${course.courseNo}</td>
        <td>${course.title}</td>
        <td>${course.teacher.lastname}</td>
        <td>${course.point}</td>
        <td>
          <a href="/course/setGrade/${course.courseNo}"> <button>Grade</button></a>

        </td>
      </tr>
    </c:forEach>

  </table>



  <%--<form action="">--%>
    <%--<c:forEach var="student" items="${coursestudents}">--%>
        <%--${student.key.firstname}--%>
      <%--${student.value}--%>
    <%--</c:forEach>--%>
  <%--</form>--%>
${coursestudents[0].key}
  ${coursestudents[0].value}

<%--<c:choose>--%>
    <%--<c:when test="${coursestudents[0].value == '0'}">--%>
      <%--<form action="/course/savegrades">--%>
        <%--<c:forEach var="student" items="${coursestudents}">--%>
          <%--<label>${student.key.studentNo}</label>--%>
          <%--<input name="${student.key.firstname}" type="text">--%>
        <%--</c:forEach>--%>
      <%--</form>--%>
    <%--</c:when>--%>
    <%--<c:otherwise>--%>
      <%--<c:forEach var="student" items="${coursestudents}">--%>
         <%--${student.key.firstname}--%>
        <%--${student.value}--%>
      <%--</c:forEach>--%>
    <%--</c:otherwise>--%>
  <%--</c:choose>--%>
<%--Inja moondam nemifahme ghablan nomre dade ya na--%>
</div>
</body>
</html>
