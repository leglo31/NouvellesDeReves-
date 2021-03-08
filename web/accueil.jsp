<%--
    Document   : accueil
    Created on : 21 avr. 2020, 16:41:41
    Author     : Glotin Laurent
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Accueil</title>
        <link rel="stylesheet" href="<c:url value="/inc/global.css" />">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" type="image/x-icon" href="<c:url value="/inc/moon.ico" />"><%--icone sur titre onglet</nav>--%>
    </head>

    <body>

        <!--HEADER-->
        <%@include file="/WEB-INF/header.jsp" %>

        <!--INSCRIPTION/CONNECTION-->
        <%@include file="/WEB-INF/barrenavconnection.jsp" %>

        <!--**************************************************************************************************************-->
        <!--*************************************************///CENTRE///*************************************************-->
        <!--**************************************************************************************************************-->
        <div class="centre">
            <!--INSIDE-->
            <%@include file="/WEB-INF/asides.jsp" %>
            <!--INSIDE-->

            <!--PARAGRAPHE/NOUVELLES-->
            <main> <!--Prend toute la partie paragraphe et nouvelles-->

                <article>
                    <div><h5>Bienvenue sur Nouvelles de Rêves, site de publications littéraires</h5></div> 
                    <section id="img">
                        <h4>Nouvelles de Rêves</h4>
                        <p>Nouvelles de Rêves est un site consacré à la littérature. Il est né afin d'offrir aux auteurs une possibilité de présenter leurs écrits devant un public composé à la fois d'auteurs et de simples passionnés de littérature. Les activités de "Nouvelles de Rêves" sont principalement tournées vers la publication de nouvelles et la publication de poésies. </p>                        
                        <p>Nouvelles de Rêves se veut un site vivant. En effet, vous trouverez ici une véritable communauté occupée à toutes sortes d'activités comme l'écriture, l'évaluation des récits, l'échange d'informations littéraires ou linguistiques, ou encore la correction orthographique et typographique des récits reçus afin de présenter les publications au meilleur niveau possible. Sans oublier les moments de détente et de récréation...</p>                     
                        <p>Vous êtes auteur débutant ou professionnel et vous souhaitez progresser dans l'art de l'écriture?. Proposez vos écrits et vous recevrez différents commentaires de lecteurs en retour. </p>                        
                        <p><I>Vous êtes lecteur et amateur de littérature?...Nouvelles de Rêves vous propose un catalogue de nouvelles et de poésies que vous êtes invités à commenter au gré de vos lectures.</I></p>
                    </section> 
                </article>

                <article>                
                    <div><h5>La dernière Nouvelle</h5></div>    
                        <c:forEach  items="${requestScope.derniere}" var="dernierenouvelle" >
                            <h3 id="h3lastnews"><c:out value="${dernierenouvelle.titre}" /><span class="spanouvelle"> écrite par </span><c:out value="${dernierenouvelle.auteur}"/></h3>
                         <%--   <span class="spandate"><fmt:formatDate pattern = "dd/MM/yy" value = "${nouvelle.dateCreation}" /></span>--%> 
                        </c:forEach>
                      <%--<h3  id="h3lastnews"><c:out value="${nouvelle.titre}" /> <span class="spanouvelle"> par </span><c:out value="${nouvelle.auteur}"/></h3>--%> 
                </article>

                <article> 
 <div id="h5dixnouvelles"><h5>Les dernières nouvelles publiées</h5></div>  
 <section id="section">
     <section> 
                                                          
                        <!--Les 10 dernières nouvelles avec un foreach-->
                        <c:forEach  items="${requestScope.essai}" var="nouvelle" >
                            <h3 id="h3dixnouvelles"><c:out value="${nouvelle.titre}" /><span class="spanouvelle"> écrite par </span><c:out value="${nouvelle.auteur}"/></h3>
                         <%--   <span class="spandate"><fmt:formatDate pattern = "dd/MM/yy" value = "${nouvelle.dateCreation}" /></span>--%> 
                        </c:forEach>
                             <c:forEach  items="${requestScope.essai}" var="nouvelle" >
                            <h3 id="h3dixnouvelles"><c:out value="${nouvelle.titre}" /><span class="spanouvelle"> écrite par </span><c:out value="${nouvelle.auteur}"/></h3>
                        </c:forEach>
                    </section> 
                    
                    <section>                   
                        <c:forEach  items="${requestScope.essai}" var="nouvelle" >
                            <h3 id="h3dixnouvelles"><c:out value="${nouvelle.titre}" /><span class="spanouvelle"> écrite par </span><c:out value="${nouvelle.auteur}"/></h3>
                        </c:forEach>
                             <c:forEach  items="${requestScope.essai}" var="nouvelle" >
                            <h3 id="h3dixnouvelles"><c:out value="${nouvelle.titre}" /><span class="spanouvelle"> écrite par </span><c:out value="${nouvelle.auteur}"/></h3>
                        </c:forEach>
                    </section>
</section>
                </article>  


            </main><!--Prend toute la partie paragraphe et nouvelles-->
            <!--PARAGRAPHE/NOUVELLES-->

        </div>
        <!--**************************************************************************************************************-->
        <!--*************************************************///CENTRE///*************************************************-->
        <!--**************************************************************************************************************-->

        <!--FOOTER-->
        <%@include file="/WEB-INF/footer.jsp" %>
        <!--FOOTER-->

    </body>  

</html>  


<%--<!DOCTYPE html>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Accueil</title>
        <link rel="stylesheet" href="<c:url value="/inc/global.css" />">

    </head>

    <body id="bodyAccueil">

        <%@include file="/WEB-INF/header.jsp" %>

        <h2>Bienvenue sur le site de partage de Nouvelles littéraires</h2>
        <h4>Vous trouverez les 10 dernières nouvelles mis en lignes, si vous voulez en découvrir davantage ou partagez, n'hésitez pas à vous inscrire</h4>

        <section id="container">

            <c:forEach  items="${requestScope.essai}" var="nouvelle" >

<%--  ("${nouvelle.id}") 
<div class="nouvelle">  

                    <p>${id} </p>

                    <h3><c:out value="${nouvelle.titre}" /> <span style="font-size:10pt;">par <c:out value="${nouvelle.auteur}"/></h3>

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

        <%@include file="/WEB-INF/footer.jsp" %>

    </body>

</html> --%> 

<!--    <footer>
        <ul id="copyright"> 
            <li>NouvellesDeRêves©Copyright 2021 | Tous droits réservés</li>

    </footer>-->


<!--         <ul id="reseau">
            <li><a href="http://twitter.com/share" class="twitter-share-button" 
                   data-count="vertical" data-via="InfoWebMaster">Tweet</a>
                <script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script></li>
        
            <li><iframe src="http://www.facebook.com/plugins/like.php?href=http://www.example.com/page.html&layout=box_count&show_faces=true&width=65&action=like&font=arial&colorscheme=light&height=65" 
                        scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:75px; height:40px; margin-left: 4px" allowTransparency="true"></iframe></li>
        
        
            <li><script type="text/javascript" src="http://platform.linkedin.com/in.js"></script>
                <script type="in/share" data-counter="top"></script></li> 
        
        </ul> -->

<!--                <li>Designed by Glotin Laurent</li> 
            </ul>



       >-->




