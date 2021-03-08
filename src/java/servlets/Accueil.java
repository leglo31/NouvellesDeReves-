/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Utilisateur;
import dao.NouvelleDAO;
import dao.UtilisateurDAO;
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
 * @author laurent
 */
@WebServlet(name = "Accueil", urlPatterns = {""})
public class Accueil extends HttpServlet {

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

        NouvelleDAO accueilNouvelleDao = new NouvelleDAO();
        List<beans.Nouvelle> tabNouvelle = new ArrayList<>();
        tabNouvelle = accueilNouvelleDao.get10LastDescOrder();
        List<beans.Nouvelle> tabNouvelleSignalee = new ArrayList<>();
        // tabNouvelleSignalee = accueilNouvelleDao.getAllSignaledNouvelle();

        List<beans.Nouvelle> lastNouvelle = new ArrayList<>();
        lastNouvelle = accueilNouvelleDao.getLastDescOrder();
        request.setAttribute("derniere", lastNouvelle);

        request.setAttribute("essai", tabNouvelle);
        // request.setAttribute("pseudo", pseudo);           
//        String pseudo = accueilNouvelleDao.pseudo(id);     
//        UtilisateurDAO utilDao = new UtilisateurDAO();
//        ArrayList listepseudo = new ArrayList();
//        listepseudo = utilDao.recherchelistpseudo();

        //request.setAttribute("titi", listepseudo);
        // request.setAttribute("nouvellesSignalees", tabNouvelleSignalee);
        this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);

        /**
         * Handles the HTTP <code>POST</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
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

}
