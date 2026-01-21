import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Client> clients = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();

    //methode ajouter Client
    public  void ajouterClients(Client c){
        clients.add(c);
    }

    //methode Ajouter un compte
    public void ajouterCompt(Account a){
        accounts.add(a);
    }
    // ethode supprimer un compte
    public void supprimerCompt(String acNum) {
        Account comptSupprimer = findAccount(acNum);
        if (comptSupprimer != null) {
         accounts.remove(comptSupprimer);
         System.out.println("Compte supprimé !");
        } else {
         System.out.println("Le compte n'existe pas !");
        }
    }

    //methode afficher Les Comptes
//   public void afficherLesComptes() {
//        for (Client c : clients) {
//            for (Account a : accounts) {
//                if (a.getClientNumber().equals(c.getClientNumber())) {
//                    System.out.println("Client: " + c.getNom() + " | Compte: " + a.getAccountNumber() + " | Solde: " + a.getSolde());
//                }
//            }
//        }
//    }
    // methode afficher les comptes
    public void afficherLesComptes() {
        for (Client c : clients) {
            for (Account a : accounts) {
                if (a.getClientNumber().equals(c.getClientNumber())) {
                    String typeCompte;
                    if (a instanceof SavingsAccount) {
                        typeCompte = "Compte Epargne";
                    } else {
                        typeCompte = "Compte Courant";
                    }

                    System.out.println(
                            "Client: " + c.getNom() + " | Type: " + typeCompte + " | Compte: " + a.getAccountNumber() + " | Solde: " + a.getSolde());
                }
            }
        }
    }



    public Client chercherClient(String clientNumber) {
        for (Client c : clients) {
            if (c.getClientNumber().equals(clientNumber)) {
                return c;
            }
        }
        return null;
    }

    public Account findAccount(String numero) {
        for (Account a : accounts) {
            if (a.getAccountNumber().equals(numero)) {
                return a;
            }
        }
        return null;
    }

}
