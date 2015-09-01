package com.abc.account.type;

import java.math.BigDecimal;

/**
 * Created by aholub on 8/31/15.
 */
public class CheckingAccountType extends AccountTypeBase {
    static final BigDecimal RATE = new BigDecimal("0.001");

    public String getName() {
        return "Checking Account";
    }

    public BigDecimal annualInterest(BigDecimal amount) {
        return amount.multiply(RATE);
    }
}
