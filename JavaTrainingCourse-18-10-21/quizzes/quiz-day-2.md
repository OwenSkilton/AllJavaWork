# Quiz - Day 2

## 1. Write a line of code to instantiate the inner class: class Outer { class Inner{} }

     var inner = new Outer.new Inner()

## 2. What does polymorphism mean in practical terms

    One object has many types. 
    Are able to code multiple functionalities for sub classes but are all related to the superclass, 
    All can then be used in methods that returns the super rather than an individual subclass

## 3. What is the polymorphism rule

    The variable type dictates WHAT you can do
    The object type dictates HOW you do it 

## 4. What is wrong with: SavingsAccount sa = new Account();

    Account sa = new SavingsAccount(); 
    SavingsAccount is a child to Account therefore super needs to proceed the child (DOWNCAST)

## 5. What does polymorphism enable us to do to make out code more flexible / scalable 

    Enables us to code to the super class (abstraction) and then behaviour is dependent on the subclass type

## 6. Under what circumstances might you choose to implement the singleton pattern? 

    When only one instance of the class is nessecary 

## 7. What problem do getter methods pose in relation to the immutable pattern

    If the data type is mutable they can be accessed using getter methods

## 8. Under what circumstances might you choose to implement a build pattern

    When a class has multiple fields that can be passed to the constructor and many can be passed thorugh from seperate methods, 
    allowing the construction of an object in seperate phases. Dont need to overload them

## 9. What commonly name static method is used to implement the factory method pattern

    OF

## 10. What is the purpose of the observer pattern

    To facilitate a notification system that is loosely coupled