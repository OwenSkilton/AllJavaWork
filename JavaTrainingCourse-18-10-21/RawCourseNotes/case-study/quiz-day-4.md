# Quiz - Day 4

1. What is a functional interface?
   An interface that has only one abstract method

2. What is the signature of the Predicate interface's method?
   boolean test(T t);

3. What is the signature of the Consumer interface's method?
   void accept(T t);

4. Write a lambda implementation for Function<Double, BigDecimal>
   d -> BigDecimal.valueOf(d)

5. What is a Stream and for what is it used?
   A means of processing collections to produce a new collection based on the existing one

6. What are the two most commonly used intermediate stream operations, and what type of 
   functional interface instance does each one take as an argument?
   filter(Predicate p) and map(Function f)
   
7. List two or more terminal stream operations
   collect and forEach

8. Why might you want to create a primitive stream or convert a regular stream into a 
   primitive one?
   Primitive streams have additional terminal operations like sum, average, min, max etc.
   
9. What is the difference between concurrency and parallelism?
   Concurrency means switching between tasks very quickly; parallelism means doing two or more things at once

10. How should your approach to concurrency differ depending on whether the task at hand
    is IO intensive or CPU intensive?
    IO intensive tasks can theoretically benefit from n threads; CPU intensive tasks will benefit only from threads 
    matching the number of cores
    
11. What are the two ways of creating a Threadable object?
    extend Thread and override run; implement Runnable and pass your Runnable to the Thread constructor

12. How do you force one thread to wait for another to complete?
    By calling join on the given thread

13. How do you identify shared data in a multi-threaded environment?
    Instance fields in classes whose instances are shared by n threads

14. How do you make a field thread-safe?
    final and immutable