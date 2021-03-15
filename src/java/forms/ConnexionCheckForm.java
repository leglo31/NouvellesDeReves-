/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import beans.Utilisateur;
import dao.UtilisateurDAO;
import exceptions.FormException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Laurent
 */
public class ConnexionCheckForm {

    
    private static final String CHAMP_EMAIL = "mail";
    private static final String CHAMP_PASS = "motdepasse";
    private String resultat;
    private final Map<String, String> erreurs = new HashMap<>();
    UtilisateurDAO u = new UtilisateurDAO();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Utilisateur checkForm(HttpServletRequest request) {
        /* Récupération des champs du formulaire */
        
        String mail = getValeurChamp(request, CHAMP_EMAIL);
        String motDePasse = getValeurChamp(request, CHAMP_PASS);

        Utilisateur utilisateur = new Utilisateur(mail, motDePasse);
        utilisateur.setMail(mail);
        utilisateur.setMotdepasse(motDePasse);
        
        utilisateur = u.rechercheParMail(mail);
        System.out.println("->-<-<utilsateur = " + utilisateur);

        /* Validation du champ email. */
        try {
            validationEmail(mail);
        } catch (Exception e) {
            setErreur(CHAMP_EMAIL, e.getMessage());
        }
//        try {
//            checkString(mail);
//        } catch (Exception e) {
//            setErreur(CHAMP_EMAIL, e.getMessage());
//        }

        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse(motDePasse);
            validationMailetMdp(mail, motDePasse);
        } catch (Exception e) {
            setErreur(CHAMP_PASS, e.getMessage());
        }
        
        /* Initialisation du résultat global de la validation. */
        if (erreurs.isEmpty()) {
            resultat = "Succès de la connexion.";
             return utilisateur;
        } else {
            resultat = "Échec de la connexion.";
        }
      
return null;
    }

    /**
     * Valide l'adresse email saisie.
     */
    private void validationEmail(String mail) throws Exception {
        Utilisateur utilisateur = u.rechercheParMail(mail);
        char currentCharacter;
        boolean upperCasePresent = false;
        System.out.println("+++");
        System.out.println(utilisateur);
        System.out.println("+++");
        // System.out.println(utilisateur);
        if (mail == null) {
            System.out.println("erreur");
            throw new Exception("Merci de saisir une adresse mail.");
        } else if (!mail.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
            throw new Exception("Merci de saisir une adresse mail valide.");
        } else if (utilisateur == null) {
            System.out.println("L'adresse mail n'existe pas.");
            throw new Exception("L'adresse mail n'existe pas, veuillez saisir une adresse mail valide.");
        }
        for (int i = 0; i < mail.length(); i++) {
            currentCharacter = mail.charAt(i);
            if (Character.isUpperCase(currentCharacter)) {
                upperCasePresent = true;
                throw new Exception("pas de majuscule svp.");
            }
        }

    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validationMotDePasse(String motDePasse) throws Exception {
        Utilisateur utilisat = u.rechercheParMotDePasse(motDePasse);
        System.out.println("---");
        System.out.println(utilisat);
        System.out.println("---");
        if (motDePasse == null) {
            throw new Exception("merci de saisir un mot de passe");
        } else if (motDePasse != null) {
            if (motDePasse.length() < 3) {
                throw new Exception("Le mot de passe doit contenir au moins 3 caractères.");
            } else if (utilisat == null) {
                System.out.println("Mot de passe incorrect.");
                throw new Exception("Mot de passe incorrect");
            }
        }
    }

    private void validationMailetMdp(String mail, String motDePasse) throws Exception {
        Utilisateur utilisateur = u.rechercheParMail(mail);
        Utilisateur utilisat = u.rechercheParMotDePasse(motDePasse);
        if (!utilisateur.getMotdepasse().equals(utilisat.getMotdepasse())) {
            System.out.println("*************");
            System.out.println(utilisateur.getMotdepasse());
            System.out.println(utilisat.getMotdepasse());
            System.out.println("*************");

            System.out.println("Mot de passe invalide.");
            throw new Exception("Mot de passe invalide, réessayez!");
        }
    }

    /*
   * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur(String champ, String message) {
        erreurs.put(champ, message);
    }

    /*
   * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
   * sinon.
     */
    private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);
        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        } else {
            return valeur;
        }
    }
}
