package HashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        //1. Create map
        HashMap<String, Double> hm = new HashMap<String, Double>();

        //2. Put elements to the map
        hm.put("John Doe", 3434.34);
        hm.put("Tom  Smith", 123.22);
        hm.put("Jane Baker", 1378.00);
        hm.put("Tod Hall", 99.72);
        hm.put("Ralph Smith", -19.08);

        //3. Get a set of the entries

        Set<Map.Entry<String, Double>> set = hm.entrySet();
        // Converts the HashMap to a set-view....

        //4. Display the set:
        for (Map.Entry<String, Double> me : set){
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();

        //Deposit 1000 into Joh  Doe's account
        double balance = hm.get("John Doe");
        hm.put("John Doe", balance + 1000);
        System.out.println("John Doe's new balance: " + hm.get("John Doe"));
    }
}
