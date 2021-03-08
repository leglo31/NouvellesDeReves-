<%--
    Document   : connexion
    Created on : 21 avr. 2020, 16:36:01
    Author     : Quentin Fankrache
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>>
<!DOCTYPE html>
<html>
    <head>
         <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Accueil</title>
        <link rel="stylesheet" href="<c:url value="/inc/global.css" />">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" type="image/x-icon" href="<c:url value="/inc/moon.ico" />"><%--icone sur titre onglet</nav>--%>
    </head>
        <title>Connexion</title>
    </head>
    <body>
        <%@include file="/WEB-INF/header.jsp" %>
        <form method="post" action="connexion">
            <fieldset>
                <legend>Connexion</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>
                <label for="mail">Adresse mail <span class="requis">*</span></label>
                <input type="text" id="mail" name="mail" value="<c:out value="${utilisateur.mail}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['mail']}</span>
                <br /><label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['motdepasse']}</span>
                <br /><input type="submit" value="Connexion" class="sansLabel" />
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </fieldset>
        </form>
        <%@include file="/WEB-INF/footer.jsp" %>    </body>
</html>