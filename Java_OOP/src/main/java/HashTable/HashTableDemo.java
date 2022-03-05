package HashTable;

import java.util.Hashtable;
import java.util.Iterator;

public class HashTableDemo {
    public static void main(String[] args) {
        //1. Create HAshTable
        Hashtable<String, String> hashtable = new Hashtable<>();
        //           ^       ^
        //           ¦       ¦
        //          Key     Value

        //2. Add mappings to hashtable
        hashtable.put("Stephen", "PhD Business computing");
        hashtable.put("Mike", "PhD Educational computing");
        hashtable.put("Tim", "PhD Parallel computing");
        hashtable.put("Kemi", "PhD Web computing");

        System.out.println(hashtable);

        //3. Get a mapping by key
        String value = hashtable.get("Tim");
        System.out.println(value);

        //4. Remove a Mapping
        hashtable.remove("Stephen");

        //5. Iterate over mappings
        Iterator<String> itr = hashtable.keySet().iterator();

        while (itr.hasNext()){
            String key = itr.next(); // Gets keys in alphabetical order
            String mappedValue = hashtable.get(key);

            System.out.println("Key: " + key + ", Value: " + mappedValue);
        }
    }
}
