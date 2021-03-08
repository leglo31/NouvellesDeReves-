/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Commentaire;
import beans.Nouvelle;
import static dao.DAO.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quentin Fankrache
 */
public class CommentaireDAO implements DAO<Commentaire> {

    private final String TABLE = "commentaire";

    @Override
    public List<Commentaire> getAll() {
        ArrayList lCommentaire = new ArrayList();
        try {
            if (connection != null) {
                Statement stmt = connection.createStatement();
                String req_commentaire = "SELECT * FROM " + TABLE;
                ResultSet res_commentaire = stmt.executeQuery(req_commentaire);
                while (res_commentaire.next()) {
                    lCommentaire.add(new Commentaire(res_commentaire.getInt("id"),
                            res_commentaire.getString("commentaire"),
                            res_commentaire.getTimestamp("dateCreation"),
                            res_commentaire.getInt("statutCommentaire"),
                            res_commentaire.getInt("idNouvelle"),
                            res_commentaire.getInt("idUtilisateur")));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lCommentaire;
    }

    @Override
    public Commentaire find(Integer id) {

        Commentaire commentaire = null;

        try {
            String req = "SELECT * FROM " + TABLE + " WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(req);
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.first()) {
                commentaire = new Commentaire(id, result.getString("commentaire"),
                        result.getTimestamp("dateCreation"),
                        result.getInt("statutCommentaire"),
                        result.getInt("idNouvelle"),
                        result.getInt("idUtilisateur"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return commentaire;

    }

    @Override
    public void create(Commentaire c) {

        try {
            String req = "INSERT INTO " + TABLE + "(commentaire, dateCreation, statutCommentaire, idNouvelle, idUtilisateur) VALUES ( ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(req);
            pstmt.setString(1, c.getCommentaire());
            pstmt.setTimestamp(2, c.getDateCreation());
            pstmt.setInt(3, c.getStatutCommentaire());
            pstmt.setInt(4, c.getIdNouvelle());
            pstmt.setInt(5, c.getIdUtilisateur());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            String req = "DELETE FROM " + TABLE + " WHERE id=?";
            PreparedStatement pstmt = connection.prepareStatement(req);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Commentaire c) {

        try {
            String req = "UPDATE " + TABLE + " SET commentaire=?, statutCommentaire=? WHERE id=?";
            PreparedStatement pstmt = connection.prepareStatement(req);
            pstmt.setString(1, c.getCommentaire());
            pstmt.setInt(2, c.getStatutCommentaire());
            pstmt.setInt(3, c.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // une méthode pour récupérer les commentaires liés à une nouvelle en particulier
    public List<Commentaire> getAllFor1(Nouvelle n) {
        ArrayList lCommentaire = new ArrayList();
        try {
            if (connection != null) {
                Statement stmt = connection.createStatement();
                String req_commentaire = "SELECT * FROM " + TABLE + " WHERE idNouvelle=" + n.getId() + " ORDER BY dateCreation DESC";
                ResultSet res_commentaire = stmt.executeQuery(req_commentaire);
                while (res_commentaire.next()) {
                    lCommentaire.add(new Commentaire(res_commentaire.getInt("id"),
                            res_commentaire.getString("commentaire"),
                            res_commentaire.getTimestamp("dateCreation"),
                            res_commentaire.getInt("statutCommentaire"),
                            res_commentaire.getInt("idNouvelle"),
                            res_commentaire.getInt("idUtilisateur")));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lCommentaire;
    }
}
