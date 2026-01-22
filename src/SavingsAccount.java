import java.util.List;

public class SavingsAccount extends Account {
    private double  interestRate;

    public SavingsAccount(String accountNumber, double solde, String clientNumber,double interestRate) {
        super(accountNumber, solde, clientNumber);
        this.interestRate = interestRate;
    }

    //calcul Interest
    public void calculInterest() {
        double interest = getSolde() * interestRate;
        setSolde(getSolde() + interest);
        System.out.println("Des intérêts d'une valeur de " + interest + " ont été ajoutés. Nouveau solde : " + getSolde());
    }


    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
