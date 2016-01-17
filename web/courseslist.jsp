<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mahan.biz.*" %>
<%@ page import="com.mahan.UI.Model.Teacher" %>
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
    <table class="table-my" border="1">
        <tr>
            <th>Course Number</th>
            <th>Title</th>
            <th>Teacher</th>
            <th>Point</th>
            <th></th>
            <th></th>
            <th></th>

        </tr>
        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.courseNo}</td>
                <td>${course.title}</td>
                <td>${course.teacher.lastname}</td>
                <td>${course.point}</td>
                <td>
                    <a href="/admin/course/edit/${course.dId}">
                        <button>Edit</button>
                    </a>

                </td>
                <td>
                    <a href="/admin/course/delete/${course.dId}">
                        <button>Delete</button>
                    </a>

                </td>
                <td>
                    <a href="/admin/course/showStudentsbyCourse/${course.dId}"><button>Students</button></a>
                </td>
            </tr>
        </c:forEach>

    </table>
    <%
        TeacherBLO blo = new TeacherBLO();
        ArrayList<Teacher> teachers = blo.loadTeachers();
        application.setAttribute("teachers", teachers);
    %>

    <a href="/coursenew.jsp">
        <button class="btn btn-success">New</button>
    </a>
</div>
<div class="container">
    <h2>Students for selected course:</h2>

    <table class="table-my">
        <thead>
        <tr>
            <th>Student NO</th>
            <th>Name</th>
            <th>Feild</th>
            <th>Degree</th>
            <th>Grade</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${studentsCourse}">
            <tr id="${student.key}">
                <td>${student.value.studentNo}</td>
                <td>${student.value.firstname} ${student.value.lastname}</td>
                <td>${student.value.fieldsOfStudy}</td>
                <td>${student.value.degree}</td>
                <td>
                    <c:if test="${student.value.courses[0].grade ne 0}">
                        ${student.value.courses[0].grade}
                    </c:if>
                    <c:if test="${student.value.courses[0].grade eq 0}">
                        <input name="grade"  type="text">
                    </c:if> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
