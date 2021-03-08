<%-- 
    Document   : nouvelle
    Created on : 21 avr. 2020, 16:40:03
    Author     : Quentin Fankrache
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/NouvellesDeReves/inc/global.css">

    </head>
    <body id="bodyNouvelle">
        <%@include file="header.jsp" %>
        
        <c:forEach  items="${requestScope.nouvelle}" var="nouvel" >

        <li><c:out value="${nouvel.titre}" /> par <c:out value="${nouvel.auteur}" />, le  <fmt:formatDate pattern = "EEEE dd MMMMM yyyy à HH:mm" value = "${nouvel.dateCreation}" /></li>
        <!--reformatage de la date et heures en utilisant la balise EL fmt:formatDate sur la date de création qui est en TimeStamp-->
        
    </c:forEach>

    <%@include file="footer.jsp" %>
</body>
</html>
