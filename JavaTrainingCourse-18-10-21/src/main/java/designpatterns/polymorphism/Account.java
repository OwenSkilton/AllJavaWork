package designpatterns.polymorphism;

import java.math.BigDecimal;

public abstract class Account {

    private String name;
    private String number;

    protected BigDecimal balance;

    public Account(String name, String number) {
        this.name = name;
        this.number = number;
        this.balance = BigDecimal.ZERO;
    }

    // The subclasses will be FORCED to override this method
    public abstract void withdraw(BigDecimal amount);

    // The subclasses may CHOOSE to override this class
    public void deposit(BigDecimal amount){balance = balance.add(amount);}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
