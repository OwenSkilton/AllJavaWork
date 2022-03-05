package coupling;

// An abstract class is one that CANNOT be instantiated
// Abstract classes are commonly used to abstract away that which is common from n subclasses
// Super classes are often abstract
// Abstract classes can have fields and concrete methods (methods that have a body)
// An interface is an abstract class that cannot have fields or concrete methods
// A class can implement (inherit from) many interfaces but can only extend one abstract class
public interface Repo {

    // An abstract method is one that MUST be overridden by the subclasses
    // In an interface methods are public and abstract by default
    void insertRecord(String record);
}
