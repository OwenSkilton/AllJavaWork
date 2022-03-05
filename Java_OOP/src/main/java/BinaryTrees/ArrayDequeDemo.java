package BinaryTrees;

import java.util.ArrayDeque;

public class ArrayDequeDemo {
    public static void main(String[] args) {
        ArrayDeque<String> adqCities = new ArrayDeque<>();

        adqCities.push("London");
        adqCities.push("Cardiff");
        adqCities.push("Edinburgh");
        adqCities.push("Dublin");

        // Pop the stack
        System.out.println("Popping Cities from the stack: ");
        while (adqCities.isEmpty() != true){
            System.out.print(adqCities.pop() + " ");
        }
        System.out.println();
        System.out.println(adqCities.size());
    }
}
