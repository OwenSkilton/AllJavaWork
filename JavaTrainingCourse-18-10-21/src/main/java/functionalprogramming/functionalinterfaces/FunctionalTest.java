package functionalprogramming.functionalinterfaces;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
// Approach to coding that:
// - favours functions over objects
// - favours transformation (create something new from something existing) over modifications
// - favours immutable over mutable data

// Why functional programming
// Companies diversifying how data is stored so that RDBMSs (relational database management system) no longer dominate
// E.g. NoSQL becoming more common
// Storage is cheap so there is more capacity for maintaining historical data

public class FunctionalTest {

    @Test
    public void testTraditionalTransformation() {
        var names = List.of("Nathan", "Chris", "Owen", "Harley");
        var initials = new ArrayList<>();
        for (var name : names) {
            initials.add(name.charAt(0));
        }
        System.out.println(names);
        System.out.println(initials);
    }

    // This is OK but I will have to code a new method for each different means of transforming the list
    public static List<String> transformToFirstChars(List<String> list) {
        var newList = new ArrayList<String>();
        for (var element : list) {
            newList.add(String.valueOf(element.charAt(0)));
        }
        return newList;
    }

    // This version accepts a StringTransformLogic object that encapsulates the transformation logic
    // StringTrasformLogic is an interface with one method
    // To call this method we must create an impl. of said interface
    public static List<String> transform(List<String> list, StringTransformLogic transformer) {
        var newList = new ArrayList<String>();
        for (var element : list) {
            newList.add(transformer.transform(element));
        }
        return newList;
    }

    public interface StringTransformLogic {
        String transform(String string);
    }

    public class FirstCharStringTransformLogic implements StringTransformLogic {

        @Override
        public String transform(String string) {
            return String.valueOf(string.charAt(0));
        }
    }

    @Test
    public void testTransformWithNamedImpl() {
        var names = List.of("Nathan", "Chris", "Owen", "Harley");
        var initials = transform(names, new FirstCharStringTransformLogic());
        System.out.println(names);
        System.out.println(initials);
    }

    @Test
    public void testTransformWithAnonImpl() {
        var names = List.of("Nathan", "Chris", "Owen", "Harley");
        var initials = transform(names, new StringTransformLogic() {
            @Override
            public String transform(String string) {
                return String.valueOf(string.charAt(0));
            }
        });
        System.out.println(names);
        System.out.println(initials);
    }

    // What is a lambda expression?
    // It is an instance of an anonymous implementation of a functional interface
    // The compiler knows that the 2nd arg to the transform method is a StringTransformLogic instance
    // Furthermore it knows that the StringTransformLogic interface has ONLY ONE method
    // Therefore the compiler knows which method we must override
    // What is a functional interface?
    // It is an interface that has only one abstract method
    @Test
    public void testTransformWithLambda() {
        var names = List.of("Nathan", "Chris", "Owen", "Harley");
        var initials = transform(names, (String string) -> {
            return String.valueOf(string.charAt(0));
        });
        System.out.println(names);
        System.out.println(initials);
    }

    // Lambda rules:
    // - the param types can be inferred
    // - if there is only one param then you can omit the round brackets
    // - if there is only one line of code then you can omit the braces
    // - if you omit the braces you MUST omit the return keyword
    @Test
    public void testTransformWithLambdaPlusShortcuts() {
        var names = List.of("Nathan", "Chris", "Owen", "Harley");
        var initials = transform(names, string -> String.valueOf(string.charAt(0)));
        System.out.println(names);
        System.out.println(initials);
    }

}
