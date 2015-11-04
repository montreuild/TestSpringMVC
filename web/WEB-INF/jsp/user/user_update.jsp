<%-- 
    Document   : ajouter
    Created on : 4 nov. 2015, 15:22:17
    Author     : ETY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modifier un utilisateur</h1>

        <div>
            <form:form modelAttribute="util" action="modifier" method="POST">
                <form:hidden path="id"/>
                Login: <form:input path="login"/>
                Mot de passe: <form:input path="mdp"/>
                Email:  <form:password path="email"/>
                Age: <form:input path="age"/>
                <input type="submit" value="Modifier" />
            </form:form>
        </div>
    </body>
</html>
