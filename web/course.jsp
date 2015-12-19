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
    <th>Faculty</th>
    <th>Teacher</th>
    <th>Point</th>
    <th></th>
    <th></th>

  </tr>
  <c:forEach var="course" items="${courses}">
    <tr>
      <td>${course.courseID}</td>
      <td>${course.faculty}</td>
<td>${course.teacher.lastname}</td>
      <td>${course.point}</td>
      <td>
        <a href="/course/edit/${course.courseID}"> <button>Edit</button></a>

      </td>
      <td>

        <a href="/course/delete/${course.courseID}"><button>Delete</button></a>

      </td>
    </tr>
  </c:forEach>

</table>
<%
  ArrayList<String> faculties = new ArrayList<String>();
  faculties.add(Faculty.Industrial.toString());
  faculties.add(Faculty.Chemical.toString());
  faculties.add(Faculty.Engineering.toString());
  application.setAttribute("faculties",faculties);
  BLO blo = new BLO();
  ArrayList<Teacher> teachers = blo.loadTeachers();
  application.setAttribute("teachers",teachers);
%>

<a href="/courseadding.jsp">
  <button class="btn btn-success">New</button>
</a>
</div>
</body>
</html>
