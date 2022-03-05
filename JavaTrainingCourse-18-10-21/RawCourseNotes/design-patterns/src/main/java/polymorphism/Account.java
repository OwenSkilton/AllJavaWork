package polymorphism;

import java.math.BigDecimal;

public abstract class Account {

    private String name;
    private String number;

    // A field named type or similar is a red flag that you're breaking the open/closed principle
    // If a new type is added or an existing one removed then you'll have to modify this class - NO!
    // Instead we should exploit inheritance to ensure that existing code need not be changed
    // That is the Account class should be OPEN for extension and CLOSED for modification
    // private String type;

    protected BigDecimal balance;

    public Account(String name, String number /*, String type */) {
        this.name = name;
        this.number = number;
        // this.type = type;
        this.balance = BigDecimal.ZERO;
    }

//    public void withdraw(BigDecimal amount) {
//        switch (type) {
//            case "SAVINGS":
//                if (balance.compareTo(amount) > 0) {
//                    balance = balance.subtract(amount);
//                }
//                break;
//            case "CREDIT":
//                balance = balance.subtract(amount);
//                break;
//        }
//    }

//    public void withdraw(BigDecimal amount) {
//        balance = balance.subtract(amount);
//    }

    // The subclasses will be FORCED to override this method
    public abstract void withdraw(BigDecimal amount);

    // The subclasses may CHOOSE to override this method
    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public String getName() {
        return name;
    }

    public Account setName(String name) {
        this.name = name;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public Account setNumber(String number) {
        this.number = number;
        return this;
    }

//    public String getType() {
//        return type;
//    }
//
//    public Account setType(String type) {
//        this.type = type;
//        return this;
//    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Account setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }
}
