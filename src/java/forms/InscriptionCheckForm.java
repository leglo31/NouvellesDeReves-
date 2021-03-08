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
 * @author Quentin Fankrache
 */
public final class InscriptionCheckForm {

    private static final String CHAMP_EMAIL = "mail";
    private static final String CHAMP_PASS = "motdepasse";
    private static final String CHAMP_CONF = "confirmation";
    private static final String CHAMP_PSEUDO = "pseudo";

    UtilisateurDAO u = new UtilisateurDAO();

    private String resultat; // Le résultat global de l'inscription
    private final Map<String, String> erreurs = new HashMap<>(); // Les erreurs du formulaire

    public Utilisateur checkForm(HttpServletRequest request) {
        System.out.println("-------------------------------------------------------");
        System.out.println("bonjour et bienvenue");

        try {
            /* Récupération des champs du formulaire. */
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(InscriptionCheckForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        String mail = request.getParameter(CHAMP_EMAIL);
        String motDePasse = request.getParameter(CHAMP_PASS);
        String confirmation = request.getParameter(CHAMP_CONF);
        String pseudo = request.getParameter(CHAMP_PSEUDO);
        Utilisateur user = new Utilisateur(mail, pseudo, motDePasse);
        user.setMail(mail);
        user.setMotdepasse(motDePasse);
        user.setPseudo(pseudo);

        /* Validation du champ email. */
        try {
            validationEmail(mail);
        } catch (FormException e) {
            erreurs.put(CHAMP_EMAIL, e.getMessage());
        }

        /* Validation des champs mot de passe et confirmation. */
        try {
            validationMotsDePasse(motDePasse, confirmation);
        } catch (FormException e) {
            erreurs.put(CHAMP_PASS, e.getMessage());
        }

        /* Validation du champ pseudo. */
        try {
            validationPseudo(pseudo);
        } catch (FormException e) {
            erreurs.put(CHAMP_PSEUDO, e.getMessage());
        }

        /* Initialisation du résultat global de la validation. */
        if (erreurs.isEmpty()) {
            resultat = "Succès de l'inscription.";
            //S'il n'y a pas d'erreur on retourne un utilisateur
            return user;
        } else {
            resultat = "Échec de l'inscription.";
        }
        return null;

    }

    /* Méthodes outils de validation des champs */
    /**
     * Valide l'adresse mail saisie.
     */
    private void validationEmail(String mail) throws FormException {
        Utilisateur utilisat = u.rechercheParMail(mail);
        System.out.println("//////mail///////");
        System.out.println(utilisat);
        String specialChars = "~`#$%^&** ()-__=+\\|[{]};:'\",<>/?";
        char currentCharacter;
        boolean numberPresent = false;
        boolean upperCasePresent = false;
        // boolean lowerCasePresent = false;
        boolean specialCharacterPresent = false;

//si l'utilisateur n'est pas égale à nul, donc s'il existe
        if (utilisat != null) {
            System.out.println("utilisateur existe");
            throw new FormException("L'adresse mail existe déjà, veuillez saisir une autre adresse mail.");
        } else if (mail != null && mail.length() != 0) {
            if (!mail.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
                throw new FormException("Merci de saisir une adresse mail valide. ex: javabien@super.fr");
            }

        }
        for (int i = 0; i < mail.length(); i++) {
            currentCharacter = mail.charAt(i);
            if (Character.isDigit(currentCharacter)) {
                numberPresent = true;
                throw new FormException("pas de chiffres.");
            } else if (Character.isUpperCase(currentCharacter)) {
                upperCasePresent = true;
                throw new FormException("pas de majuscule svp.");
//        } else if (Character.isLowerCase(currentCharacter)) {
//            lowerCasePresent = true;
            } else if (specialChars.contains(String.valueOf(currentCharacter))) {
                specialCharacterPresent = true;
                throw new FormException("pas de caractères spéciaux");
//            } else {
//                throw new FormException("Merci de saisir une adresse mail.");
//            }
        }
    }}
        //    private static boolean checkString(String input) {
        //        // String specialChars = "~`[email protected]#$%^&** ()-__=+\\|[{]};:'\",<>/?";
        //        String specialChars = "~`#$%^&** ()-__=+\\|[{]};:'\",<>/?";
        //        char currentCharacter;
        //        boolean numberPresent = false;
        //        boolean upperCasePresent = false;
        //        // boolean lowerCasePresent = false;
        //        boolean specialCharacterPresent = false;
        //
        //        for (int i = 0; i < input.length(); i++) {
        //            currentCharacter = input.charAt(i);
        //            if (Character.isDigit(currentCharacter)) {
        //                numberPresent = true;
        //            } else if (Character.isUpperCase(currentCharacter)) {
        //                upperCasePresent = true;
        ////        } else if (Character.isLowerCase(currentCharacter)) {
        ////            lowerCasePresent = true;
        //            } else if (specialChars.contains(String.valueOf(currentCharacter))) {
        //                specialCharacterPresent = true;
        //            }
        //        }
        /**
         * Valide les mots de passe saisis.
         */
    private void validationMotsDePasse(String motDePasse, String confirmation) throws FormException {

        if (motDePasse != null && motDePasse.length() != 0 && confirmation != null && confirmation.length() != 0) {
            if (!motDePasse.equals(confirmation)) {
                throw new FormException("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
            } else if (motDePasse.length() < 3) {
                throw new FormException("Les mots de passe doivent contenir au moins 3 caractères.");
            }
        } else {
            throw new FormException("Merci de saisir et confirmer votre mot de passe.");
        }
    }

    /**
     * Valide le nom d'utilisateur saisi.
     */
    private void validationPseudo(String pseudo) throws FormException {
        Utilisateur util = u.rechercheParPseudo(pseudo);
        System.out.println("//////pseudo///////");
        System.out.println(util);

        if (util != null) {
            System.out.println("Le pseudo de cet utilisateur existe");
            throw new FormException("Le pseudo existe déjà, veuillez saisir un autre pseudo.");

        } else if (pseudo != null && pseudo.length() < 2) {
            throw new FormException("Le pseudo d'utilisateur doit contenir au moins 2 caractères.");
        }
    }

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

}
