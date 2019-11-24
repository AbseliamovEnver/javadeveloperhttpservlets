<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>User Management</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=2">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <script src="js/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="panel panel-primary">
                <div class="text-center h3">User Management</div>
                <div style="text-align: center">
                    <div class="panel-body">
                        <div class="row">
                            <tr>
                                <td>
                                    <a class="btn btn-block btn-primary text-center h2" type="button"
                                       href="index.jsp" role="link">Main menu</a>
                                </td>
                            </tr>
                            <table class="table table-bordered table-hover table-responsive[-sm|-md|-lg|-xl]">
                                <thead class="bg-secondary">
                                    <tr>
                                        <th class="text-center h4">User CRUD Operations</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>
                                            <a class="btn btn-block btn-primary text-center h2" type="button"
                                               href="user-form.jsp" role="link">Add New User</a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a class="btn btn-block btn-primary text-center h2" type="button"
                                               href="user-list.jsp" role="link">List of All Users</a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a class="btn btn-block btn-primary text-center h2" type="button"
                                               href="user-list.jsp" role="link">Edit User</a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a class="btn btn-block btn-primary text-center h2" type="button"
                                               href="user-list.jsp" role="link">Delete User</a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
