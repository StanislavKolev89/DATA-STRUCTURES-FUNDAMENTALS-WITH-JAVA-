package barbershopjava;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class BarberShopImpl implements BarberShop {

    Map<String, Barber> barbers;
    Map<String, Client> clients;


    public BarberShopImpl() {
        this.barbers = new HashMap<>();
        this.clients = new HashMap<>();
    }

    @Override
    public void addBarber(Barber b) {
        if (barbers.containsKey(b.name)) {
            throw new IllegalArgumentException();
        }
        barbers.put(b.name, b);

    }

    @Override
    public void addClient(Client c) {
        if (clients.containsKey(c.name)) {
            throw new IllegalArgumentException();
        }
        clients.put(c.name, c);

    }

    @Override
    public boolean exist(Barber b) {
        return barbers.containsKey(b.name);
    }

    @Override
    public boolean exist(Client c) {
        return clients.containsKey(c.name);
    }

    @Override
    public Collection<Barber> getBarbers() {
        return this.barbers.values();
    }

    @Override
    public Collection<Client> getClients() {
        return this.clients.values();
    }

    @Override
    public void assignClient(Barber b, Client c) {
        if (!exist(b) || !exist(c)) {
            throw new IllegalArgumentException();
        }
        c.barber = b;
        this.barbers.get(b.name).getClients().add(c);

    }

    @Override
    public void deleteAllClientsFrom(Barber b) {
        if (!exist(b)) {
            throw new IllegalArgumentException();
        }

        this.barbers.get(b.name).clients.clear();

    }

    @Override
    public Collection<Client> getClientsWithNoBarber() {
        return this.clients.values().stream().filter(c -> c.barber == null).collect(Collectors.toList());
    }

    @Override
    public Collection<Barber> getAllBarbersSortedWithClientsCountDesc() {
        if(this.barbers.isEmpty()){
            return Collections.emptyList();
        }
        return this.barbers.values().stream().sorted((b1, b2) -> {
            int result = Integer.compare(b2.clients.size(), b1.clients.size());
            return result;
        }).collect(Collectors.toList());
    }

    @Override
    public Collection<Barber> getAllBarbersSortedWithStarsDescendingAndHaircutPriceAsc() {
        return this.barbers.values().stream().sorted((b1, b2) -> {
            int firstBarberStars = b1.stars;
            int secondBarberStars = b2.stars;
            int result = Integer.compare(secondBarberStars, firstBarberStars);
            if (result == 0) {
                result = Integer.compare(b1.haircutPrice, b2.haircutPrice);
            }
            return result;
        }).collect(Collectors.toList());
    }

    @Override
    public Collection<Client> getClientsSortedByAgeDescAndBarbersStarsDesc() {
        return this.clients.values().stream().filter(c->c.barber != null).sorted((c1,c2)-> {
            int result = Integer.compare(c2.age,c1.age);
            if(result == 0) {
                result = Integer.compare(c2.barber.stars,c1.barber.stars);
            }
            return result;
        }).collect(Collectors.toList());
    }
}
