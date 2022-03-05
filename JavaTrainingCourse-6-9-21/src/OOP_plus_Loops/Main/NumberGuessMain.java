package OOP_plus_Loops.Main;

import OOP_plus_Loops.Pojos.NumberGuessClass;

import java.util.Scanner;

public class NumberGuessMain {
    static Scanner stdin = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("========================================\n" +
                "| Welcome to the number guessing game! |\n"+
                "========================================\n");
        NumberGuessClass numberToBeGuessed = new NumberGuessClass();
        int guessingNumber = numberToBeGuessed.getNumber();
        int guess = 0;
        while (guess != guessingNumber){
            System.out.println("\nSelect a number between 1 and 100: ");;
            guess = Integer.parseInt(stdin.nextLine());
            if (guess < guessingNumber){
                System.out.println("Too Low!");
                numberToBeGuessed.increasenO_Of_Guesses();
            } else if (guess > guessingNumber){
                System.out.println("Too High!");
                numberToBeGuessed.increasenO_Of_Guesses();
            } else {
                System.out.printf("\nThat's it! You win, it took you %d guesses!", numberToBeGuessed.getnO_Of_Guesses());
            }
        }
    }
}
