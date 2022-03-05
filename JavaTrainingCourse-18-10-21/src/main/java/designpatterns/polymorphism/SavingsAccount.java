package designpatterns.polymorphism;

import java.math.BigDecimal;

public class SavingsAccount extends Account{
    public SavingsAccount(String name, String number) {
        super(name, number);
    }

    @Override
    public void withdraw(BigDecimal amount){
        if (balance.compareTo(amount)>0){
            balance = balance.subtract(amount);
        }
    }

    @Override
    public void deposit(BigDecimal amount){
        if (balance.compareTo(BigDecimal.valueOf(100)) <= 0){
            balance = balance.add(amount);
        }
    }
}
