<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Team Management</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=2">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <script src="js/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="panel panel-primary">
                <div class="text-center h3">Team Management</div>
                <div style="text-align: center">
                    <div class="panel-body">
                        <div class="row">
                            <table class="table table-bordered table-hover table-responsive[-sm|-md|-lg|-xl]">
                                <thead class="bg-secondary">
                                    <tr>
                                        <th class="text-center h4">Team CRUD Operations</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>
                                            <a class="btn btn-block btn-primary text-center h2" type="button"
                                               href="team-form.jsp" role="link">Add New Team</a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a class="btn btn-block btn-primary text-center h2" type="button"
                                               href="team-list.jsp" role="link">List of All Teams</a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a class="btn btn-block btn-primary text-center h2" type="button"
                                               href="team-list.jsp" role="link">Edit Team</a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a class="btn btn-block btn-primary text-center h2" type="button"
                                               href="team-list.jsp" role="link">Delete Team</a>
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
