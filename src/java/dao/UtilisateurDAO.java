/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Utilisateur;
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
public class UtilisateurDAO implements DAO<Utilisateur> {

    private final String TABLE = "utilisateur";

    @Override
    public List<Utilisateur> getAll() {
        ArrayList lUtilisateur = new ArrayList();
        try {
            if (connection != null) {
                Statement stmt = connection.createStatement();
                String req_utilisateur = "SELECT * FROM " + TABLE;
                ResultSet res_utilisateur = stmt.executeQuery(req_utilisateur);
                while (res_utilisateur.next()) {
                    lUtilisateur.add(new Utilisateur(res_utilisateur.getInt("id"),
                            res_utilisateur.getString("mail"),
                            res_utilisateur.getString("pseudo"),
                            res_utilisateur.getString("motdepasse"),
                    res_utilisateur.getInt("idProfil")));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lUtilisateur;
    }

    @Override
    public Utilisateur find(Integer id) {

        Utilisateur utilisateur = null;

        try {
            String req = "SELECT * FROM " + TABLE + " WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(req);
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.first()) {
                utilisateur = new Utilisateur(id, result.getString("mail"),
                        result.getString("pseudo"),
                        result.getString("motdepasse")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return utilisateur;

    }

    @Override
    public void create(Utilisateur u) {

        try {
            String req = "INSERT INTO " + TABLE + "(mail, pseudo, motdepasse, idProfil) VALUES ( ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(req);
            pstmt.setString(1, u.getMail());
            pstmt.setString(2, u.getPseudo());
            pstmt.setString(3, u.getMotdepasse());
            pstmt.setInt(4, u.getidProfil());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Utilisateur u) {

        try {
            String req = "UPDATE " + TABLE + " SET mail=?, pseudo=?, motdepasse=?, statutUtilisateur=? WHERE id=?";
            PreparedStatement pstmt = connection.prepareStatement(req);
            pstmt.setString(1, u.getMail());
            pstmt.setString(2, u.getPseudo());
            pstmt.setString(3, u.getMotdepasse());
            // pstmt.setInt(4, u.getStatutUtilisateur());
            pstmt.setInt(5, u.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NouvelleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList recherchelistpseudo() {

        ArrayList listepseudo = new ArrayList();
        try {
            if (connection != null) {
                Statement stmt = connection.createStatement();
                String req_utilisateur = "SELECT pseudo FROM utilisateur";
                ResultSet res_utilisateur = stmt.executeQuery(req_utilisateur);
                while (res_utilisateur.next()) {
                    String pseudos = res_utilisateur.getString("pseudo");
                    listepseudo.add(pseudos);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listepseudo;

    }

    public Utilisateur rechercheParMail(String mail) {
      System.out.println("Mail saisi par l'utilisateur: " + mail);//affiche console login tapé

        try { //appel méthode singleton getInstance() de SQLConnection  car  connection = SQLConnection.getInstance();
            //Statement = connection.createStatement();//createStatement servant à envoyer des instructions SQL à la base de données
          Statement stmt = connection.createStatement();
            //ResultSet contient les résultats de la requête
            ResultSet res = stmt.executeQuery("SELECT * FROM utilisateur WHERE mail = '" + mail + "'"); //Requête pour obtenir un utilsateur par le mail 
            //ce mail est passé en parametre, on obtient les champs "Utilisateur" de ce mail
            if (res.next()) { //Renvoie true s'il existe un résultat, prépare le traitement de la ligne, curseur passe ligne suivante
                Utilisateur utilisateur = new Utilisateur(//création d'un nouvel utilisateur avec récupération des champs

                        res.getInt("id"), res.getString("mail"), res.getString("pseudo"), res.getString("motdepasse"), res.getInt("idProfil"));
                //String motdepass = res.getString("motdepasse");
                stmt.close(); //Ferme la connection à la base de données
                return utilisateur;//retourne un utilisateur avec tous ses champs - "private Utilisateur"     
            } else {
                return null;//retourne aucun utilisateur
            }
        } catch (SQLException ex) {
            System.err.println(ex);//indique les erreurs de la connection
        }
        return null;//retourne aucune connection    
    }

    public Utilisateur rechercheParPseudo(String pseudo) {
        System.out.println("Pseudo saisi par l'utilisateur: " + pseudo);//affiche console login tapé

        try { //appel méthode singleton getInstance() de SQLConnection  car  connection = SQLConnection.getInstance();
            //Statement = connection.createStatement();//createStatement servant à envoyer des instructions SQL à la base de données
            Statement stmt = connection.createStatement();
            //ResultSet contient les résultats de la requête
            ResultSet res = stmt.executeQuery("SELECT * FROM utilisateur WHERE pseudo = '" + pseudo + "'"); //Requête pour obtenir un utilsateur par le mail 
            //ce mail est passé en parametre, on obtient les champs "Utilisateur" de ce mail
            if (res.next()) { //Renvoie true s'il existe un résultat, prépare le traitement de la ligne, curseur passe ligne suivante
                Utilisateur utilisateur = new Utilisateur(//création d'un nouvel utilisateur avec récupération des champs

                        res.getInt("id"), res.getString("mail"), res.getString("pseudo"), res.getString("motdepasse"), res.getInt("idProfil"));
                //String motdepass = res.getString("motdepasse");
                stmt.close(); //Ferme la connection à la base de données
                return utilisateur;//retourne un utilisateur avec tous ses champs - "private Utilisateur"     
            } else {
                return null;//retourne aucun utilisateur
            }
        } catch (SQLException ex) {
            System.err.println(ex);//indique les erreurs de la connection
        }
        return null;//retourne aucune connection    
    }

    public Utilisateur rechercheParMotDePasse(String motdepasse) {
    System.out.println("Mot de passe saisi par l'utilisateur: " + motdepasse);//affiche console login tapé

        try { //appel méthode singleton getInstance() de SQLConnection  car  connection = SQLConnection.getInstance();
            //Statement = connection.createStatement();//createStatement servant à envoyer des instructions SQL à la base de données
            Statement stmt = connection.createStatement();
            //ResultSet contient les résultats de la requête
            ResultSet res = stmt.executeQuery("SELECT * FROM utilisateur WHERE motdepasse = '" + motdepasse + "'"); //Requête pour obtenir un utilsateur par le mail 
            //ce mail est passé en parametre, on obtient les champs "Utilisateur" de ce mail
            if (res.next()) { //Renvoie true s'il existe un résultat, prépare le traitement de la ligne, curseur passe ligne suivante
                Utilisateur utilisateur = new Utilisateur(//création d'un nouvel utilisateur avec récupération des champs

                        res.getInt("id"), res.getString("mail"), res.getString("pseudo"), res.getString("motdepasse"), res.getInt("idProfil"));
                //String motdepass = res.getString("motdepasse");
                stmt.close(); //Ferme la connection à la base de données
                return utilisateur;//retourne un utilisateur avec tous ses champs - "private Utilisateur"     
            } else {
                return null;//retourne aucun utilisateur
            }
        } catch (SQLException ex) {
            System.err.println(ex);//indique les erreurs de la connection
        }
        return null;//retourne aucune connection    
    }

}
