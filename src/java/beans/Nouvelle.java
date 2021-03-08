/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.sql.Date;
//import java.sql.Timestamp;
import java.util.Calendar;
import java.sql.Timestamp;

/**
 *
 * @author Quentin Fankrache
 */
public class Nouvelle implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    public String titre;
    private String contenu;
    private Integer idUtilisateur;
    private String auteur;
    public Timestamp dateCreation;
    private Integer statutNouvelle;
    private Integer nbVotePositif;
    private Integer nbVoteNegatif;
    private Integer score;
    public String pseudo;


    public Nouvelle(Integer id, String titre, String contenu, Integer idUtilisateur, String auteur, Timestamp dateCreation, Integer statutNouvelle, Integer nbVotePositif, Integer nbVoteNegatif, Integer score) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        this.idUtilisateur = idUtilisateur;
        this.auteur = auteur;
        this.dateCreation = dateCreation;
        this.statutNouvelle = statutNouvelle;
        this.nbVotePositif = nbVotePositif;
        this.nbVoteNegatif = nbVoteNegatif;
        this.score = score;
    }

    public Nouvelle(Integer id, Integer idUtilisateur, String titre,String contenu,String auteur, Timestamp dateCreation) {
         this.id = id;
        this.titre = titre;
        this.contenu = contenu;     
        this.auteur = auteur;
        this.dateCreation = dateCreation;      
    }

    public Nouvelle(String titre, String contenu, String auteur) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        this.statutNouvelle = statutNouvelle;
        this.score = score;
        this.auteur = auteur;
    }
    
       public Nouvelle(Integer id, Integer idUtilisateur, String titre, String contenu, String auteur) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        this.statutNouvelle = statutNouvelle;
        this.score = score;
        this.auteur = auteur;
    }

    public Nouvelle(Integer idUtilisateur, String titre, String pseudo, String auteur) {
        this.titre = titre;
        this.pseudo = pseudo;
        this.dateCreation = dateCreation;
    }

    public Nouvelle() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Integer getStatutNouvelle() {
        return statutNouvelle;
    }

    public void setStatutNouvelle(Integer statutNouvelle) {
        this.statutNouvelle = statutNouvelle;
    }

    public Integer getNbVotePositif() {
        return nbVotePositif;
    }

    public void setNbVotePositif(Integer nbVotePositif) {
        this.nbVotePositif = nbVotePositif;
    }

    public Integer getNbVoteNegatif() {
        return nbVoteNegatif;
    }

    public void setNbVoteNegatif(Integer nbVoteNegatif) {
        this.nbVoteNegatif = nbVoteNegatif;
    }

    public Integer getscore() {
        return score;
    }

    public void setscore(Integer score) {
        this.score = score;
    }

    public String getauteur() {
        return auteur;
    }

    public void setauteur(String auteur) {
        this.auteur = auteur;
    }

    public String pseudo() {
        return pseudo;
    }

    public void pseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "Nouvelle{" + "id=" + id + ", idUtilisateur=" + idUtilisateur + ", titre=" + titre + ", contenu=" + contenu + ", auteur=" + auteur + '}';
    }

}
