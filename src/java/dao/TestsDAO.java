/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Commentaire;
import beans.Nouvelle;
import beans.Utilisateur;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Quentin Fankrache
 */
public class TestsDAO {
    
    
     static class DateItem {
        String datetime;

        DateItem(String date) {
            this.datetime = date;
        }
    }

    static class SortByDate implements Comparator<DateItem> {
        @Override
        public int compare(DateItem a, DateItem b) {
            return a.datetime.compareTo(b.datetime);
        }
    }

    public static void main(String[] args) {

         List<DateItem> dateList = new ArrayList<>();
        dateList.add(new DateItem("2020-03-25"));
        dateList.add(new DateItem("2019-01-27"));
        dateList.add(new DateItem("2020-03-26"));
        dateList.add(new DateItem("2020-02-26"));
        Collections.sort(dateList, new SortByDate());
        dateList.forEach(date -> {
            System.out.println(date.datetime);
        });
        
          
        
        /**
         * ******** TESTS NOUVELLE DAO *********
         */
        // création de la dao nouvelle
        NouvelleDAO ndao = new NouvelleDAO();
     
//        Nouvelle nouvelle = ndao.find(17);
//       // System.out.println(nouvelle.titre);
//          System.out.println(nouvelle.dateCreation);
          
          
          ndao.getAll().forEach((a) -> {
            System.out.println(a.dateCreation);
            
   });
//Date date = new Date();
//SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
SimpleDateFormat DateFor = new SimpleDateFormat("EEEE, dd MMMMM yyyy HH:mm");


//String stringDate= DateFor.format(nouvelle.dateCreation);
//System.out.println(stringDate);

}


        
        
        
          //ArrayList listePseudo = new ArrayList();
          
          
   
        //System.out.println(pseudo);
         // Utilisateur u = new Utilisateur();
        // u = nouvelle.getUtilisateur();
         
//forEach((a) -> {;
         // System.out.println(a);
         //});

        // affichage de toutes les occurences de la dao nouvelle avec une boucle for
        /*ndao.getAll().forEach((a) -> {
            System.out.println(a);
            System.out.println("\n\n");
        });*/
 /*ndao.get10LastDescOrder().forEach((a) -> {
            System.out.println(a);
            System.out.println("\n\n");
        });*/
        // affichage d'une occurence spécifique en spécifiant son id
        //System.out.println(ndao.find(2));
        /* création d'un objet Nouvelle puis injection dans la BDD avec la méthode create et affichage dans la console pour vérification
        Nouvelle n = new Nouvelle("ceci est le titre de la nouvelle générée par la méthode", "blablavoilàunenouvelledequalité", 2);
        ndao.create(n);
        System.out.println(ndao.find(3)); */
 // supression de la nouvelle de la BDD dont l'id est 3 puis affichage de toutes les occurences pour vérification
        //ndao.delete(3);
//        ndao.getAll().forEach((a) -> {
//            System.out.println(a);
//            System.out.println("\n\n");
//        }); 
        /**
         * ******** TESTS UTILISATEUR DAO *********
         */
        // création de la dao utilisateur
        UtilisateurDAO udao = new UtilisateurDAO();
         //Utilisateur u = udao.rechercheParMail("charlie.nouvellesdereves@gmail.com");
        Utilisateur u = udao.rechercheParMail("laurent.nouvellesdereves@gmail.com");
        //System.out.println(u);

       
        // affichage de toutes les occurences de la dao utilisateur avec une boucle for
//       udao.getAll().forEach((a) -> {
//               System.out.println(a);
//        System.out.println("\n\n");
//         });
        ///Utilisateur util= udao.find(3);
        //System.out.println(util.pseudo);

        //Nouvelle nouv = ndao.titrepseudo();
        // System.out.println(nouv);
//           
// Utilisateur u = new Utilisateur();
// 
// ArrayList listeUti = new ArrayList();
// listeUti =  udao.recherchelistpseudo();
//        System.out.println(listeUti);
//        
//        
//         System.out.println("xxxxxxxxxx");
//         
//         
//             listeUti.forEach((a) -> {
//            System.out.println(a);
//                 // System.out.println("\n\n");
//        });

       
 /* affichagevm.out.println(udao.find(3));*/
 /* création d'un objet Nouvelle puis injection dans la BDD avec la méthode create et affichage dans la console pour vérification
        Utilisateur u = new Utilisateur("alphonse.nouvellesdereves@gmail.com", "alphonse", "alphonse", 1);
        udao.create(u);
        System.out.println(udao.find(5));*/
        // supression de l'utilisateur de la BDD dont l'id est 5 puis affichage de toutes les occurences pour vérification
        /*       udao.delete(5);
        udao.getAll().forEach((a) -> {
            System.out.println(a);
            System.out.println("\n\n");
        });*/
 /* création d'un utilisateur pour mise à jour de la BDD avec la fonction update.
        Utilisateur u = new Utilisateur(6, "alphonse.nouvellesdereves@gmail.com", "nouveauAlphonse", "alphonse", 1);
        udao.update(u);
        udao.getAll().forEach((a) -> {
            System.out.println(a);
            System.out.println("\n\n");
        });*/
        /**
         * ******* TESTS COMMENTAIRE DAO ********
         */
        // création de la dao commentaire
        //CommentaireDAO cdao = new CommentaireDAO();

        /*affichage de toutes les occurences de la dao commentaire avec une boucle for
        cdao.getAll().forEach((a) -> {
            System.out.println(a);
            System.out.println("\n\n");
        });*/
 /* affichage d'une occurence spécifique en spécifiant son id
        System.out.println(cdao.find(2));*/
        // création d'un objet Commentaire puis injection dans la BDD avec la méthode create et affichage dans la console pour vérification
        /* Commentaire c = new Commentaire("voilà un commentaire généré par la méthode create", 1, 1, 1);
        cdao.create(c);
        System.out.println(cdao.find(3));*/
 /* supression du commentaire de la BDD dont l'id est 5 puis affichage de toutes les occurences pour vérification
        cdao.delete(3);
        cdao.getAll().forEach((a) -> {
            System.out.println(a);
            System.out.println("\n\n");
        });*/
        // création d'un commentaire pour mise à jour de la BDD avec la fonction update.
        /* Commentaire c = new Commentaire(4, "ce commentaire a été modifié par la méthode update", 1);
        cdao.update(c);
        cdao.getAll().forEach((a) -> {
            System.out.println(a);
            System.out.println("\n\n");
        });*/
    }


