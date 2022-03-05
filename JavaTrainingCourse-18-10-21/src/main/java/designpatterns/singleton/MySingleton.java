package designpatterns.singleton;

// Singleton is a creational design pattern
// That is, it deals with object creation
// Specifically it is used to ensure only one instance of a class exists
// Commonly deployed in multi-threaded apps e.h. web apps and REST APIs
// E.g. whilst we may need to crate many movie objects, we need only make one service and repo
public class MySingleton {

    private static MySingleton mySingleton;

    private MySingleton(){

    }

    // On first invocation this method will create a single instance and return a ref to it
    // On subsequent invocations this method will return refs to the existing instance
    // By including the if statement instead on the field declaration, the instance of the class will be created when requested rather on compile
    public static MySingleton getInstance(){
        if (mySingleton == null){
            mySingleton = new MySingleton();
        }
        return mySingleton;
    }
}
