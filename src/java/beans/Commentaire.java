/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author Laurent
 */
public class Commentaire implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String commentaire;
    private Timestamp dateCreation;
    private Integer statutCommentaire;
    private Integer idNouvelle;
    private Integer idUtilisateur;

    public Commentaire(Integer id, String commentaire, Timestamp dateCreation, Integer statutCommentaire, Integer idNouvelle, Integer idUtilisateur) {
        this.id = id;
        this.commentaire = commentaire;
        this.dateCreation = dateCreation;
        this.statutCommentaire = statutCommentaire;
        this.idNouvelle = idNouvelle;
        this.idUtilisateur = idUtilisateur;
    }

    public Commentaire(String commentaire, Integer statutCommentaire, Integer idNouvelle, Integer idUtilisateur) {
        this.commentaire = commentaire;
        this.dateCreation = getCurrentTimeDate();
        this.statutCommentaire = statutCommentaire;
        this.idNouvelle = idNouvelle;
        this.idUtilisateur = idUtilisateur;
    }

    public Commentaire(Integer id, String commentaire, Integer statutCommentaire) {
        this.id = id;
        this.commentaire = commentaire;
        this.statutCommentaire = statutCommentaire;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Integer getStatutCommentaire() {
        return statutCommentaire;
    }

    public void setStatutCommentaire(Integer statutCommentaire) {
        this.statutCommentaire = statutCommentaire;
    }

    public Integer getIdNouvelle() {
        return idNouvelle;
    }

    public void setIdNouvelle(Integer idNouvelle) {
        this.idNouvelle = idNouvelle;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", commentaire=" + commentaire + ", dateCreation=" + dateCreation + ", statutCommentaire=" + statutCommentaire + ", idNouvelle=" + idNouvelle + ", idUtilisateur=" + idUtilisateur + '}';
    }

    public Timestamp getCurrentTimeDate() {

        Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        return currentTimestamp;
    }
}
