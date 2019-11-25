<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Project Management</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=2">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <script src="js/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="panel panel-primary">
                <div class="text-center h3">Project Management</div>
                <div style="text-align: center">
                    <div class="panel-body">
                        <div class="row">
                            <table class="table table-bordered table-hover">
                                <tbody>
                                <tr>
                                    <a class="btn btn-block btn-primary text-center h2" type="button"
                                       href="index.jsp" role="link">Main menu</a>
                                </tr>
                                <tr>
                                    <a class="btn btn-block btn-primary text-center h2" type="button"
                                       href="project-main.jsp" role="link">Project menu</a>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="align-content-center">
            <table class="table table-bordered table-hover border">
                <thead class="bg-secondary">
                    <tr>
                        <th class="text-center h4" colspan="6">List of Projects</th>
                    </tr>
                    <tr>
                        <th class="text-center h5">ID</th>
                        <th class="text-center h5">Name</th>
                        <th class="text-center h5">Budget</th>
                        <th class="text-center h5">Customer</th>
                        <th class="text-center h5" colspan="2">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="project" items="${listProject}">
                        <tr>
                            <td><c:out value="${project.id}" /></td>
                            <td class="text-center"><c:out value="${project.name}" /></td>
                            <td class="text-center"><c:out value="${project.budget}"/></td>
                            <td class="text-center"><c:out value="${project.customer.name}"/></td>
                            <td class="text-center">
                                <a class="btn btn-success text-center"
                                   href="editProject?project_id=<c:out value='${project.id}' />">Edit</a>
                            </td>
                            <td class="text-center">
                                <a class="btn btn-danger text-center"
                                   href="deleteProject?project_id=<c:out value='${project.id}' />">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
