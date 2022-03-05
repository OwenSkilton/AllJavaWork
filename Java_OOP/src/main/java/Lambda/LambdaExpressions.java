package Lambda;

interface myNumber{
    double getValue();
}
interface isEvenCheck{
    boolean checkAnswer(int y);
}
interface StringFunction<T>{
    T func (String word);
}
public class LambdaExpressions {
    public static void main(String[] args) {

        //getValue()

        myNumber myNum;
        myNum = () -> Math.random()*100;
        System.out.println("Random value: " + myNum.getValue());

        //Even check
        isEvenCheck isEven = (n) -> (n%2) == 0;
        System.out.println(("Answer: " + isEven.checkAnswer(6)));

        //StringFunction
        StringFunction<String> reverse = (str) -> {
            String wordReverse = "";
            for (int i = str.length() -1; i>=0; i--){
                wordReverse += str.charAt(i);
            }
            return wordReverse;
        };
        System.out.println("Lambda reversed is: " + reverse.func("Lambda"));
    }
}
