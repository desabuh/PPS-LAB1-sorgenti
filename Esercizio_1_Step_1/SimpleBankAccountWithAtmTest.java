import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.BankAccountWithAtm;
import lab01.example.model.SimpleBankAccount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SimpleBankAccountWithAtmTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;


    @BeforeEach
    void beforeEach() {
        accountHolder = new AccountHolder("Luigi", "Verdi", 2);
        bankAccount = new BankAccountWithAtm(new SimpleBankAccount(accountHolder, 0));
    }


    @Test
    void testFeeDeposit() {
        this.bankAccount.deposit(this.accountHolder.getId(), 100);
        assertEquals(this.bankAccount.getBalance(), 100 - BankAccountWithAtm.FEE);
    }

    @Test
    void testFeeWithdraw() {
        this.bankAccount.deposit(this.accountHolder.getId(), 150);
        this.bankAccount.withdraw(this.accountHolder.getId(), 100);
        assertEquals(this.bankAccount.getBalance(), 150 - 100 -  (2 * BankAccountWithAtm.FEE));
    }

    @Test
    void testNotEnoughBalanceWithdrawFee() {
        this.bankAccount.deposit(this.accountHolder.getId(), 50);
        this.bankAccount.withdraw(this.accountHolder.getId(), 100);
        assertEquals(this.bankAccount.getBalance(), 50 - BankAccountWithAtm.FEE);
    }


    @Test
    void testWrongDepositLessThanFee() {
        this.bankAccount.deposit(this.accountHolder.getId(), BankAccountWithAtm.FEE - 0.5);
        assertEquals(this.bankAccount.getBalance(), 0);
    }

    @Test
    void testWrongWithdrawLessThanFee() {
        this.bankAccount.deposit(this.accountHolder.getId(), 10);
        this.bankAccount.withdraw(this.accountHolder.getId(), BankAccountWithAtm.FEE - 0.5);
        assertEquals(this.bankAccount.getBalance(), 10 - BankAccountWithAtm.FEE);
    }
}