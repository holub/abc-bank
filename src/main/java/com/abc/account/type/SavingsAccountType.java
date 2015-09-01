package com.abc.account.type;

import java.math.BigDecimal;

/**
 * Created by aholub on 8/31/15.
 */
public class SavingsAccountType extends AccountTypeBase {
    static final BigDecimal THRESHOLD1 = new BigDecimal("1000");
    static final BigDecimal INTEREST1 = new BigDecimal("0.001");

    static final BigDecimal INTEREST_OTHER = new BigDecimal("0.002");

    public String getName() {
        return "Savings Account";
    }

    public BigDecimal annualInterest(BigDecimal amount) {
        if (amount.compareTo(THRESHOLD1) <= 0)
            return amount.multiply(INTEREST1);
        else
            return annualInterest(THRESHOLD1).add(amount.subtract(THRESHOLD1).multiply(INTEREST_OTHER));
    }
}
