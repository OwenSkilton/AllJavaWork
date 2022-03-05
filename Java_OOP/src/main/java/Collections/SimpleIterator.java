package Collections;

import java.util.ArrayList;
import java.util.Iterator;

public class SimpleIterator {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Cardiff");
        cities.add("Swansea");
        cities.add("Newport");
        cities.add("St. Davids");
        cities.add("St. Asaph");

        //Create iterator for cities
        Iterator<String> itCities = cities.iterator();

        //Print the first item in the cities ArrayList with a loop
        while (itCities.hasNext()) {
            String city = itCities.next();
            if (city == "Cardiff"){
                itCities.remove();
            }
        }
        System.out.println(cities);
    }
}
