# Quiz - Day 3

## 1. Arrays and collection contain utility methods for doing what?

    Sort and search

## 2. What must you do to ensure instances of your POJO classes have a natural sort order?

    Implement the comparable and override compareTo method

## 3. The compareTo method comapres one object with another and returns an int. What does the value of said int say about the two objects?

    0 if queal
    Positive if first object > second
    Negative if first object < second

## 4. Pros and cons on generic collections?
    
    Pros:
     - Needn't perform instance checks and downcasts
     
    Cons:
     - Only store one type of thing

## 5. What does the T mean in the following: class Box<T> {}? 

    Placeholder that will be substituted at compile time

## 6. How does one go about making a method generic?

    Add a type param e.g. <T> immediately before the return type

## 7. Which of the following collection is indexed? List, Set, Queue? 
    
    List

## 8. What type of collection would you use for unique, ordered values?
    
    TreeSet

## 9. What type of collection would you used to extract individuals using some meaningful key?

    HashMap

## 10. What's it mean to say that a given queue is bounded and blocking?

    Bounded: Has a capacity 
    Blocking: Thread will be blocked when pushing to a full and popping from an empty

## 11. Map keys must be unique and should be immutable, why?

    Because duplicate keys would result in a corrupt collection and mutating a key will change its internal index

## 12. What is a lambda expression in Java 8?

    Anonymous implementation of a functional interface; to facilitate functional programming
    

