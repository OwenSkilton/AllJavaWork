package Encapsulation.BankAccount.main;

import Encapsulation.BankAccount.exceptions.InsufficientFundsException;
import Encapsulation.BankAccount.pojos.Account;

import java.math.BigDecimal;
import java.util.Scanner;

public class main {
    static Scanner stdin = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Account owenAccount = new Account("Owen", 5000);
        try{
            owenAccount.withdraw(2000);
        } catch (InsufficientFundsException e){
//            System.out.println(InsufficientFundsException.message);
        }
        System.out.println(owenAccount.getBalance());
        owenAccount.deposit(3000);
        System.out.println(owenAccount.getBalance());
        try{
            owenAccount.withdraw(7600);
            System.out.println(owenAccount.getBalance());
        } catch (InsufficientFundsException e){
            throw new InsufficientFundsException(BigDecimal.valueOf(7600));
        }
    }
}
