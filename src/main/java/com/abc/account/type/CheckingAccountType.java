package com.abc.account.type;

/**
 * Created by aholub on 8/31/15.
 */
public class CheckingAccountType implements AccountType {

    public String getName() {
        return "Checking Account";
    }

    public double interestEarned(double amount) {
        return amount * 0.001;
    }
}
