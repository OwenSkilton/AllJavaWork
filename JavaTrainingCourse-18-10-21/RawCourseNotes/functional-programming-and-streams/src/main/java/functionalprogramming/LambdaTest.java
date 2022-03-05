package functionalprogramming;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LambdaTest {

    // Functional programming is an approach to coding that:
    // - favours functions over objects
    // - favours transformations (create something new from something existing) over modifications
    // - favours immutable over mutable data

    // Why functional programming?
    // Increasingly companies are diversifying how data is stored so that RDBMSs no longer dominate
    // For example NoSQL is becoming more common
    // Storage is cheap so there is more capacity for maintaining historical data

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
    public static <T, R> List<R> transform(List<T> list, TransformLogic<T, R> transformer) {
        var newList = new ArrayList<R>();
        for (var element : list) {
            newList.add((R) transformer.transform(element));
        }
        return newList;
    }

    public interface TransformLogic<T, R> {
        R transform(T t);
    }

    public class FirstCharTransformLogic implements TransformLogic<String, Character> {

        @Override
        public Character transform(String string) {
            return string.charAt(0);
        }
    }

    @Test
    public void testTransformWithNamedImpl() {
        var names = List.of("Nathan", "Chris", "Owen", "Harley");
        var initials = transform(names, new FirstCharTransformLogic());
        System.out.println(names);
        System.out.println(initials);
    }

    @Test
    public void testTransformWithAnonImpl() {
        var names = List.of("Nathan", "Chris", "Owen", "Harley");
        var initials = transform(names, new TransformLogic<String, Character>() {
            @Override
            public Character transform(String string) {
                return string.charAt(0);
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
            return string.charAt(0);
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
        var initials = transform(names, string -> string.charAt(0));
        System.out.println(names);
        System.out.println(initials);
    }

    // CHALLENGE
    // Modify the transform method such that it can handle lists of any type
    // Then code a test to transform the names list to a list of name lengths using your updated method

    @Test
    public void testTransformStringToInteger() {
        var names = List.of("Nathan", "Chris", "Owen", "Harley");
        var lengths = transform(names, string -> string.length());
    }
}
