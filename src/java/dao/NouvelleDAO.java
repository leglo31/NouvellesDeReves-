/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Nouvelle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Timestamp;


/**
 *
 * @author Laurent
 */
public class NouvelleDAO implements DAO<Nouvelle> {

    private final String TABLE = "nouvelle";

    @Override
    public List<Nouvelle> getAll() {
        ArrayList lNouvelle = new ArrayList();
        try {
            if (connection != null) {
                Statement stmt = connection.createStatement();
                String req_nouvelle = "SELECT * FROM " + TABLE;
                ResultSet res_nouvelle = stmt.executeQuery(req_nouvelle);
                while (res_nouvelle.next()) {
                    lNouvelle.add(new Nouvelle(res_nouvelle.getInt("id"),
                            res_nouvelle.getInt("idUtilisateur"),
                            res_nouvelle.getString("titre"),
                            res_nouvelle.getString("contenu"),                          
                            res_nouvelle.getString("auteur"),
                            res_nouvelle.getTimestamp("dateCreation")));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NouvelleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lNouvelle;
    }

    @Override
    public Nouvelle find(Integer id) {

        Nouvelle nouvelle = null;

        try {
            String req = "SELECT * FROM " + TABLE + " WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(req);
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.first()) {
                nouvelle = new Nouvelle(id, result.getString("titre"),
                        result.getString("contenu"),
                        result.getInt("idUtilisateur"),
                        result.getString("auteur"),
                        result.getTimestamp("dateCreation"),
                        result.getInt("statutNouvelle"),
                        result.getInt("nbVotePositif"),
                        result.getInt("nbVoteNegatif"),
                        result.getInt("score"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(NouvelleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nouvelle;

    }

    @Override
    public void create(Nouvelle n) {

        try {
            String req = "INSERT INTO " + TABLE + "(idUtilisateur, titre, contenu, auteur) VALUES ( ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(req);
            pstmt.setInt(1, n.getIdUtilisateur());
            pstmt.setString(2, n.getTitre());
            pstmt.setString(3, n.getContenu());
          
            pstmt.setString(4, n.getauteur());
           //pstmt.setTimestamp(4, n.getDateCreation());
//            pstmt.setInt(6, n.getStatutNouvelle());
//            pstmt.setInt(7, n.getNbVotePositif());
//            pstmt.setInt(8, n.getNbVoteNegatif());
//             pstmt.setInt(9, n.getscore());
           pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NouvelleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//      @Override
//    public Novel create(Novel obj) {
//        try {
//            String req = "INSERT INTO " + TABLE
//                    + " (id_user, title, teaser, content, flag) VALUES(?, ?, ?, ?, ?)";
//            PreparedStatement pstmt = CONNECTION.prepareStatement(
//                    req, Statement.RETURN_GENERATED_KEYS);
//            pstmt.setInt(1, obj.getId_user());
//            pstmt.setString(2, obj.getTitle());
//            pstmt.setString(3, obj.getTeaser());
//            pstmt.setString(4, obj.getContent());
//            pstmt.setInt(5, obj.getFlag());
//
//            // On soumet la requête et on récupère le nombre de lignes créées
//            int lines = pstmt.executeUpdate();
//            // On récupère un ResulSet contenant toutes les clés générées
//            // Ici une seule, évidemment
//            ResultSet rs = pstmt.getGeneratedKeys();
//            int last_inserted_id;
//            if (rs.first()) { // Si on a des id créés on lit le premier
//                last_inserted_id = rs.getInt(1);
//                // On pense à ajouter l'id à l'objet passé en paramètre...
//                obj.setId(last_inserted_id);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(NovelDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return obj;
//    }
    
    @Override
    public void delete(Integer id) {
        try {
            String req = "DELETE FROM " + TABLE + " WHERE id=?";
            PreparedStatement pstmt = connection.prepareStatement(req);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NouvelleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Nouvelle n) {

        try {
            String req = "UPDATE " + TABLE + " SET titre=?, contenu=?, statutNouvelle=?, nbVotePositif=?, nbVoteNegatif=? WHERE id=?";
            PreparedStatement pstmt = connection.prepareStatement(req);
            pstmt.setString(1, n.getTitre());
            pstmt.setString(2, n.getContenu());
            pstmt.setInt(3, n.getStatutNouvelle());
            pstmt.setInt(4, n.getNbVotePositif());
            pstmt.setInt(5, n.getNbVoteNegatif());
            pstmt.setInt(6, n.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NouvelleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Nouvelle> get10LastDescOrder() {
        ArrayList lNouvelle = new ArrayList();
        try {
            if (connection != null) {
                Statement stmt = connection.createStatement();
                String req_nouvelle = "SELECT * FROM " + TABLE + " ORDER BY dateCreation DESC LIMIT 10";
                ResultSet res_nouvelle = stmt.executeQuery(req_nouvelle);
                while (res_nouvelle.next()) {
                    lNouvelle.add(new Nouvelle(res_nouvelle.getInt("id"),
                            res_nouvelle.getInt("idUtilisateur"),
                            res_nouvelle.getString("titre"),
                            res_nouvelle.getString("contenu"),                         
                            res_nouvelle.getString("auteur"),
                             res_nouvelle.getTimestamp("dateCreation")
                    ));

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NouvelleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lNouvelle;
    }

        public List<Nouvelle> getLastDescOrder() {
        ArrayList lNouvelle = new ArrayList();
        try {
            if (connection != null) {
                Statement stmt = connection.createStatement();
                String req_nouvelle = "SELECT * FROM " + TABLE + " ORDER BY dateCreation DESC LIMIT 1";
                ResultSet res_nouvelle = stmt.executeQuery(req_nouvelle);
                while (res_nouvelle.next()) {
                    lNouvelle.add(new Nouvelle(res_nouvelle.getInt("id"),
                            res_nouvelle.getInt("idUtilisateur"),
                            res_nouvelle.getString("titre"),
                            res_nouvelle.getString("contenu"),                         
                            res_nouvelle.getString("auteur"),
                             res_nouvelle.getTimestamp("dateCreation")
                    ));

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NouvelleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lNouvelle;
    }
        public List<Nouvelle> getOrder() {
        ArrayList lNouvelle = new ArrayList();
        try {
            if (connection != null) {
                Statement stmt = connection.createStatement();
                String req_nouvelle = "SELECT * FROM " + TABLE + " ORDER BY dateCreation DESC ";
                ResultSet res_nouvelle = stmt.executeQuery(req_nouvelle);
                while (res_nouvelle.next()) {
                     lNouvelle.add(new Nouvelle(res_nouvelle.getInt("id"),
                             res_nouvelle.getInt("idUtilisateur"),
                            res_nouvelle.getString("titre"),
                            res_nouvelle.getString("contenu"),                         
                            res_nouvelle.getString("auteur"),
                             res_nouvelle.getTimestamp("dateCreation")
                     ));

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NouvelleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lNouvelle;
    }
//
//    public List<Nouvelle> getAllSignaledNouvelle() {
//        ArrayList lNouvelle = new ArrayList();
//        try {
//            if (connection != null) {
//                Statement stmt = connection.createStatement();
//                String req_nouvelle = "SELECT * FROM " + TABLE + " WHERE statutNouvelle=2";
//                ResultSet res_nouvelle = stmt.executeQuery(req_nouvelle);
//                while (res_nouvelle.next()) {
//                    lNouvelle.add(new Nouvelle(res_nouvelle.getInt("id"),
//                            res_nouvelle.getString("titre"),
//                            res_nouvelle.getString("contenu"),
//                            res_nouvelle.getInt("idUtilisateur"),
//                            res_nouvelle.getString("auteur"),
//                            res_nouvelle.getTimestamp("dateCreation"),
//                            res_nouvelle.getInt("statutNouvelle"),
//                            res_nouvelle.getInt("nbVotePositif"),
//                            res_nouvelle.getInt("nbVoteNegatif"),
//                            res_nouvelle.getInt("score")));
//
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(NouvelleDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return lNouvelle;
//    }
    
     public  String pseudo(Integer id) {
        String pseudos = null;
        try {
            if (connection != null) {
                Statement stmt = connection.createStatement();
               
                String req_nouvelle =("SELECT utilisateur.pseudo FROM utilisateur WHERE id = '" + id + "'");
                ResultSet res_nouvelle = stmt.executeQuery(req_nouvelle);
                while (res_nouvelle.next()) {
                          pseudos = res_nouvelle.getString("pseudo");                           
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NouvelleDAO.class.getName()).log(Level.SEVERE, null, ex);
  
}
        return pseudos;
      
     }    

         
     public  Integer id() {
         Integer idutil = null;
        try {
            if (connection != null) {
                Statement stmt = connection.createStatement();
               
                String req_nouvelle =("SELECT utilisateur.id FROM utilisateur ");
                ResultSet res_nouvelle = stmt.executeQuery(req_nouvelle);
                boolean next = res_nouvelle.next();
{
                          idutil = res_nouvelle.getInt("id");                           
            }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NouvelleDAO.class.getName()).log(Level.SEVERE, null, ex);
  
}
        return idutil;
      
     }  
     
     
     
     
     
}
