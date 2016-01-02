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
    <form action="/course/showStudentCourse" method="post">
    <table class="table-my" style="width:100%" border="1">
        <tr>
            <th>Course Number</th>
            <th>title</th>
            <th>Teacher</th>
            <th></th>
        </tr>
        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.courseNo}</td>
                <td>${course.title}</td>
                <td>${course.teacherName}</td>
                <td>
                    <input type="checkbox" name="myTextEditBox" value="${course.dId}"
                           style="margin-left:auto; margin-right:auto;">
                </td>
            </tr>
        </c:forEach>
    </table>
    <button type="submit">Submit</button>
    </form>

</div>
<br>

<div class="container">
    <h3>Selected Courses</h3>
    <table class="table-my" style="width:100%" border="1">
        <tr>
            <th>Course Number</th>
            <th>title</th>
            <th>Teacher</th>
            <th>Point</th>
        </tr>
        <c:forEach var="selectedCourse" items="${selectedCourses}">
            <tr>
                <td>${selectedCourse.courseNo}</td>
                <td>${selectedCourse.title}</td>
                <td>${selectedCourse.teacherName}</td>
                <td>${selectedCourse.point}</td>

            </tr>
        </c:forEach>

    </table>
</div>
</body>
<script>
</script>
</html>
