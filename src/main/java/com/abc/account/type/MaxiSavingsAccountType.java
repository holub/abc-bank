package com.abc.account.type;

/**
 * Created by aholub on 8/31/15.
 */
public class MaxiSavingsAccountType implements AccountType {

    public String getName() {
        return "Maxi Savings Account";
    }

    public double interestEarned(double amount) {
        if (amount <= 1000)
            return amount * 0.02;
        if (amount <= 2000)
            return 20 + (amount-1000) * 0.05;
        return 70 + (amount-2000) * 0.1;
    }
}
