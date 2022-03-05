package Encapsulation.BankAccount.pojos;

import Encapsulation.BankAccount.exceptions.InsufficientFundsException;

import java.math.BigDecimal;

public class Account {
    private String name;
    private long accountNumber;
    private BigDecimal balance;
    private static long nextNumber = 1001001;

    public Account(String name) throws Exception {
        setName(name);
        this.accountNumber =  nextNumber++;
        this.balance = new BigDecimal("0");
    }

    public Account(String name, double balance) throws Exception {
        this(name);
        this.balance = BigDecimal.valueOf(balance);
    }

    public void deposit(double amount){
       this.balance = this.balance.add(BigDecimal.valueOf(amount));
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (this.balance.compareTo(BigDecimal.valueOf(amount)) >= 0) {
            this.balance = this.balance.subtract(BigDecimal.valueOf(amount));
        } else {
            throw new InsufficientFundsException(BigDecimal.valueOf(amount));
        }
    }

    public void setName(String name) throws Exception {
        if (name.length() > 0) {
            this.name = name;
        } else {
            throw new Exception("Name must have at least 1 character"); //Validation during construction
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public long getAccountNumber() {
        return accountNumber;
    }
}
