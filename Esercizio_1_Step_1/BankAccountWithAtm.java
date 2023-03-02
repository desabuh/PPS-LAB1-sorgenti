package lab01.example.model;


/**
 * This class represent a decorator for BankAccounts.
 * Before every transaction (deposit or withdrawal)
 * it checks whether the account holder has enough balance to pay the fee.
 * Both types of transaction should provide a minimum payment at least higher than the fee
 */

public class BankAccountWithAtm implements BankAccount {

    public static final double FEE = 1.0;
    private BankAccount account;

    public BankAccountWithAtm(final BankAccount account) {
        this.account = account;
    }

    @Override
    public AccountHolder getHolder() {
        return this.account.getHolder();
    }

    @Override
    public double getBalance() {
        return this.account.getBalance();
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if(this.isDepositWithFeeAllowed(amount)) {
            this.account.deposit(userID, amount - FEE);
        }
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if(this.isWithdrawWithFeeAllowed(amount)) {
            this.account.withdraw(userID, amount + FEE);
        }
    }


    private boolean isWithdrawWithFeeAllowed(final double amount) {
        return this.getBalance() > FEE && this.isTransactionMinimumAmount(amount);
    }

    private boolean isDepositWithFeeAllowed(final double amount) {
        return this.isTransactionMinimumAmount(amount);
    }

    private boolean isTransactionMinimumAmount(final double amount) {
        return amount > FEE;
    }

}
