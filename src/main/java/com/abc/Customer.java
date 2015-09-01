package com.abc;

import com.abc.account.Account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<Account>();
    }

    public String getName() {
        return name;
    }

    public Customer openAccount(Account account) {
        accounts.add(account);
        return this;
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public BigDecimal totalInterestEarned() {
        BigDecimal total = BigDecimal.ZERO;
        for (Account a : accounts)
            total = total.add(a.interestEarned());
        return total;
    }

    public String getStatement() {
        String statement = null;
        statement = "Statement for " + name + "\n";
        BigDecimal total = BigDecimal.ZERO;
        for (Account a : accounts) {
            statement += "\n" + statementForAccount(a) + "\n";
            total = total.add(a.sumTransactions());
        }
        statement += "\nTotal In All Accounts " + toDollars(total);
        return statement;
    }

    private String statementForAccount(Account a) {
        //Translate to pretty account type
        String s = a.getAccountName() + "\n";

        //Now total up all the transactions
        BigDecimal total = BigDecimal.ZERO;
        for (Transaction t : a.transactions) {
            s += "  " + (t.amount.compareTo(BigDecimal.ZERO) < 0 ? "withdrawal" : "deposit") + " " + toDollars(t.amount) + "\n";
            total = total.add(t.amount);
        }
        s += "Total " + toDollars(total);
        return s;
    }

    private String toDollars(BigDecimal d){
        return String.format("$%,.2f", abs(d.doubleValue()));
    }
}
