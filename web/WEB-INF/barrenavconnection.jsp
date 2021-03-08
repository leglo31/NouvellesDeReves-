<%-- 
    Document   : barrenavconnection
    Created on : 23 févr. 2021, 14:38:45
    Author     : Glotin Laurent
--%>

            
                    <div class="barreinscription">

            <ul id="ulinscription">


                <c:choose>
                    <c:when test="${empty sessionScope.sessionUtilisateur}">
                        <li><a href="<c:url value="/inscription" />">Inscription</a></li>
                        <li><a href="<c:url value="/connexion" />">Connexion</a></li>
                        </c:when>
                        <c:otherwise>
                        <li><a href="<c:url value="/deconnexion" />">Déconnexion</a></li>
                        </c:otherwise>
                    </c:choose>
            </ul>

            <div id="script"><SCRIPT LANGUAGE="JavaScript">
                var ladate = new Date()
                var tab_jour = new Array("Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi");
                var tab_mois = new Array("Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre");
                Jour = ladate.getDate();
                Heure = ladate.getHours();
                Min = ladate.getMinutes();
                Annee = ladate.getFullYear();
                Seconde = ladate.getSeconds();
                var dateFormatee = (tab_jour[ladate.getDay()] + " " + Jour + " "
                        + tab_mois[ladate.getMonth()] + " " + Annee + " &nbsp;" + "&nbsp;" + Heure + ":"
                        + Min + ":" + Seconde)
                document.write(dateFormatee);
                </SCRIPT></div>
        </div>
