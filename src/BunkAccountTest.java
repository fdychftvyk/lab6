import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BunkAccountTest {
    private BunkAccount account;

    @BeforeEach
    public void setUp(){
        account = new BunkAccount("test_id",100.0);
    }

    @Test
    void testCreateBalanceIsCorrect() {
        assertEquals(100.0, account.getBalance());
    }

    @Test
    void testCreateBalanceIsNegative(){
        assertThrows(IllegalArgumentException.class, () ->
                new BunkAccount("test_id",-100.0));
    }

    @Test
    void testDepositSuccess(){
        account.deposit(50.00);
        assertEquals(150.0, account.getBalance());
    }

    @Test
    void testDepositIncorrectAmout(){
        assertThrows(IllegalArgumentException.class, () ->
                account.deposit(0.00));
        assertThrows(IllegalArgumentException.class, ()->
                account.deposit(-100.00));

    }

    @Test
    void testWithdrawSuccess(){
        account.withdraw(50.00);
        assertEquals(50.0, account.getBalance());
    }

    @Test
    void testWithdrawIncorrectAmout(){
        assertThrows(IllegalArgumentException.class, () ->
                account.withdraw(0.00));
        assertThrows(IllegalArgumentException.class, ()->
                account.withdraw(-100.00));
    }

    @Test
    void  testWithdrawExceedingBalance(){
        assertThrows(IllegalArgumentException.class, ()->
                account.withdraw(200.00));
    }
    @Test
    void testBalanceAfterOperations(){
        BunkAccount operationsAccount = new BunkAccount("id_tested",100.00);
        operationsAccount.deposit(100.00);
        operationsAccount.withdraw(25.00);
        assertEquals((175.00),operationsAccount.getBalance());
    }
}