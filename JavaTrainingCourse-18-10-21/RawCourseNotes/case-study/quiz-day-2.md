# Quiz - Day 2

1. Write a line of code to instantiate the inner class: class Outer { class Inner {} }
   var inner = new Outer().new Inner();

2. What does polymorphism mean in practical terms?
   One object has many types

3. What is the polymorphism rule?
   The object type dictates HOW you do something, and the variable type dictates WHAT you can do

4. What is wrong with this line of code: SavingsAccount sa = new Account();
   Not every Account is a SavingsAccount; this is a DOWNCAST

5. What does polymorphism enable us to do to make our code more flexible/scalable?
   It enables us to code to the super class (abstraction) and then behaviour is dependent on the subclass type

6. Under what circs might you choose to implement the singleton pattern?
   When you want to ensure only a single instance exists; commonly used in multi-threaded environments

7. What problem do getter methods pose in relation to the immutable pattern?
   If the object ref'd by a given field is mutable then the getter enables the mutation of said object

8. Under what circs might you choose to implement the builder pattern?
   When a class has big constructors and/or you want to enable the creation to occur in phases

9. What commonly named static method is used to implement the factory method pattern?
   of

10. What is the purpose of the observer pattern?
    To facilitate a notification system that is loosely coupled