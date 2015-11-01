package hr.mogh.problems.moneywithdrawal;

/**
 * Created by vlado on 1.11.2015.
 */
public class BankAccount {
    private int money;

    public BankAccount(int money) {
        this.money = money;
    }

    public int withdraw(int amount) {
        int withdrawnAmount = 0;
        if (amount <= this.money) {
            withdrawnAmount = amount;
            this.money -= amount;
        }
        return withdrawnAmount;
    }
}
