package functionalprogramming.functionalinterfaces;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LambdaTest {

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
    @Test
    public void testTransformStringToInteger() {
        var names = List.of("Nathan", "Chris", "Owen", "Harley");
        var lengths = transform(names, string -> string.length());
    }
}
