<%@ page import="com.mahan.biz.FieldsOfStudy" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mahan.biz.Degree" %>
<%@ page import="com.mahan.biz.Gender" %>
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
            <th>Student Number</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>National Number</th>
            <th>Birth Date</th>
            <th>Gender</th>
            <th>Field</th>
            <th>Degree</th>
            <th>Email</th>
            <th>Tel</th>
            <th>Address</th>
            <th></th>
            <th></th>

        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.studentNo}</td>
                <td>${student.firstname}</td>
                <td>${student.lastname}</td>
                <td>${student.nationalNo}</td>
                <td>${student.birthDate}</td>
                <td>${student.gender}</td>
                <td>${student.fieldsOfStudy}</td>
                <td>${student.degree}</td>
                <td>${student.email}</td>
                <td>${student.tel}</td>
                <td>${student.address}</td>
                <td>

                    <a href="/student/edit/${student.dId}"> <button>Edit</button></a>


                </td>
                <td>

                    <a href="/student/delete/${student.dId}"><button>Delete</button></a>

                </td>
            </tr>
        </c:forEach>

    </table>
        <% ArrayList<String> fields = new ArrayList<String>();
    fields.add(FieldsOfStudy.IndustrialEngineering.toString());
    fields.add(FieldsOfStudy.SoftwareEngineering.toString());
    application.setAttribute("fields", fields);

    ArrayList<String> degrees = new ArrayList<String>();
    degrees.add(Degree.Bachelor.toString());
    degrees.add(Degree.MasterOfSience.toString());
    application.setAttribute("degrees", degrees);

%>

    <a href="/studentadding.jsp">
        <button class="btn btn-success">New</button>
    </a>
</body>
</html>
