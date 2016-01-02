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
                    <a href="/course/showStudents/${course.dId}">
                        <button>Grade</button>
                    </a>

                </td>
            </tr>
        </c:forEach>

    </table>
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
            <tr id="${student.dId}">
                <td>${student.studentNo}</td>
                <td>${student.firstname} ${student.lastname}</td>
                <td>${student.fieldsOfStudy}</td>
                <td>${student.degree}</td>
                <td><input name="grade"  type="text"></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script>

    $('input[name=grade]').change(function(){
       var Id= $(this).parent().parent().attr("id");
        var grade = $(this).val();

        $.post("/course/setGrade",{id : 47 , grade: grade},function(data){
            alert("ok");
        })
    });
</script>
</body>
</html>
