<%--
    Document   : footer
    Created on : 21 avr. 2020, 16:36:24
    Author     : Quentin Fankrache
--%>


<footer>
     <ul id="copyright"> 
    <%-- V�rification de la pr�sence d'un objet utilisateur en session --%>
    <c:choose>
        <c:when test="${!empty sessionScope.sessionUtilisateur}">
            <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
           
                
            <li>Vous �tes connect�(e) avec l'adresse : ${sessionScope.sessionUtilisateur.mail}</li>
            
        </c:when>
        <c:otherwise>
            <li>Vous n'�tes pas connect�. Souhaitez-vous vous <a href="<c:url value="/connexion" />">connecter?</a></li>
       
        </c:otherwise>
    </c:choose>
   
    
      
            <li>NouvellesDeR�ves�Copyright 2021 | Tous droits r�serv�s</li>
             <li>Designed by Glotin Laurent</li> 
    </ul>
    
    
    
</footer>