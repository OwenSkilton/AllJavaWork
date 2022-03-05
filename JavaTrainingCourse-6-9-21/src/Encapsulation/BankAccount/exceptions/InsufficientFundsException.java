package Encapsulation.BankAccount.exceptions;

import java.math.BigDecimal;

public class InsufficientFundsException extends Exception{
   public InsufficientFundsException(BigDecimal amount){
       super("Insufficient funds. Unable to withdraw: " + amount);
   }
}
