package com.abc.account.type;

import java.math.BigDecimal;

/**
 * Created by aholub on 8/31/15.
 */
public interface AccountType {

    String getName();
    BigDecimal interestEarned(BigDecimal amount);
}
