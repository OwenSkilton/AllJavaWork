package OOP_plus_Loops.Pojos;

public class NumberGuessClass {
    private int number;
    private int nO_Of_Guesses;

    public NumberGuessClass() {
        this.setNumber((int)(Math.random()*100));
    }

    public int getNumber() {
        return number;
    }

    public int getnO_Of_Guesses() {
        return nO_Of_Guesses;
    }

    public void increasenO_Of_Guesses() {
        this.nO_Of_Guesses ++;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
