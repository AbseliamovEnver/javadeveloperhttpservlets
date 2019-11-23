<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Skill Management</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=2">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <script src="js/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="panel panel-primary">
                <div class="text-center h3">Skill Management</div>
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
                                           href="skill-main.jsp" role="link">Skill menu</a>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div align="center">
            <c:if test="${skill != null}">
            <form name="SkillServlet" action="updateSkill" method="post">
            </c:if>
                <c:if test="${skill == null}">
                <form name="SkillServlet" action="insertSkill" method="post">
                </c:if>
                    <table border="1" cellpadding="5">
                        <c:if test="${skill != null}">
                            <input type="hidden" name="skill_id" value="<c:out value='${skill.id}' />" />
                        </c:if>
                        <tr>
                            <th>Skill Name: </th>
                            <td>
                                <input type="text" name="name" size="50"
                                       value="<c:out value='${skill.name}' />"
                                />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input type="submit" value="Save"/>
                            </td>
                        </tr>
                    </table>
                </form>
            </form>
        </div>
    </body>
</html>
