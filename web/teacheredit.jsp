<%@ page import="com.mahan.UI.Model.FieldsOfStudy" %>
<%@ page import="java.util.ArrayList" %>
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
<div class="container">
  <div class="panel panel-primary dialog-panel">
    <div class="panel-heading">
      <h5>Teacher Edit Form</h5>
    </div>
    <div class="row">
      <div class="col-sm-offset-1">
        <form action="/createbean.jsp" class="form-horizontal" style="margin-top: 20%">
          <input type="hidden" name="identifier" value="teacher">
          <label> Teacher Information:</label>
          <br><br>

          <div class="form-group">
            <label for="firstname" class="col-sm-2">First Name</label>
            <input type="text" id="firstname" value="${teachers[teacherOrder].firstname}" class="col-sm-3" name="firstname">
            <label for="lastname" class="col-sm-2">Last Name</label>
            <input type="text" id="lastname" value="${teachers[teacherOrder].lastname}" class="col-sm-3" name="lastname">
          </div>
          <div class="form-group">
            <label for="NationalNo" class="col-sm-2">National Number</label>
            <input type="text" id="NationalNo" value="${teachers[teacherOrder].nationalNo}" class="col-sm-3" name="nationalNo">
            <label for="BirthDate" class="col-sm-2">Birth Date</label>
            <input type="text" id="BirthDate" value="${teachers[teacherOrder].birthDate}" class="col-sm-3" name="birthDate">
          </div>
          <div class="form-group">
            <label class="col-sm-2">Gender</label>
            <c:if test="${teachers[teacherOrder].gender=='male'}">
              <%!String checked="checked";%>
            </c:if>
            <input type="radio" name="gender" <%=checked%>  class="col-sm-1" value="Male">
            <label class="col-sm-1">Male</label>
            <c:if test="${teachers[teacherOrder].gender=='female'}">
              <%!String checked2="checked";%>
            </c:if>
            <input type="radio" name="gender" <%=checked2%> class="col-sm-1" value="Female">
            <label class="col-sm-1">Female</label>
          </div>
          <label> Education Information:</label>
          <br><br>

          <div class="form-group">
            <label for="TeacherID" class="col-sm-2">Teacher Number</label>
            <input type="text" id="TeacherID" value="${teachers[teacherOrder].teacherNo}" class="col-sm-3" name="teacherNo">
            <label class="col-sm-2">Position</label>
            <select class="col-sm-3" value="${teachers[teacherOrder].position}" name="position">
              <c:forEach var="position" items="${positions}">
                <option value="${position}">
                    ${position}
                </option>
              </c:forEach>
            </select>
          </div>
          <label> Contact Information:</label>
          <br><br>
          <div class="form-group">
            <label for="email" class="col-sm-2">Email</label>
            <input type="text" value="${teachers[teacherOrder].email}" id="email" class="col-sm-3" name="email">
            <label for="phone" class="col-sm-2">Phone</label>
            <input type="text" value="${teachers[teacherOrder].tel}" id="phone" class="col-sm-3" name="tel">
          </div>

          <div class="form-group">
            <label for="address" class="col-sm-2">Address</label>
            <input type="text" value="${teachers[teacherOrder].address}" id="address" class="col-sm-8" name="address">
          </div>
          <button class="btn btn-success">Submit</button>
        </form>
      </div>
    </div>
  </div>
</div>
<script>
  $('label').addClass('control-label');
  $('select').css('width','25%');
  $('label').css('text-align','left');
  $('select').addClass('form-control');
</script>
</body>
</html>
