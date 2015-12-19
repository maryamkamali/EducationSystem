<%--
  Created by IntelliJ IDEA.
  User: 921227
  Date: 11/11/2015
  Time: 8:19 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student Adding Form</title>
    <jsp:include page="header.jsp"></jsp:include>
</head>
<body>
<div class="container-fluid">
    <div class="panel panel-primary dialog-panel">
        <div class="panel-heading">
            <h5>Student Adding Form</h5>
        </div>
        <div class="row">
            <div class="col-sm-6 col-sm-offset-3">
                <div class="panel-body">
                    <form action="/student/save" class="form-horizontal" style="margin-top: 20%">
                        <input type="hidden" name="identifier" value="student">
                        <label> Personal Information:</label>
                        <br><br>
                        <div class="form-group">
                            <label for="firstname" class="col-sm-3">First Name</label>
                            <input type="text" id="firstname" class="col-sm-3" name="firstname">
                            <label for="lastname" class="col-sm-3">Last Name</label>
                            <input type="text" id="lastname" class="col-sm-3" name="lastname">
                        </div>
                        <div class="form-group">
                            <label for="NationalID" class="col-sm-3">National ID</label>
                            <input type="text" id="NationalID" class="col-sm-3" name="nationalID">
                            <label for="BirthDate" class="col-sm-3">Birth Date</label>
                            <input id="BirthDate" type="text" name="birthDate" class="col-sm-3"/>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2">Gender</label>
                            <input type="radio" name="gender" value="Male" class="col-sm-1">
                            <label class="col-sm-2">Male</label>
                            <input type="radio" name="gender" value="Female" class="col-sm-1">
                            <label class="col-sm-2">Female</label>
                        </div>
                        <label> Education Information:</label>
                        <br><br>

                        <div class="form-group">
                            <label for="StudentID" class="col-sm-3">Student ID</label>
                            <input type="text" id="studentid" class="col-sm-3" name="studentID">
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3">Field of Study</label>
                            <select class="col-sm-3 form-control" name="fieldsOfStudy">

                                <c:forEach var="field" items="${fields}">
                                    <option value="${field}">
                                            ${field}
                                    </option>
                                </c:forEach>
                            </select>
                            <label class="col-sm-3">Degree</label>
                            <select class="col-sm-3 form-control" name="degree">
                                <c:forEach var="degree" items="${degrees}">
                                    <option value="${degree}">
                                            ${degree}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <label> Contact Information:</label>
                        <br><br>

                        <div class="form-group">
                            <label for="email" class="col-sm-3">Email</label>
                            <input type="text" id="email" class="col-sm-3" name="email">
                            <label for="phone" class="col-sm-3">Phone</label>
                            <input type="text" id="phone" class="col-sm-3" name="tel">
                        </div>

                        <div class="form-group">
                            <label for="address" class="col-sm-3">Address</label>
                            <input type="text" id="address" class="col-sm-9" name="address">
                        </div>
                        <button class="btn btn-success">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    $('label').addClass('control-label');
    $('select').css('width','25%');
    $('label').css('text-align','left');
</script>
</html>
