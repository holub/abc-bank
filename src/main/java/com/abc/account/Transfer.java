package com.abc.account;

import java.math.BigDecimal;

/**
 * Created by aholub on 8/31/15.
 */
public class Transfer {
    private final Account fromAccount;
    private final Account toAccount;

    public Transfer(Account fromAccount, Account toAccount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }

    public void doTransfer(BigDecimal amount) {
        fromAccount.withdraw(amount);
        // No exceptions: success!
        toAccount.deposit(amount);
    }
}
