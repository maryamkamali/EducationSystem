<%@ page import="com.mahan.biz.FieldsOfStudy" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="com.mahan.biz.Student" %>
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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Student Adding Form</title>
    <jsp:include page="header.jsp"></jsp:include>
</head>
<body>
<div class="container-fluid">
    <div class="panel panel-primary dialog-panel">
        <div class="panel-heading">
            <h5>Student Edit Form</h5>
        </div>
        <div class="row">
            <div class="col-sm-6 col-sm-offset-3">
                <form action="/createbean.jsp" class="form-horizontal" style="margin-top: 20%" method="post">
                    <input type="hidden" name="identifier" value="student">
                    <label> Personal Information:</label>
                    <br><br>

                    <div class="form-group">
                        <label for="firstname" class="col-sm-2">First Name</label>

                        <input type="text" id="firstname" value="${students[studentOrder].firstname}" class="col-sm-4" name="firstname">
                        <label for="lastname" class="col-sm-2">Last Name</label>
                        <input type="text" id="lastname" value="${students[studentOrder].lastname}" class="col-sm-4" name="lastname">
                    </div>
                    <div class="form-group">
                        <label for="NationalID" class="col-sm-2">National ID</label>
                        <input type="text" id="NationalID" value="${students[studentOrder].nationalNo}" class="col-sm-4" name="nationalNo">
                        <label class="col-sm-2">Birth Date</label>
                        <input type="text" id="BirthDate" value="${students[studentOrder].birthDate}" class="col-sm-4" name="birthDate">
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2">Gender</label>
                        <c:if test="${students[studentOrder].gender=='male'}">
                            <%!String checked="checked";%>
                        </c:if>
                        <input type="radio" name="gender" <%=checked%>  class="col-sm-1" value="Male">
                        <label class="col-sm-2">Male</label>
                        <c:if test="${students[studentOrder].gender=='female'}">
                            <%!String checked2="checked";%>
                        </c:if>
                        <input type="radio" name="gender" <%=checked2%> class="col-sm-1" value="Female">
                        <label class="col-sm-2">Female</label>
                    </div>
                    <label> Education Information:</label>
                    <br><br>

                    <div class="form-group">
                        <label for="StudentID" class="col-sm-2">Student ID</label>
                        <input type="text" id="studentid" value="${students[studentOrder].studentNo}" class="col-sm-4" name="studentNo">
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2">Field of Study</label>
                        <select class="col-sm-4" value="${students[studentOrder].fieldsOfStudy}" name="fieldsOfStudy">

                            <c:forEach var="field" items="${fields}">
                                <option value="${field}">
                                        ${field}
                                </option>
                            </c:forEach>
                        </select>
                        <label class="col-sm-2">Degree</label>
                        <select class="col-sm-4"  value="${students[studentOrder].degree}" name="degree">

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
                        <label for="email" class="col-sm-2">Email</label>
                        <input type="text" value="${students[studentOrder].email}" id="email" class="col-sm-4" name="email">
                        <label for="phone" class="col-sm-2">Phone</label>
                        <input type="text" value="${students[studentOrder].tel}" id="phone" class="col-sm-4" name="tel">
                    </div>

                    <div class="form-group">
                        <label for="address" class="col-sm-2">Address</label>
                        <input type="text" value="${students[studentOrder].address}" id="address" class="col-sm-10" name="address">
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
    $('select').css('width','25%');
    $('label').css('text-align','left');
    $('select').addClass('form-control');
</script>
</html>
