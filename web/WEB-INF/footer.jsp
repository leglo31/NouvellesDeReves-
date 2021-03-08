<%--
    Document   : footer
    Created on : 21 avr. 2020, 16:36:24
    Author     : Quentin Fankrache
--%>


<footer>
     <ul id="copyright"> 
    <%-- Vérification de la présence d'un objet utilisateur en session --%>
    <c:choose>
        <c:when test="${!empty sessionScope.sessionUtilisateur}">
            <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
           
                
            <li>Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.mail}</li>
            
        </c:when>
        <c:otherwise>
            <li>Vous n'êtes pas connecté. Souhaitez-vous vous <a href="<c:url value="/connexion" />">connecter?</a></li>
       
        </c:otherwise>
    </c:choose>
   
    
      
            <li>NouvellesDeRêves©Copyright 2021 | Tous droits réservés</li>
             <li>Designed by Glotin Laurent</li> 
    </ul>
    
    
    
</footer>