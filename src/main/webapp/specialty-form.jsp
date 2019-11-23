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
                    <table class="table table-bordered table-hover">
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
<div align="center">
    <c:if test="${specialty != null}">
    <form name="SpecialtyServlet" action="updateSpecialty" method="post">
        </c:if>
        <c:if test="${specialty == null}">
        <form name="SpecialtyServlet" action="insertSpecialty" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <c:if test="${specialty != null}">
                    <input type="hidden" name="specialty_id" value="<c:out value='${specialty.id}' />" />
                </c:if>
                <tr>
                    <th>Specialty Name: </th>
                    <td>
                        <input type="text" name="specialty" size="50"
                               value="<c:out value='${specialty.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
    </form>
</div>
</body>
</html>
