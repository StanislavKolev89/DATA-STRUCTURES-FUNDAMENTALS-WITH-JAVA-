package barbershopjava;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class Test009 {

    private BarberShopImpl barberShop;
    private Barber b1 = new Barber("a", 3, 1);
    private Barber b2 = new Barber("b", 2, 3);
    private Barber b3 = new Barber("c", 2, 5);
    private Barber b4 = new Barber("d", 3, 1);

    @Before
    public void Setup() {
        this.barberShop = new BarberShopImpl();
        this.barberShop.addBarber(b1);
        this.barberShop.addBarber(b2);
        this.barberShop.addBarber(b3);
        this.barberShop.addBarber(b4);
    }

    @Test
    public void TestCollectionOfBarbersSortedWithStarsDescendingAndHaircutPriceAsc() {
        ArrayList<Barber> collect = barberShop.getAllBarbersSortedWithStarsDescendingAndHaircutPriceAsc().stream().collect(Collectors.toCollection(ArrayList::new));

    }
}
