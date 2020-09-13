<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Welcome Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<body>

<jsp:include page="../include/menu.jsp"/>

<br>

<div class="container">
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <h2>form</h2>
            <form action="team-edit" method="post">
                <div class="form-group">
                    <label>ID:</label>
                    <input class="form-control" id="idID" name="id" readonly="readonly" value="${team.id}">
                </div>

                <div class="form-group">
                    <label for="nameID">Name:</label>
                    <input class="form-control" id="nameID" placeholder="Please enter the new team name" name="name"
                           value="${team.name}">
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <c:if test="${empty team.id}">
                            <button type="submit" class="btn btn-success">Create</button>
                        </c:if>

                        <c:if test="${!empty team.id}">
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