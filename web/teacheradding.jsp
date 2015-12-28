<%--
  Created by IntelliJ IDEA.
  User: 921227
  Date: 11/22/2015
  Time: 7:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Teacher Adding Form</title>
    <jsp:include page="header.jsp"></jsp:include>
</head>
<body>
<div class="container-fluid">
    <div class="panel panel-primary dialog-panel">
        <div class="panel-heading">
            <h5>Teacher Adding Form</h5>
        </div>
        <div class="row">
            <div class="col-sm-6 col-sm-offset-3">
                <form class="form-horizontal" style="margin-top: 20%" action="/teacher/save">
                    <input type="hidden" name="identifier" value="teacher">
                    <label> Personal Information:</label>
                    <br><br>

                    <div class="form-group">
                        <label for="firstname" class="col-sm-3">First Name</label>
                        <input type="text" id="firstname" class="col-sm-3" name="firstname">
                        <label for="lastname" class="col-sm-3">Last Name</label>
                        <input type="text" id="lastname" class="col-sm-3" name="lastname">
                    </div>
                    <div class="form-group">
                        <label for="NationalNo" class="col-sm-3">National Number</label>
                        <input type="text" id="NationalNo" class="col-sm-3" name="nationalNo">
                        <label for="BirthDate" class="col-sm-3">Birth Date</label>
                        <input type="text" id="BirthDate" class="col-sm-3" name="birthDate">

                    </div>

                    <div class="form-group">
                        <label class="col-sm-2">Gender</label>
                        <input type="radio" name="gender" value="Male" class="col-sm-1">
                        <label class="col-sm-2">Male</label>
                        <input type="radio" name="gender" value="Female" class="col-sm-1">
                        <label class="col-sm-2">Female</label>
                    </div>
                    <label> Teaching Information:</label>
                    <br>
                    <br>

                    <div class="form-group">
                        <label for="tacherID" class="col-sm-3">Teacher Number</label>
                        <input type="text" id="tacherID" class="col-sm-3" name="teacherNo">
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3">Position</label>
                        <select class="col-sm-3 form-control" name="position">

                            <c:forEach var="position" items="${positions}">
                                <option value="${position}">
                                        ${position}
                                </option>
                            </c:forEach>
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

</body>
<script>
    $('label').addClass('control-label');
    $('select').css('width', '25%');
    $('label').css('text-align', 'left');
</script>
</html>
