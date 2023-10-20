import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountTest {
    Account account;

    @BeforeEach
    public void setup() throws Exception{
        account = new Account(10000);
    }

    @Test
    public void testContruction() throws Exception{
    }

    @Test
    void testGetBalance() throws Exception{
        assertEquals(10000,account.getBalance());

        account = new Account(2300);
        assertEquals(2300,account.getBalance());

        account = new Account(0);
        assertEquals(0,account.getBalance());
    }

    @Test
    void testDeposit() throws Exception{
        assertEquals(10000,account.getBalance());

        account.deposit(2000);
        account.deposit(3000);
        account.deposit(4000);
        account.deposit(5000);

        assertEquals(24000,account.getBalance());
    }

    @Test
    void testWithdraw() throws Exception{
        assertEquals(8000,account.withdraw(2000));
        assertEquals(5000,account.withdraw(3000));
        assertEquals(1000,account.withdraw(4000));
        assertEquals(-4000,account.withdraw(5000));

        assertEquals(-4000,account.getBalance());
    }

    @Test
    public void testCompoundInterest() throws Exception{
        assertEquals(265788, (int)account.getCompoundInterest(120000, 2, 0.07));
        assertEquals(1111176, (int)account.getCompoundInterest(120000, 7, 0.07));
        assertEquals(1025893, (int)account.getCompoundInterest(120000, 7, 0.05));
        assertEquals(854910, (int)account.getCompoundInterest(100000, 7, 0.05));
        assertEquals(0, (int)account.getCompoundInterest(0, 7, 0.07));
    }
}