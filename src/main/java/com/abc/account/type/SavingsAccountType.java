package com.abc.account.type;

/**
 * Created by aholub on 8/31/15.
 */
public class SavingsAccountType implements AccountType {

    public String getName() {
        return "Savings Account";
    }

    public double interestEarned(double amount) {
        if (amount <= 1000)
            return amount * 0.001;
        else
            return 1 + (amount-1000) * 0.002;
    }
}
