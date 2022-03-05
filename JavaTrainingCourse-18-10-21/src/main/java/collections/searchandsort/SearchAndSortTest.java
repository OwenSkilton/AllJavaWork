package collections.searchandsort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchAndSortTest {

    @Test
    public void testArraySearch() {
        var nums = new int[]{4, 1, 7, 3, 6, 9, 2};
        Arrays.sort(nums); // <!-- the sort method sorts the array in place
        var indexOf7 = Arrays.binarySearch(nums, 7);
        assertEquals(5, indexOf7);
    }

    @Test
    public void testListSearch() {
        var nums = new ArrayList<Integer>();
        nums.add(4);
        nums.add(1);
        nums.add(7);
        nums.add(3);
        nums.add(6);
        nums.add(9);
        nums.add(2);
        Collections.sort(nums); // <!-- the sort methods sorts the Collection in place
        var indexOf7 = Collections.binarySearch(nums, 7);
        assertEquals(5, indexOf7);
    }

    // By implementing Comparable we give our Person instances a natural sort order
    // This should be standard practice just like overridding hashCode and equals
    public class Person implements Comparable<Person> {

        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public int compareTo(Person other) {
            // If this Person is equal to the other then we must return 0
            // If this Person is greater than the other then we must return a pos. number
            // If this Person is less than the other then we must return a neg. number
            return this.name.compareTo(other.name);
        }
    }

    @Test
    public void testPersonSort() {
        var persons = new Person[]{
                new Person("Tom", 20),
                new Person("Dick", 30),
                new Person("Harry", 40)
        };
        Arrays.sort(persons);
        assertEquals("Dick", persons[0].getName());
    }
}
