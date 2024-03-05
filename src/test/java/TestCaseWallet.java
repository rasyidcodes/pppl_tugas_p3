import org.example.Wallet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCaseWallet {
    private Wallet wallet;

    @BeforeEach
    public void initMethod() {
        wallet = new Wallet("Rasyid");
    }

    @Test
    public void testAddMoney() {
        wallet.addMoney(3000);
        assertEquals(1, wallet.getMoneys().get(3000));
    }

    @Test
    public void testAddCoin() {
        wallet.addCoin(100);
        wallet.addCoin(100);
        wallet.addCoin(100);
        assertEquals(3, wallet.getCoins().get(100));
    }

        @Test
        public void testAddCard() {
            wallet.addCard("ATM");
            assertTrue(wallet.getCards().contains("ATM"));
        }

    @Test
    public void testTakeCard() {
        wallet.addCard("ATM");
        wallet.takeCard("ATM");
        assertFalse(wallet.getCards().contains("ATM"));
    }

    @Test
    public void testTakeCoins() {
        wallet.addCoin(500);
        wallet.takeCoins(500);
        assertEquals(0, wallet.getCoins().get(500));
    }

    @Test
    public void testTakeMoneys() {
        wallet.addMoney(5000);
        wallet.takeMoneys(5000);
        assertEquals(0, wallet.getMoneys().get(5000));
    }

    @Test
    public void testCalculateCoins() {
        wallet.addCoin(100);
        wallet.addCoin(100);
        wallet.addCoin(500);
        assertEquals(700, wallet.calculateCoins());
    }

    @Test
    public void testCalculateMoneys() {
        wallet.addMoney(3000);
        wallet.addMoney(10000);
        wallet.addMoney(5000);
        assertEquals(18000, wallet.calculateMoneys());
    }

    @Test
    public void testGetMoneyAvailable() {
        wallet.addMoney(3000);
        wallet.addMoney(5000);
        wallet.addCoin(100);
        wallet.addCoin(500);
        assertEquals(8600, wallet.getMoneyAvailable());
    }
}
