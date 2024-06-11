import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StoreTests {

    private Store store;

    @Before
    public void setUp() {
        store = new Store();
    }

    @Test
    public void testAddGame() {
        Game game = store.addGame("Game1", 10);
        assertEquals("Game1", game.getName());
        assertEquals(10, game.getPrice(), 0);
    }

    @Test
    public void testSell() {
        Game game = store.addGame("Game1", 10);
        store.sell("Game1", 0.1f);
        assertEquals(1, game.getSells());
        assertEquals(9, game.getAmountSold(), 0);
    }


    @Test
    public void testAddGameWithSameName() {
        store.addGame("Game1", 10);
        assertThrows("Game Game1 already exists",InvalidParameterException.class,()->store.addGame("Game1", 10));
    }

    @Test
    public void testSellGameNotExists() {
        assertThrows("Game not found",InvalidParameterException.class,()->store.sell("Game1", 0.1f));
    }

}
