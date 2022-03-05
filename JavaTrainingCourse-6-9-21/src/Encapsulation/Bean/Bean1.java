package Encapsulation.Bean;

public class Bean1 {
    private int num;
    private String name;
    private boolean truth;
    private Boolean lies;

    public Bean1(int num, String name) throws Exception {
        setNum(num);
        setName(name);
    }

    public Bean1(int num, String name, boolean truth, Boolean lies) throws Exception {
        this(num, name); // Calling other constructor within another
        this.truth = truth;
        this.lies = lies;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name.length() > 0){
            this.name = name;
        } else {
            throw new Exception("Name must have at least 1 character"); //Validation during construction
        }
    }

    public boolean isTruth() { //lower case boolean as a getter called isTruth (primitive = cheaper in memory)
        return truth;
    }

    public void setTruth(boolean truth) {
        this.truth = truth;
    }

    public Boolean getLies() { //Upper case Boolean as a getter is getLies
        return lies;
    }

    public void setLies(Boolean lies) {
        this.lies = lies;
    }
}
