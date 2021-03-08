/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Profil;
import beans.Utilisateur;
import static dao.DAO.connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class ProfilDAO implements DAO<Profil> {

    private final String PROFIL = "profil";

    @Override
    public List<Profil> getAll() {
        ArrayList profil = new ArrayList();
        try {
            if (connection != null) {
                Statement stmt = connection.createStatement();
                String req_profil = "SELECT * FROM " + PROFIL;
                ResultSet res_profil = stmt.executeQuery(req_profil);
                while (res_profil.next()) {
                    profil.add(new Profil(res_profil.getInt("idProfil"),
                            (res_profil.getString("libelleProfil"))));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return profil;
    }

    @Override
    public Profil find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Profil e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Profil e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
