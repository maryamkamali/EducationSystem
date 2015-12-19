<%--
  Created by IntelliJ IDEA.
  User: 921227
  Date: 11/22/2015
  Time: 7:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Course Adding Form</title>

    <jsp:include page="header.jsp"></jsp:include>
</head>
<body>
<div class="container-fluid">
    <div class="panel panel-primary dialog-panel">
        <div>
            <header></header>
        </div>
        <div class="panel-heading">
            <h5>Course Adding Form</h5>
        </div>
        <div class="row">
            <div class="col-sm-6 col-sm-offset-3">
                <div class="panel-body">
                    <form class="form-horizontal" style="margin-top: 20%" action="course/save/">
                        <input type="hidden" name="identifier" value="course">
                        <label> General Information:</label>
                        <br><br>
                        <div class="form-group">
                            <label class="col-sm-3 control-label" for="courseid">Course ID</label>
                            <input type="text" class="col-sm-3" id="courseid" name="courseID">
                            <label for="point" class="col-sm-3 control-label">Point</label>
                            <input type="text" id="point" class="col-sm-3" name="point">
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3">Teacher</label>
                            <select class="col-sm-3 form-control"  name="teacherName">

                                <c:forEach var="teacher" items="${teachers}">
                                    <option value="${teacher.lastname}">
                                            ${teacher.lastname}
                                    </option>
                                </c:forEach>
                            </select>
                            <label class="col-sm-3">Faculty</label>
                            <select class="col-sm-3 form-control" name="faculty" name="faculty">

                                <c:forEach var="faculty" items="${faculties}">
                                    <option value="${faculty}">
                                            ${faculty}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <button class="btn btn-success">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $('label').addClass('control-label');
    $('select').css('width','25%');
    $('label').css('text-align','left');
</script>
</body>
</html>
