package Collections;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> hsTowns= new HashSet<String>();

        // Orders the list by length of string and then by alphabetical

        hsTowns.add("Brecon");
        hsTowns.add("Cardigan");
        hsTowns.add("Pembroke");
        hsTowns.add("Llanelli");
        System.out.println(hsTowns);

        hsTowns.remove("Brecon");
        System.out.println(hsTowns);
    }
}
