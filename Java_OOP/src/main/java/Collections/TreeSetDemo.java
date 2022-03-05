package Collections;

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<String> tsTowns = new TreeSet<>();

        tsTowns.add("Brecon");
        tsTowns.add("Cardigan");
        tsTowns.add("Pembroke");
        tsTowns.add("Llaneli");

        //Printed in sorted order
        System.out.println(tsTowns);

        tsTowns.remove("Brecon");
        System.out.println(tsTowns);
    }


}
