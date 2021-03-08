<%--
    Document   : header
    Created on : 23 février 2021, 16:39:02
    Author     : Glotin Laurent
       
--%>
  
    
        <header id="headerdisposition">
            <h1>Nouvelles de Rêves</h1>
            <nav >
                <ul class="uldispo">
                    <li id="logo"><a href="<c:url value="/" />">Accueil de Rêves</a></li>
                    <li><a href="#">Nouvelles</a></li>
                    <li><a href="#">Charte</a></li>
                    <li><a href="#">Aide</a></li>
                    <li><a href="#">Liens</a></li>
                    <li><a href="#">Contact</a></li>
                </ul>
            </nav>

        </header>




<%--

<nav>
    <ul>
        <li class="button"><a href="<c:url value="/" />">Accueil</a></li>
        <c:choose>
            <c:when test="  ${empty sessionScope.sessionUtilisateur}" >
                <li class="button"><a href="<c:url value="/inscription" />">Inscription</a></li>
                <li class="button"><a href="<c:url value="/connexion" />">Connexion</a></li>
            </c:when>
            <c:otherwise>
                <li class="button"><a href="<c:url value="/deconnexion" />">Déconnexion</a></li>
            </c:otherwise>
        </c:choose>
    </ul>

</nav>--%>

