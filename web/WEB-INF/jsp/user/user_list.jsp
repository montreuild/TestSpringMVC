<%-- 
    Document   : user_list
    Created on : 4 nov. 2015, 14:35:57
    Author     : ETY
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
            <c:forEach items="${users}" var="util">
                <tr>
                    <td>${util.getId()}</td>
                    <td>${util.getLogin()}</td>
                    <td>${util.getMdp()}</td>
                    <td>${util.getAge()}</td>
                    <td>${util.getEmail()}</td>
                    <!--<td><a href="modifier/${util.getId()}">Modifier</a></td>-->
                    <td><a href=<spring:url value="/modifier/${util.getId()}"/>>Modifier</a></tr>
            </c:forEach>
        </table>
    </body>
</html>
