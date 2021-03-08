/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Utilisateur;
import dao.UtilisateurDAO;
import exceptions.FormException;
import forms.InscriptionCheckForm;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Quentin Fankrache
 */
@WebServlet(name = "Inscription", urlPatterns = {"/inscription"})
public class Inscription extends HttpServlet {

    /* Des constantes */
    private static final String VUE = "/WEB-INF/inscription.jsp";
    private static final String ATT_FORM = "form";
    private static final String ATT_USER = "user";

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

        /* Affichage de la page d'inscription */
        this.getServletContext()
                .getRequestDispatcher(VUE)
                .forward(request, response);

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

        UtilisateurDAO udao = new UtilisateurDAO();

        // Instancier l'outil métier de vérification du formulaire
        InscriptionCheckForm form = new InscriptionCheckForm();
        // Récupérer le bean Utilisateur qui stocke les données fournies par le client
        Utilisateur user = form.checkForm(request);
// user est le return de la classe InscriptionCheckForm c.à.d un utilisateur qui n'a pas d'erreur dans le formulaire : mail et pseudo

// si cet utilisateur est egale à nul, donc qu'il existe déjà dans la bdd, il ne se passe rien sinon, le système crée l'utilisateur dans la bdd
        if (user == null) {
            System.out.println("utilisateur déja crée");

        } else {
            System.out.println("utilisateur crée");
            
            udao.create(user);
        }

        /* Stockage du résultat et des messages d'erreur dans l'objet request */
        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_USER, user);

        /* Transmission de la paire d'objets request/response à notre JSP */
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
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
