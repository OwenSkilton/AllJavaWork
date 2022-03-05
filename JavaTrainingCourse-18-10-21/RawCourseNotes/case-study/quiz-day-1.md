# Quiz - Day 1

1. What are the three types of association that can exist between classes?
   IS-A (inheritance)
   HAS-A (aggregation or composition)
   USES-A (method param)

2. What is the difference between aggregation and composition?
   Aggregation implies the dependency can exist without the dependent
   Composition implies the dependency cannot exist without the dependent

3. What are the differences between an abstract class and an interface?
   An abstract class can have fields and concrete methods in addition to abstract methods
   An interface has abstract methods only (an interface IS an abstract class)
   Implementing an interface means inheriting one or more obligations (methods that must be overridden)
   You can extend only one abstract class
   You can implement many interfaces

4. What is a tightly coupled assoc. and how does one make it loose?
   When classes are highly dependent (the dependency is concrete) on one another they are tightly coupled
   One can make the assoc. loose by separating concerns (make the dependency abstract)

5. How might one determine if a class is cohesive or not?
   All members of the class must be related to one another
   The methods must operate on the fields

6. How might one restrict the instantiation of a class to one or more other classes?
   Use access modifiers (not public)
   Organise your classes into sub-packages

7. Under what circs might one consider making a method static?
   When the behaviour will never change, e.g. the Math class

8. How does the default impl. of equals test for equality?
   Using == which for ref variables means testing equality of memory address
   The assumption will be that equals tests for equality of content

9. How should one determine which fields to include when overriding hashCode and equals?
   The fields that determine uniqueness in a business logic sense
   hashCode need not be unique but must be the same for two equal objects

10. What exactly is an enum value?
    A static final instance of the enum class