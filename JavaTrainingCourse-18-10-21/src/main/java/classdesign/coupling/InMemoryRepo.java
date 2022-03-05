package classdesign.coupling;

// This is a subclass of Repo or implementation of the repo abstraction
// The association between InMemoryRepo is an IS-A type
// Super classes often abstract
// Abstract classes can have field and concrete methods (Methods with a body)
// Interface is an abstract class that cannot have fields or concrete methods

public class InMemoryRepo extends Repo{

    @Override
    public void insertRecord(String record){
        // ToDo
    }
}
