<%--
  Created by IntelliJ IDEA.
  User: sedigheh.arabameri
  Date: 11/3/2015
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <jsp:include page="header.jsp"></jsp:include>
</head>

<body>

<div class="container top-admin">
    <div class="row">
        <div class="col-md-offset-4 col-md-4">
            <a href="/student">
                <button class="btn-my">
                    Manage Students
                </button>
            </a>
        </div>
    </div>
    <div class="row">
        <div class="col-md-offset-4 col-md-4">
            <a href="/teacher">
                <button class="btn-my">
                    Manage Teachers
                </button>
            </a>
        </div>
    </div>
    <div class="row">
        <div class="col-md-offset-4 col-md-4">
            <a href="/course">
                <button class="btn-my">
                    Manage Courses
                </button>
            </a>
        </div>
    </div>
</div>
</body>
</html>
