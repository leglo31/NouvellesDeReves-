<%-- 
    Document   : gestionUtilisateurs
    Created on : 21 janv. 2021, 13:59:09
    Author     : asus
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/NouvellesDeReves/inc/global.css">
        <title>Gestion des Utilisateurs</title>
    </head>
    <body>
        <h2 align="center">Gestion des Utilisateurs</h2>

        <table border="1" cellpadding="3" cellspacing="0" width="90%" align="center" border-spacing = "10px">
            <tr bgcolor="#FFB6C1">
                <th>id </th>
                <th>Pseudo</th>
                <th>Mail</th>
                <th>Motdepasse</th>
                <th align="center" width="5%">idProfil</th>

            </tr>


            <c:forEach  items="${requestScope.essaiUtilisateur}" var="utilisateur" >



                <tr onclick="SelectLigne(this)">
                    <td><c:out value="${utilisateur.id}" />  </td>
                    <td> <c:out value="${utilisateur.pseudo}"/> </td>
                    <td> <c:out value="${utilisateur.mail}" /></td>
                    <td><c:out value="${utilisateur.motdepasse}" /></td>
                    <td><c:out value="${utilisateur.idProfil}" /></td>

                </tr>
           
            <%--  ("${nouvelle.id}") --%>
            <%-- <h4>id: <c:out value="${utilisateur.id}" />    Pseudo:<c:out value="${utilisateur.pseudo}"/>    Mail: <c:out value="${utilisateur.mail}" />    Motdepasse: <c:out value="${utilisateur.motdepasse}" />    idProfil: <c:out value="${utilisateur.idProfil}" /></h4>--%>

        </c:forEach>     
 </table>
   

        <br>
    <li class="button"><a href="<c:url value="/gestionUtilisateurs" />"style="text-decoration:none">Ajouter</a></li>
    <li class="button"><a href="<c:url value="/gestionUtilisateurs" />"style="text-decoration:none">Supprimer</a></li>
    <li class="button"><a href="<c:url value="/gestionUtilisateurs" />"style="text-decoration:none">Modifier</a></li>   

</body>
</html>
