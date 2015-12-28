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
  <jsp:include page="header.jsp"></jsp:include>
</head>
<body>
<div class="container">
  <table style="width:100%" border="1" class="table-my">
    <tr>
      <th>Teacher Number</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>National Number</th>
      <th>Birth Date</th>
      <th>Gender</th>
      <th>Position</th>
      <th>Email</th>
      <th>Tel</th>
      <th>Address</th>
      <th></th>
      <th></th>

    </tr>
    <c:forEach var="teacher" items="${teachers}">
      <tr>
        <td>${teacher.teacherNo}</td>
        <td>${teacher.firstname}</td>
        <td>${teacher.lastname}</td>
        <td>${teacher.nationalNo}</td>
        <td>${teacher.birthDate}</td>
        <td>${teacher.gender}</td>
        <td>${teacher.position}</td>
        <td>${teacher.email}</td>
        <td>${teacher.tel}</td>
        <td>${teacher.address}</td>
        <td>

          <a href="/teacher/edit/${teacher.dId}"> <button>Edit</button></a>


        </td>
        <td>

          <a href="/teacher/delete/${teacher.dId}"><button>Delete</button></a>

        </td>
      </tr>
    </c:forEach>

  </table>
  <%
    ArrayList<String> positions = new ArrayList<String>();
    positions.add(Position.assistant.toString());
    positions.add(Position.professor.toString());
    application.setAttribute("positions",positions);

  %>

  <a href="/teacheradding.jsp">
    <button class="btn btn-success">New</button>
  </a>
</div>
</body>
</html>
