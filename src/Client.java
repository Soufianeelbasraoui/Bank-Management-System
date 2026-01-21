import java.util.List;

public class Client extends Person {

    private String clientNumber;



    public Client( String nom, String clientNumber) {
        super( nom);

        this.clientNumber = clientNumber;

    }


    public String getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }
}
