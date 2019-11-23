<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Specialty Management</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=2">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <script src="js/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
</head>
<body>
<div class="container">
    <div class="panel panel-primary">
        <div class="text-center h3">Specialty Management</div>
        <div style="text-align: center">
            <div class="panel-body">
                <div class="row">
                    <table class="table table-bordered table-hover table-responsive[-sm|-md|-lg|-xl]">
                        <tbody>
                        <tr>
                            <a class="btn btn-block btn-primary text-center h2" type="button"
                               href="index.jsp" role="link">Main menu</a>
                        </tr>
                        <tr>
                            <a class="btn btn-block btn-primary text-center h2" type="button"
                               href="specialty-main.jsp" role="link">Specialty menu</a>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="align-content-center">
<%--    <form name="ListAllSpecialty" action="listSpecialty" method="post">--%>
    <table class="table table-bordered table-hover border">
        <thead class="bg-secondary">
        <tr>
            <th class="text-center h4" colspan="4">List of Specialties</th>
        </tr>
        <tr>
            <th class="text-center h5">ID</th>
            <th class="text-center h5">Specialty</th>
            <th class="text-center h5" colspan="2">Actions</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="specialty" items="${listSpecialty}">
                <tr>
                    <td><c:out value="${specialty.specialty_id}" /></td>
                    <td><c:out value="${specialty.specialty}" /></td>
                    <td>
                        <a class="btn btn-success" href="editSpecialty?specialty_id=<c:out value='${specialty.specialty_id}' />">Edit</a>
                    </td>
                    <td>
                        <a class="btn btn-danger" href="deleteSpecialty?specialty_id=<c:out value='${specialty.specialty_id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
<%--    </form>--%>
</div>
</body>
</html>
