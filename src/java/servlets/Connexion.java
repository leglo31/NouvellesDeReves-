package servlets;

import beans.Utilisateur;
import dao.NouvelleDAO;
import forms.ConnexionCheckForm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Quentin Fankrache
 */
@WebServlet(name = "Connexion", urlPatterns = {"/connexion"})
public class Connexion extends HttpServlet {

    private static final String ATT_USER = "utilisateur";
    private static final String ATT_FORM = "form";
    private static final String ATT_SESSION_USER = "sessionUtilisateur";
    private static final String VUE = "/WEB-INF/connexion.jsp";
    private static final String AccueilAdmin = "/WEB-INF/accueilAdmin.jsp";
    private static final String Accueil = "/WEB-INF/accueilInscrit.jsp";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        ConnexionCheckForm form = new ConnexionCheckForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Utilisateur util = form.checkForm(request);
        System.out.println(util);

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        if (form.getErreurs().isEmpty()) {
            session.setAttribute(ATT_SESSION_USER, util);
        } else {
            session.setAttribute(ATT_SESSION_USER, null);
        }


        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_USER, util);

        /* Permet de garder les données en session*/
        request.getSession().setAttribute(ATT_FORM, form);
        request.getSession().setAttribute(ATT_USER, util);

        NouvelleDAO accueilNouvelleDao = new NouvelleDAO();
        List<beans.Nouvelle> tabNouvelle = new ArrayList<>();
        tabNouvelle = accueilNouvelleDao.get10LastDescOrder();
        List<beans.Nouvelle> tabNouvelleSignalee = new ArrayList<>();
        //tabNouvelleSignalee = accueilNouvelleDao.getAllSignaledNouvelle();

        request.setAttribute("test", tabNouvelle);

        if (util != null) {
            System.out.println("utilisateur existe");
            System.out.println(util.getidProfil());
            if (util.getidProfil() == 0) {

                this.getServletContext().getRequestDispatcher(Accueil).forward(request, response);

                System.out.println("utilisateur est un inscrit");
            } else if (util.getidProfil() == 1) {
                //this.getServletContext().getRequestDispatcher(Accueil).forward(request, response);
                this.getServletContext().getRequestDispatcher(AccueilAdmin).forward(request, response);
                System.out.println("utilisateur est un admin");
            }
        } else {
            System.out.println("utilisateur inconnu, retour page connexion");
            this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
        }

    }
}
