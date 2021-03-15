/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Utilisateur;
import dao.CommentaireDAO;
import java.io.IOException;
import dao.NouvelleDAO;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;

/**
 *
 * @author Laurent
 */
@WebServlet("/nouvelle")
public class Nouvelle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // création d'une dao Nouvelle
        NouvelleDAO ndao = new NouvelleDAO();
        List<beans.Nouvelle> listeNouvelle = new ArrayList<>();
        listeNouvelle = ndao.getOrder();
        request.setAttribute("nouvelle", listeNouvelle);
        

        this.getServletContext()
                .getRequestDispatcher("/WEB-INF/nouvelle.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
