<%-- 
    Document   : accueilAdmin
    Created on : 21 avr. 2020, 16:40:21
    Author     : Quentin Fankrache
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/NouvellesDeReves/inc/global.css">
        <title>Admin</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <h1>Page de gestion réservée à l'administrateur du site.</h1>

        <p>Vous trouverez ci-dessous les nouvelles, commentaires et utilisateurs signalés suite au non-respect de 
            la charte du site.</p>

        <c:forEach items="${nouvellesSignalees}" var="nouvelleSignalee">
            <div class="nouvelleSignalee">

                <h3><c:out value="${nouvelleSignalee.titre}" /> <span style="font-size:10pt;">par <c:out value="${nouvelleSignalee.idUtilisateur}" /></h3>
                <p>Score: </p>
                <p>Nouvelle publiée le <c:out value="${nouvelleSignalee.dateCreation}" /></p>


            </div>
        </c:forEach>
        
              <li class="button"><a href="<c:url value="/gestionUtilisateurs" />">Gestion Utilisateurs</a></li>
          <li class="button"><a href="<c:url value="/gestionNouvelles" />">Gestion Nouvelles</a></li>
            <li class="button"><a href="<c:url value="/gestionCommentaires" />">Gestion Commentaire</a></li>
        
        
        
        
        <%@include file="footer.jsp" %>
    </body>
</html>
