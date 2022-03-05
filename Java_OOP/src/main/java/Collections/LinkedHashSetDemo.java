package Collections;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<String> hsTowns = new LinkedHashSet<>();

        hsTowns.add("Brecon");
        hsTowns.add("Cardigan");
        hsTowns.add("Pembroke");
        hsTowns.add("Llanelli");

        System.out.println(hsTowns);

        hsTowns.remove("Brecon");
        System.out.println(hsTowns);

    }
}
