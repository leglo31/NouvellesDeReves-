/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Utilisateur;
import dao.NouvelleDAO;
import dao.UtilisateurDAO;
import forms.ConnexionCheckForm;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Laurent
 */
@WebServlet(name = "CreationNouvelle", urlPatterns = {"/creationNouvelle"})
//@WebServlet(name = "CreationNouvelle", urlPatterns = {"/creationNouvelle"})
public final class CreationNouvelle extends HttpServlet {

    private static final String CHAMP_TITRE = "titre";
    private static final String CHAMP_CONTENU = "contenu";
    private static final String CHAMP_IDUTILISATEUR = "idUtilisateur";
    private static final String CHAMP_AUTEUR = "auteur";
//    private static final String CHAMP_STATUTNOUVELLE = "statutNouvelle";
//    private static final String CHAMP_VOTEPOSITIF = "nbVotePositif";
//    private static final String CHAMP_VOTENEGATIF = "nbVoteNegatif";
//    private static final String CHAMP_SCORE = "score";
    private static final String ATT_USER = "utilisateur";
    private static final String CHAMP_EMAIL = "mail";
    private static final String CHAMP_PASS = "motdepasse";
    UtilisateurDAO u = new UtilisateurDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/creationNouvelle.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//récupération de la session de l'utilisateur connecté
        HttpSession session = request.getSession();
        Utilisateur util = new Utilisateur();
        
//récupération de la valeur de l'utilisateur connecté
        util = (Utilisateur) session.getAttribute(ATT_USER);
        System.out.println("l'utilisateur est: " + util);
         System.out.println("l'id de l'utilisateur est: " + util.id);
        
//condition sur console pour vérifier si on récupère bien l'utilisateur connecté sinon affiche pas d'utilisateur
        if (util != null) {
            System.out.println("l'utilisateur est: " + util);
        } else {
            System.out.println("pas d'utilisateur");
        }

        NouvelleDAO ndao = new NouvelleDAO();
        Integer idUtilisateur = util.id ;//l'idUtilisateur de la nouvelle est égale à l'id de l'utilisateur connecté
        //on réinjecte cette valeur dans la requète pour créer la nouvelle avec l'utilisateur connecté
        String titre = request.getParameter(CHAMP_TITRE);
        String contenu = request.getParameter(CHAMP_CONTENU);
        String auteur = request.getParameter(CHAMP_AUTEUR);

        beans.Nouvelle novel = new beans.Nouvelle(idUtilisateur, titre, contenu, auteur);
        novel.setTitre(titre);
        System.out.println(titre);
        novel.setContenu(contenu);
        System.out.println(contenu);
        novel.setauteur(auteur);
        System.out.println(auteur);
        novel.setIdUtilisateur(idUtilisateur);//ici l'idUtilisateur est égale à l'id de l'utilisateur connecté
        System.out.println(idUtilisateur);

        ndao.create(novel);// création de la nouvelle de type (idUtilisateur, titre, contenu, auteur)
        request.setAttribute("creation", novel);
        System.out.println(novel);

        List<beans.Nouvelle> listeNouvelle = new ArrayList<>();
        listeNouvelle = ndao.getOrder();
        request.setAttribute("nouvelle", listeNouvelle);
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/nouvelle.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);
        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        } else {
            return valeur;
        }
    }
}
