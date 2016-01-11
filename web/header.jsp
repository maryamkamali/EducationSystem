<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maryam.kamali
  Date: 12/14/2015
  Time: 8:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css" media="all" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="/assets/css/styles.css" media="all" rel="stylesheet" type="text/css"/>
    <script src="/assets/js/jquery-2.1.4.js"></script>
</head>
<header>
    <div class="container">
        <div style="height: 100px; background-color: darkseagreen">
            <a href="${user.homePageAddress}">
                <button>Home</button>
            </a>
            <a href="/logout" >
                <button>Logout</button>
            </a>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <nav>
                    <ul class="tab-pane">
                        <c:forEach var="item" items="${user.menueItems}">
                            <li class="col-md-2">
                                <a href="${item.value}">${item.key}</a>
                            </li>
                        </c:forEach>

                    </ul>
                </nav>
            </div>
        </div>
    </div>
</header>
</html>
