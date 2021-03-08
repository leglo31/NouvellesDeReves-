<%--
    Document   : inscription
    Created on : 21 avr. 2020, 16:39:48
    Author     : Quentin Fankrache
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link rel="stylesheet" href="<c:url value="/inc/form.css" />">
    </head>
    <body>
        <%@include file="/WEB-INF/header.jsp" %>
        <form method="post" action="inscription">
            <fieldset>
                <legend>Formulaire d'inscription</legend>
                <p>Veuillez remplir ce formulaire pour vous inscrire.</p>

                <label for="pseudo">Nom d'utilisateur<span class="requis">*</span></label>
                <input type="text" id="pseudo" name="pseudo" value="<c:out value="${user.pseudo}" />" size="20" maxlength="20" />
                <span class='erreur'>${form.erreurs.pseudo}</span>
                <br />

                <label for="mail">Adresse mail <span class="requis">*</span></label>
                <input type="text" id="mail" name="mail" value="<c:out value="${user.mail}" />" size="20" maxlength="60" />
                <span class='erreur'>${form.erreurs.mail}</span>
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span class='erreur'>${form.erreurs.motdepasse}</span>
                <br />

                <label for="confirmation">Confirmation <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <br />




                <input type="submit" value="Inscription" class="sansLabel" />

                <p>Les champs marqués d'un <span class="requis">*</span> sont obligatoires.</p>
                <p class="${empty form.erreurs ? "succes" : "erreur"}">${form.resultat}</p>
               
            </fieldset>
        </form>
        <%@include file="/WEB-INF/footer.jsp" %>
    </body>
</html>