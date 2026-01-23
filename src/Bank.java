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
    //methode supprimer un compte
    public void supprimerCompt(String acNum) {
        Account compteSupprimer = findAccount(acNum);
        if (compteSupprimer != null) {
            if (compteSupprimer.getSolde() > 0) {
                System.out.println("impossible de supprimer le compte : solde non nul ("+ compteSupprimer.getSolde() + ")");
            } else {
                accounts.remove(compteSupprimer);
                System.out.println("compte supprimé avec succès !");
            }
        } else {
            System.out.println("Le compte n'existe pas !");
        }
    }

    // methode Transfert d’argent entre comptes
    public void transfertDargent(String sourceNum, String dstNum, double montant) {
        Account Comptesource = findAccount(sourceNum);
        Account compteDst = findAccount(dstNum);
        if (Comptesource == null || compteDst == null) {
            System.out.println("Le compte source ou le compte destination est introuvable !");
            return;
        }
        if (montant <= 0) {
            System.out.println("Le montant doit être positif !");
            return;
        }
        if (montant > Comptesource.getSolde()) {
            System.out.println("Solde insuffisant !");
            return;
        }

        Comptesource.retirer(montant);
        compteDst.deposer(montant);

        System.out.println("Transfert effectué avec succès !");
    }

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
 //methode chercher de client
    public Client chercherClient(String clientNumber) {
        for (Client c : clients) {
            if (c.getClientNumber().equals(clientNumber)) {
                return c;
            }
        }
        return null;
    }
//methode chercher Account
    public Account findAccount(String numero) {
        for (Account a : accounts) {
            if (a.getAccountNumber().equals(numero)) {
                return a;
            }
        }
        return null;
    }

}
