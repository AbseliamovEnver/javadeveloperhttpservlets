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
<div align="center">
    <c:if test="${project != null}">
    <form name="ProjectServlet" action="updateProject" method="post">
        </c:if>
<%--        <c:if test="${project == null}">--%>
<%--        <form name="ProjectServlet" action="insertProject" method="post">--%>
<%--            </c:if>--%>
            <table border="1" cellpadding="5">
                <c:if test="${project != null}">
                    <input type="hidden" name="project_id" value="<c:out value='${project.id}' />" />
                </c:if>
                <tr>
                    <th>Project Name: </th>
                    <td>
                        <input type="text" name="name" size="50"
                               value="<c:out value='${project.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Project Budget: </th>
                    <td>
                        <input type="text" name="budget" size="50"
                               value="<c:out value='${project.budget}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Customer Name: </th>
                    <td>
                        <form name="CustomerServletList" action="listCustomers" method="post">
                            <label for="customer">
                                <select id="customer" name="customer">
<%--                                    <option value="First Choice">First Choice</option>--%>
<%--                                    <option value="Second Choice">Second Choice</option>--%>
<%--                                    <option value="Third Choice">Third Choice</option>--%>
<%--                                    <option value="Fourth Choice">Fourth Choice</option>--%>
                                    <c:forEach var="customer" items="${listCustomers}">
                                        <option value="${customer.id}"
                                                <c:if test="${customer.id eq customer_id}">selected="selected"</c:if> >
                                                ${customer.name}
                                        </option>
                                    </c:forEach>
                                </select>
                            </label>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save"/>
                    </td>
                </tr>
            </table>
<%--        </form>--%>
    </form>
</div>
</body>
</html>
