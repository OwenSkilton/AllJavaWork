# Quiz - Day 1

## 1. What are the 3 types of association that can exist between classes

    HAS-A (Inheritance) 
    USES-A (Aggregation or classdesign.innerclasses)
    IS-A ()

## 2. What is te difference between aggregation and classdesign.innerclasses

    Aggregation = dependency CAN exist without the dependent
    Composition = dependency CANNOT exist without the dependent

## 3. What is the difference between an abstract class, and an interface

    Abstract classes can have their own fields and concrete methods in addittion to abstract methods 
    An interface has abstract methods only
    Implementing an interfaces means inheriting one or more obligations (Methods that need to overwritten)
    Can extend only one abstract class but can imnplement many interfaces

## 4. What is a tightly coupled associating and how does one make it loose

    When classes are highly dependent (the dependency is concrete) on one another they are tightly coupled 
    One can make the association loose by seperating concerns (make the dependency abstract) 

## 5. How might one determine if a class is cohesive or not

    All memebers of the class must be related to one another 
    Methods must operate on the fields

## 6. How might one restrict the instantiation of a class to one or more other classes

    Use access modifiers (Not public)
    Organise classes into sub-packages

## 7. Under what circumstances might one consider making a member static

    When the behaviour of a method will never change

## 8. How does the default implementation of equals test for equality

    Uses == which for ref variables means testing equlirt of memory address rather than content

## 9. How should one determine which fields to include when overriding hashCode and equals

    The fields that determine uniqueness in a business logic sense
    HashCode need not be unique but must be the same for 2 equal objects

## 10. What is an enum value

    A static final instance of the enum class