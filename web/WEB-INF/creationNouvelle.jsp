<%-- 
    Document   : creationNouvelle
    Created on : 29 janv. 2021, 12:58:22
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création Nouvelle</title>
        <link rel="stylesheet" href="<c:url value="/inc/form.css" />">
    </head>
    <body>
        <%@include file="/WEB-INF/header.jsp" %>
        <form method="post" action="creationNouvelle">
            <fieldset>
                <legend>Formulaire de création d'une nouvelle</legend>
                <p>Veuillez remplir ce formulaire pour créer votre nouvelle.</p>

                <label for="titre">Titre de votre nouvelle: <span class="requis"> *</span></label>
                <input type="text" id="pseudo" name="titre" value="<c:out value="${nouvelle.titre}" />" size="20" maxlength="20" />

                <br />

                <label for="contenu">Votre nouvelle: <span class="requis"> *</span></label>
                <textarea rows="5" cols="50" name="contenu" placeholder="Entrez votre nouvelle ici..." value="<c:out value="${nouvelle.contenu}" />"></textarea>
                <%--<input type="text" id="mail" name="contenu" value="<c:out value="${nouvelle.contenu}" />" size="60" maxlength="120" />--%>

                <br />

                <label for="auteur">Auteur: <span class="requis"> *</span></label>
                <input type="text" id="mail" name="auteur" value="<c:out value="${nouvelle.auteur}" />" size="20" maxlength="60" />

                <br />

                <input type="submit" value="Ajouter" class="sansLabel" />


                <p>Les champs marqués d'un <span class="requis">*</span> sont obligatoires.</p>



            </fieldset>
        </form>



        <%@include file="/WEB-INF/footer.jsp" %>
    </body>
</html>