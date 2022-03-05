package polymorphism;

import java.math.BigDecimal;

// By inheriting from an abstract class we're inheriting:
// - state: balance (name and number are private)
// - behaviour: getters and setters
// - obligation: we must override withdraw
public class SavingsAccount extends Account {

    public SavingsAccount(String name, String number) {
        // The call to super DOES NOT result in the creation of a second object
        // All it does is initialise the name and number fields
        super(name, number);
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) > 0) {
            balance = balance.subtract(amount);
        }
    }

    @Override
    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.valueOf(100)) <= 0) {
            balance = balance.add(amount);
        }
    }
}
