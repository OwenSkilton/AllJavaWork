# Quiz - Day 3

1. The Arrays and Collections classes contain utility methods for doing what?
   Sort and search among others

2. What must you do to ensure instances of your POJO classes have a natural sort order?
   Implement Comparable and override the compareTo method

3. The compareTo method compares one object with another and returns an int. What does the value of said int
   say about the two objects?
   0 if equal; pos. if first > second; neg. if first < second
   
4. What are the pros and cons of generic collections?
   Pros: we needn't perform instance checks and downcasts; cons: we can store only one type of thing

5. What does the T in the following declaration represent?: class Box<T> {}
   A placeholder that will be substituted at compile time

6. How does one go about making a method generic?
   Add a type param e.g. <T> immediately before the return type

7. Which of the following collection types is indexed? List, Set, Queue
   List

8. What type of collection would you use if you needed a collection of unique, ordered values?
   TreeSet

9. What type of collection would you use if you needed to extract individuals using some meaningful key?
   HashMap

10. What does it mean to say that a given queue is bounded and blocking?
    Bounded: has a capacity; blocking: the thread will be blocked when pushing to a full queue/popping from an empty queue

11. Map keys must be unique and should be immutable, why?
    Because duplicate keys would result in a corrupt collection and mutating a key will change its internal index

12. What is a lambda expression and why were they added to Java in version 8?
    An instance of an anon. impl. of a functional interface; to facilitate functional programming