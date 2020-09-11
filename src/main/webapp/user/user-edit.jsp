<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Welcome Page</title>
    <meta charset="utf-8">
    <meta firstName="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<body>

<nav class="navbar navbar-expand-sm bg-light">
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="../index.html">Home Page</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="userlist">User List</a>
        </li>
    </ul>
</nav>
<br>

<div class="container">
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <h2>form</h2>
            <form action="user-edit" method="post">
                <div class="form-group">
                    <label>ID:</label>
                    <input class="form-control" id="idID" name="id" readonly="readonly" value="${user.id}">
                </div>

                <div class="form-group">
                    <label for="nameID">First name:</label>
                    <input class="form-control" id="nameID" placeholder="Please enter the new first name" name="firstName"
                           value="${user.firstName}">
                </div>

                <div class="form-group">
                    <label for="secondNameID">Second name:</label>
                    <input class="form-control" id="secondNameID" placeholder="Please enter the new second name" name="secondName"
                           value="${user.secondName}">
                </div>

                <div class="form-group">
                    <label for="login">Login:</label>
                    <input class="form-control" id="login" placeholder="Please enter your new login" name="login"
                           value="${user.login}">
                </div>
                <div class="form-group">
                    <label>Teams:</label>
                    <c:forEach var="team" items="${teams}">
                        <input type="checkbox" name="teams" checked="${userTeams.contains(team.id)}" value="${team.id}" />${team.name}
                    </c:forEach>
                </div>



                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <c:if test="${empty user.id}">
                            <button type="submit" class="btn btn-success">Create</button>
                        </c:if>

                        <c:if test="${!empty user.id}">
                            <button type="submit" class="btn btn-success">Update</button>
                        </c:if>

                    </div>
                </div>

            </form>

        </div>
        <div class="col-sm-3"></div>
    </div>


    <hr>
    <hr>
</div>

</body>

</html>