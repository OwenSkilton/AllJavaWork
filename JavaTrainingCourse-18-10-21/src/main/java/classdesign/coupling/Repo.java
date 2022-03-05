package classdesign.coupling;

// An abstract class is one that CANNOT be instantiated
// Abstract classes are commonly used to abstract away that which is common for N subclasses
// Super classes are often abstract
public abstract class Repo {

    // An abstract method is one that must be overwritten by subclasses
    public abstract void insertRecord(String record);
}
