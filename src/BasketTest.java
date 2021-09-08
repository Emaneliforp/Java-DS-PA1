import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BasketTest {

    public static Collection<Object[]> BAGNUMS =
            Arrays.asList(new Object[][] { {0}, {1}, {2}, {3}, {4}, {5}, {6} });
    private int bagType;

    public BasketTest(int bagType) {
        super();
        this.bagType = bagType;
    }

    @Parameterized.Parameters(name = "Basket{index}")
    public static Collection<Object[]> bags() {
        return BAGNUMS;
    }

    private Basket makeBasket() {
        switch(this.bagType) {
            case 0: return new Basket0();
            case 1: return new Basket1();
            case 2: return new Basket2();
            case 3: return new Basket3();
            case 4: return new Basket4();
            case 5: return new Basket5();
            case 6: return new Basket6();
        }
        return null;
    }

    @Test
    public void addedHasCount1() {
        Basket basketToTest = makeBasket();

        Item i = new Item("Shampoo", 5);
        basketToTest.addToBasket(i);
        assertEquals(1, basketToTest.count());
    }

}
