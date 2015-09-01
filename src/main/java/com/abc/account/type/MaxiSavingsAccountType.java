package com.abc.account.type;

import java.math.BigDecimal;

/**
 * Created by aholub on 8/31/15.
 */
public class MaxiSavingsAccountType extends AccountTypeBase {
    static final BigDecimal THRESHOLD1 = new BigDecimal("1000");
    static final BigDecimal INTEREST1 = new BigDecimal("0.02");

    static final BigDecimal THRESHOLD2 = new BigDecimal("2000");
    static final BigDecimal INTEREST2 = new BigDecimal("0.05");

    static final BigDecimal INTEREST_OTHER = new BigDecimal("0.1");

    public String getName() {
        return "Maxi Savings Account";
    }

    public BigDecimal annualInterest(BigDecimal amount) {
        if (amount.compareTo(THRESHOLD1) <= 0)
            return amount.multiply(INTEREST1);
        else if (amount.compareTo(THRESHOLD2) <= 0)
            return annualInterest(THRESHOLD1).add(amount.subtract(THRESHOLD1).multiply(INTEREST2));
        else
            return annualInterest(THRESHOLD2).add(amount.subtract(THRESHOLD2).multiply(INTEREST_OTHER));
    }
}
