package collections;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionTest {

    // The java.util package contains many collection classes
    // The Collection interface is the parent interface for List, Set, and Queue
    // The Map interface is the parent of HashMap etc.

    @Test
    public void testList() {

        // List is a sub-interface of Collection
        // It defines an indexed collection which accepts duplicates
        // Lists are good where all elements are to be processed and duplicates are required
        // Lists are NOT good for arbitrary access

        // ArrayList is backed by an array and so is good for getting & setting but not so good for adding & removing
        List<String> list1 = new ArrayList<>();

        // LinkedList is a linked list and so is good for adding & removing but not so good for getting & setting
        List<String> list2 = new LinkedList<>();

        // Vector, unlike ArrayList and LinkedList, is thread-safe but that makes it slower in a single thread env.
        List<String> list3 = new Vector<>();
    }

    class Thing {

        String name;

        public Thing(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Thing thing = (Thing) o;
            return Objects.equals(name, thing.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    @Test
    public void testSet() {

        // Set is a sub-interface of Collection
        // It defines an unordered collection which does NOT accept duplicates
        // Sets are good for stripping duplicates from a List and for performing unions, intersections, diffs etc.
        // Sets are NOT good for arbitrary access
        // NB: overriding hashCode and equals is critical to a Set working correctly

        // HashSet is backed by an array
        Set<String> set1 = new HashSet<>();
        set1.addAll(List.of("Hello", "Hello", "Hi", "Howdy", "Hi", "Gday"));
        for (var string : set1) {
            System.out.println(string); // <!-- elements may not come out in the order they went in
        }
        assertEquals(4, set1.size()); // <!-- duplicates are stripped out

        // LinkedHashSet is backed by a linked list
        Set<String> set2 = new LinkedHashSet<>();

        // TreeSet is ordered by default using the element's natural sort order
        // The class of objects stored MUST implement Comparable
        // TreeSets are by their nature slower than the non-ordered variety
        Set<String> set3 = new TreeSet<>();

        // You must be careful of Sets containing mutable objects
        Set<Thing> things = new HashSet<>();
        var thing1 = new Thing("George");
        var thing2 = new Thing("Thomas");
        var thing3 = new Thing("Thomas");
        things.add(thing1);
        things.add(thing2);
        things.add(thing3);
        thing1.name = "Thomas"; // <!-- this will corrupt the Set insofar as it now has duplicates
        assertEquals(2, things.size());
        for (var thing : things) {
            System.out.println(thing.name);
        }
    }

    @Test
    public void testQueue() {

        // Queue is a sub-interface of Collection
        // It defines a collection in which elements are pushed on one end and popped from the other
        // Queues are good in cases where data must be processed in order
        // There are two fundamental characteristics:
        // 1. Queues are bounded (fixed capacity) or unbounded
        // 2. Queues are blocking (forces the thread to wait) or non-blocking

        // LinkedList has push and pop methods
        Queue<String> queue1 = new LinkedList<>();

        // ArrayDeque is backed by an array and is double-ended
        Queue<String> queue2 = new ArrayDeque<>();

        // ArrayBlockingQueue is backed by an array and will block the thread when pushing to a full queue etc.
        Queue<String> queue3 = new ArrayBlockingQueue<>(10);

        // PriorityQueue elements can jump ahead based on their natural sort order
        Queue<String> queue4 = new PriorityQueue<>();
    }

    @Test
    public void testMap() {

        // Map is NOT a sub-interface of Collection rather it is a sibling interface
        // It defines a grouping of unordered key value pairs
        // The keys must be unique and SHOULD be immutable (see Sets above)
        // Maps are very good for arbitrary access
        // Maps are not so good for processing every element

        // HashMap is backed by an array
        Map<String, Integer> map1 = new HashMap<>();

        // LinkedHashMap is backed by a linked list
        Map<String, Integer> map2 = new LinkedHashMap<>();

        // TreeMap keys are ordered according to their natural sort order
        Map<String, Integer> map3 = new TreeMap<>();

        // Like Vector Hashtable is thread-safe
        Map<String, Integer> map4 = new Hashtable<>();
    }
}
