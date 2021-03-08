/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author Quentin Fankrache
 */
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;

    public Integer id;
    public String mail;
    public String pseudo;
    private String motdepasse;
    private int idProfil;

    public Utilisateur(Integer id, String mail, String pseudo, String motdepasse, int idProfil) {
        this.id = id;
        this.mail = mail;
        this.pseudo = pseudo;
        this.motdepasse = motdepasse;
        this.idProfil = idProfil;
    }

    public Utilisateur(Integer id, String mail, String pseudo, String motdepasse) {
        this.id = id;
        this.mail = mail;
        this.pseudo = pseudo;
        this.motdepasse = motdepasse;
        //this.statutUtilisateur = 1;
    }

    public Utilisateur(String mail, String pseudo, String motdepasse) {

        this.mail = mail;
        this.pseudo = pseudo;
        this.motdepasse = motdepasse;
        //this.statutUtilisateur = 1;
    }

    public Utilisateur(String mail, String motdepasse) {
        this.mail = mail;
        this.motdepasse = motdepasse;
    }

    public Utilisateur(String mail) {
        this.mail = mail;
    }

    public Utilisateur() {
    }

    public Utilisateur(String mail, String motDePasse, int idProfil) {

        this.mail = mail;

        this.motdepasse = motdepasse;
        this.idProfil = idProfil;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public Integer getidProfil() {
        return idProfil;
    }

    public void setidProfil(Integer statutUtilisateur) {
        this.idProfil = idProfil;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", mail=" + mail + ", pseudo=" + pseudo + ", motdepasse=" + motdepasse + " ,idProfil=" + idProfil + '}';
    }

}
