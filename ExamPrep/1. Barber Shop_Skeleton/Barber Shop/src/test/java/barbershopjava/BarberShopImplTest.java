package barbershopjava;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class BarberShopImplTest {
    private BarberShopImpl barberShop;

    private Barber b1 = new Barber("a", 3, 1);
    private Barber b2 = new Barber("b", 2, 3);
    private Client c1= new Client("c1",20,Gender.MALE);
    private Client c2= new Client("c2",20,Gender.FEMALE);

    @Before
    public void Setup() {
        this.barberShop = new BarberShopImpl();
        this.barberShop.addBarber(b1);
        this.barberShop.addBarber(b2);
        this.barberShop.addClient(c1);
        this.barberShop.addClient(c2);
        this.barberShop.assignClient(b1,c1);
        this.barberShop.assignClient(b1,c2);
    }
    @Test
    public void getAllBarbersSortedWithClientsCountDesc() {

        ArrayList<Barber> collect = barberShop.getAllBarbersSortedWithClientsCountDesc().stream().collect(Collectors.toCollection(ArrayList::new));

    }

    @Test
    public void getClientsSortedByAgeDescAndBarbersStarsDesc() {
    }
}