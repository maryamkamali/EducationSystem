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
    <h3>Transcript</h3>
    <table class="table-my" style="width:100%" border="1">
        <tr>
            <th>Course Number</th>
            <th>title</th>
            <th>Teacher</th>
            <th>Point</th>
            <th>Grade</th>
        </tr>
        <c:forEach var="selectedCourse" items="${selectedCourses}">
            <tr>
                <td>${selectedCourse.courseNo}</td>
                <td>${selectedCourse.title}</td>
                <td>${selectedCourse.teacherName}</td>
                <td>${selectedCourse.point}</td>
                <td>${selectedCourse.grade}</td>

            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
