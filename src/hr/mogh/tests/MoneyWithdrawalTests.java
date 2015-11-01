package hr.mogh.tests;

import hr.mogh.problems.moneywithdrawal.BankAccount;
import hr.mogh.problems.moneywithdrawal.MoneyWithdrawalSolver;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests MoneyWithdrawalSolver implementation.
 * Created by vlado on 1.11.2015.
 */
public class MoneyWithdrawalTests {

    private BankAccount account;
    private static final int MONEY_IN_ACCOUNT_1 = 62000;
    private static final int MONEY_IN_ACCOUNT_2 = 493341;

    @Test
    public void withdrawAllMoneyTest_1() {
        account = new BankAccount(MONEY_IN_ACCOUNT_1);
        int withdrawn = MoneyWithdrawalSolver.withdrawAllMoney(account);
        Assert.assertEquals(MONEY_IN_ACCOUNT_1, withdrawn);
    }

    @Test
    public void withdrawAllMoneyTest_2() {
        account = new BankAccount(MONEY_IN_ACCOUNT_2);
        int withdrawn = MoneyWithdrawalSolver.withdrawAllMoney(account);
        Assert.assertEquals(MONEY_IN_ACCOUNT_2, withdrawn);
    }
}
