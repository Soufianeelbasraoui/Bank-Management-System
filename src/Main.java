import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank maBanque=new Bank();
        Scanner s=new Scanner(System.in);
        while (true){
          try {
              System.out.println("\n----- SYSTEME DE GESTION BANCAIRE -----");
              System.out.println("1.Ajouter un client: ");
              System.out.println("2.Créer un compte bancaire:");
              System.out.println("3.Déposer de l’argent: ");
              System.out.println("4.Retirer de l’argent: ");
              System.out.println("5.Afficher les comptes: ");
              System.out.println("6.Consulter le solde: ");
              System.out.println("7.Creer un Compte épargne ");
              System.out.println("8.Supprimer un compte: " );
              System.out.println("9.Transfert d’argent entre comptes");
              System.out.println("10.Quitter le programe: ");
              System.out.println("Choisissez une option : ");

              int choix = s.nextInt();
              if (choix == 10) {
                  System.out.println(" Au revoir !");
                  break;
              }
              switch (choix){
                  case 1:
                      System.out.println("Nom: ");
                      String nom = s.next();
                      System.out.print("Numéro client : ");
                      String clientNumber = s.next();
                      Client cln = maBanque.chercherClient(clientNumber);

                      if (cln == null) {
                          maBanque.ajouterClients(new Client(nom, clientNumber));
                          System.out.println("Client ajouté avec succès");
                      } else {
                          System.out.println("Le client existe déjà");
                      }
                      break;


                  case 2:
                      System.out.print("Numero client : ");
                      String cl = s.next();
                      Client client = maBanque.chercherClient(cl);
                      if (client != null) {
                          System.out.print("Numéro compte : ");
                          String acc = s.next();
                          Account account = maBanque.findAccount(acc);
                          if (account == null) {
                              System.out.print("Solde initial : ");
                              double solde = s.nextDouble();
                              if (solde > 0) {
                                  maBanque.ajouterCompt(new Account(acc, solde, cl));
                                  System.out.println("Compte créé avec succès !");
                              } else {
                                  System.out.println("Le solde initial doit être positif !");
                              }
                          } else {
                              System.out.println("Le compte existe déjà !");
                          }
                      } else {
                          System.out.println("Client introuvable !");
                      }
                      break;

                  case 3:
                      System.out.print("Numero de compte pour Déposer : ");
                      Account depo=maBanque.findAccount(s.next());
                      if (depo !=null){
                          System.out.print("Montant a deposer : ");
                          depo.deposer(s.nextDouble());
                      }else {
                          System.out.println("Compte introuvable.");
                      }
                      break;

                  case 4:
                      System.out.println("Numero de compte pour Retirer: ");
                      Account accRetrait = maBanque.findAccount(s.next());
                      if (accRetrait != null) {
                          System.out.print("Montant à retirer : ");
                          accRetrait.retirer(s.nextDouble());
                      } else {
                          System.out.println("Compte introuvable!");
                      }
                      break;


                  case 5:
                      maBanque.afficherLesComptes();
                      break;

                  case 6:
                      System.out.print("Numéro compte : ");
                      String ac = s.next();
                      Account consulter=maBanque.findAccount(ac);
                      if (consulter !=null){
                          consulter.consulterSolde();
                      }
                      else {
                        System.out.println("Compte introuvable!");
                      }
                      break;

                  case 7:
                      System.out.println("Numero de client: ");
                      String nCl=s.next();
                      Client client1=maBanque.chercherClient(nCl);
                      if (client1 !=null){
                          System.out.println("Numero Compte: ");
                          String nAcc=s.next();
                           Account account=maBanque.findAccount(nAcc);
                           if (account == null){
                               System.out.println("Solde initial: ");
                               double sd=s.nextDouble();
                               System.out.println("taux d’intérêt: ");
                               double tauxsd=s.nextDouble()/100;
                               SavingsAccount sav=new SavingsAccount(nAcc,sd,nCl,tauxsd);
                               maBanque.ajouterCompt(sav);
                               System.out.println("le Compte  epargne cree avec succes  ");
                           }
                           else {
                               System.out.println("le compte deja existe");
                           }
                      }
                      else {
                          System.out.println("le compte n'est pas trouver!");
                      }
                      break;

                  case 8:
                      System.out.print("Numero du compte a supprimer : ");
                      String numCompte = s.next();
                      maBanque.supprimerCompt(numCompte);
                      break;
                  case 9:
                      System.out.println("Enter Numero du compte source: ");
                      String ncs=s.next();
                      System.out.println("Enter Numero du compte destination: ");
                      String ncd=s.next();
                      System.out.println("le Montant Transfer: ");
                      double mnt=s.nextDouble();
                      maBanque.transfertDargent(ncs,ncd,mnt);
                      break;

                  default:
                      System.out.println("Choix invalide !");

              }

          }catch (Exception e){
              System.out.println("Erreur : "+"le choix invalide!");
              s.nextLine();
          }
        }


    }
}
