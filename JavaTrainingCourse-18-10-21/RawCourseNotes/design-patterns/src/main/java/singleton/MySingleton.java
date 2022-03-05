package singleton;

// Singleton is a creational design pattern
// That is, it deals with object creation
// Specifically it is used to ensure only one instance of a class exists
// Singleton is commonly deployed in multi-threaded apps e.g. web apps and REST APIs
// E.g. whilst we may need to create many Movie objects, we need only one service and repo
// There is a very common similar pattern called Object Pool
public class MySingleton {

    private static MySingleton mySingleton;

    private MySingleton() {
    }

    // On first invocation this method will create the single instance and return a ref to it
    // On subsequent invocations this method will return refs to the existing instance
    public static MySingleton getInstance() {

        // By adding the if statement the instance is created lazily (on demand)
        // We could intialise the instance on line 10 but this would constitute eager creation
        if (mySingleton == null) {
            mySingleton = new MySingleton();
        }
        return mySingleton;
    }
}
