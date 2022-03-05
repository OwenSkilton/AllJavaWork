package designpatterns.polymorphism;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @Test
    public void testPolymorphism(){
        // Polymorphism is a by-product of inheritance (Concrete class / abstract class / interface)
        // It means many types i.e. one object many classes
        // The variable type can often does differ from the object type
        // Why does it work? Because SavingsAccount IS-A Account
        // This is a UPCAST and the compiler will allow it because every SavingsAccount is an Account
        // Polymorphism rule:
        // - The variable type dictates WHAT can you do
        // - The object type dictates HOW you do it
        Account account = new SavingsAccount("Jones", "JON123");
        // Because of the polymorphism rule it's the version of deposit inside SavingsAccount that is called:
        account.deposit(BigDecimal.valueOf(101));
        account.deposit(BigDecimal.valueOf(101));
        assertEquals(BigDecimal.valueOf(101), account.getBalance());
    }
}
