<%@ page contentType="text/html; charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%--<jsp:forward page="skill-list.jsp"></jsp:forward>--%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>IT Company</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=2">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <script src="js/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading panel-title text-center h3">IT Company</div>
                <div class="panel-body">
                    <div class="row">
                        <table class="table table-bordered table-hover">
                            <thead class="bg-secondary">
                                <tr>
                                    <th class="text-center h4">Main Menu</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <a class="btn btn-block btn-primary text-left" type="button"
                                           href="skill-main.jsp" role="link">Skill Management</a></td>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a class="btn btn-block btn-primary text-left" type="button"
                                           href="specialty-main.jsp" role="link">Specialty Management</a></td>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a class="btn btn-block btn-primary text-left" type="button"
                                           href="skill-list.jsp" role="link">Customer Management</a></td>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a class="btn btn-block btn-primary text-left" type="button"
                                           href="skill-list.jsp" role="link">Project Management</a></td>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a class="btn btn-block btn-primary text-left" type="button"
                                           href="skill-list.jsp" role="link">Team Management</a></td>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a class="btn btn-block btn-primary text-left" type="button"
                                           href="skill-list.jsp" role="link">User Management</a></td>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
