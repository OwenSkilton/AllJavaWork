package collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollectionsTest {

    @Test
    public void testConcurrentCollections() {
        // Each collection type has an assoc. thread-safe version, e.g.:
        var threadSafeList = new CopyOnWriteArrayList<>();
        var threadSafeSet = new ConcurrentSkipListSet<>();
        var threadSafeMap = new ConcurrentHashMap<>();
        // NB: be aware that the thread-safe collections will be slower than their non-thread-safe counterparts
    }

    @Test
    public void testCollectionConversion() {
        // Each non-thread-safe collection can be converted into a thread-safe one
        var nonThreadSafeList = new ArrayList<String>();
        var threadSafeList = Collections.synchronizedList(nonThreadSafeList);
    }
}
