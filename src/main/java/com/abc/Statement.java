package com.abc;

import com.abc.account.Account;

import java.math.BigDecimal;

import static java.lang.Math.abs;

/**
 * Created by aholub on 8/31/15.
 */
public class Statement {

    public static String getStatement(Customer customer) {
        String statement = null;
        statement = "Statement for " + customer.getName() + "\n";
        BigDecimal total = BigDecimal.ZERO;
        for (Account a : customer.getAccounts()) {
            statement += "\n" + statementForAccount(a) + "\n";
            total = total.add(a.sumTransactions());
        }
        statement += "\nTotal In All Accounts " + toDollars(total);
        return statement;
    }

    private static String statementForAccount(Account a) {
        //Translate to pretty account type
        String s = a.getAccountName() + "\n";

        //Now total up all the transactions
        BigDecimal total = BigDecimal.ZERO;
        for (Transaction t : a.getTransactions()) {
            s += "  " + (t.getAmount().compareTo(BigDecimal.ZERO) < 0 ? "withdrawal" : "deposit") + " " + toDollars(t.getAmount()) + "\n";
            total = total.add(t.getAmount());
        }
        s += "Total " + toDollars(total);
        return s;
    }

    private static String toDollars(BigDecimal d){
        return String.format("$%,.2f", abs(d.doubleValue()));
    }
}
