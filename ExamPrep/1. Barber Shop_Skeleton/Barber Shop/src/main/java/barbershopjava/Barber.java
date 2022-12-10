package barbershopjava;

import java.util.ArrayList;
import java.util.List;

public class Barber {

    public String name;
    public int haircutPrice;
    public int stars;
    public List<Client> clients;

    public Barber(String name, int haircutPrice, int stars) {
        this.name = name;
        this.haircutPrice = haircutPrice;
        this.stars = stars;
        this.clients = new ArrayList<>();
    }


    public List<Client> getClients() {
        return clients;
    }
}
