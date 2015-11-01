package hr.mogh.problems.moneywithdrawal;

/**
 * Solves the following problem:
 * You have some money in your bank account, the only function to withdraw money is uint16 Withdraw(uint16 value), if
 * the value is greater than the money you have it returns 0, otherwise it withdraws the requested amount and returns
 * the "value". Write a function that withdraws all your money.
 * Created by vlado on 1.11.2015.
 */
public class MoneyWithdrawalSolver {

    public static int withdrawAllMoney(BankAccount account) {
        int allMoney = 0;

        int amount = Integer.MAX_VALUE;
        while (amount > 0) {
            int withdrawn = account.withdraw(amount);
            if (withdrawn == 0) {
                amount /= 2;
            }
            allMoney +=  withdrawn;
        }

        return allMoney;
    }
}
