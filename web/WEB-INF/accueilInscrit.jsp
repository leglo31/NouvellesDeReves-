<%--
    Document   : accueil
    Created on : 21 avr. 2020, 16:41:41
    Author     : Quentin Fankrache
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>AccueilInscrit</title>
        <link rel="stylesheet" href="<c:url value="/inc/global.css" />">

    </head>

    <body id="bodyAccueil">

        <%@include file="/WEB-INF/header.jsp" %>
        <%@include file="/WEB-INF/barrenavconnection.jsp" %>
        
      <div class="centre">   
        
         <%@include file="/WEB-INF/asides.jsp" %>
        
         
   
    
    
   <section id="container">
          <ul>
        <li class="button"><a href="<c:url value="/nouvelle"/>">voir mes nouvelles crées</a></li>
        <li class="button"><a href="<c:url value="/creationNouvelle" />">Ajouter une nouvelle</a></li>      
    </ul>
                    <c:forEach  items="${requestScope.test}" var="nouvelle" >
                        
                <div class="nouvelle">  

                    <p>${id} </p>

                    <h3><c:out value="${nouvelle.titre}" /> <span style="font-size:10pt;"> par <c:out value="${nouvelle.auteur}"/></h3>

                    <!--limiter au 200 prmiers caractères-->
                    <c:set var = "string1" value = "${nouvelle.contenu}"/>
                    <c:set var = "string2" value = "${fn:substring(string1, 0, 200)}" />
                    <p>Résumé : ${string2}</p>


                    <p>Score <c:out value="${nouvelle.score}" /></p>
                    <p>Nouvelle publiée le <c:out value="${nouvelle.dateCreation}" /></p>

                    <a href="<c:url value="/nouvelle?id=${nouvelle.id}"/>" />En savoir plus</a>
                </div>

            </c:forEach>  
                    
        </section>
    
       </div>

    <%@include file="/WEB-INF/footer.jsp" %>

</body>

</html>