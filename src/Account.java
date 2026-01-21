public class Account {
    private String accountNumber;
    private double solde;
    private String clientNumber;

    public Account(String accountNumber, double solde, String clientNumber) {
        this.accountNumber = accountNumber;
        this.solde = solde;
        this.clientNumber = clientNumber;
    }

    // methode Déposer
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("le montant Déposer " + montant + " effectué. Solde actuel " + solde);
        }
    }

    // methode Retirer
    public void retirer(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            System.out.println("le Retirer de " + montant + " effectué. Solde restant " + solde);
        } else {
            System.out.println("Echec de l'opération : solde insuffisant ou montant invalide.");
        }
    }

    // methode consulter le Solde
    public void consulterSolde() {
        System.out.println("Le solde du compte n° " + accountNumber + " est de : " + solde);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getSolde() {
        return solde;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }


    public String getClientNumber() {
        return clientNumber;
    }
}
