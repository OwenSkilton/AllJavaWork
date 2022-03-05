package Encapsulation.Bean;

public class App {
    public static void main(String[] args) {
        try {
            Bean1 bean = new Bean1(1, "Fred");
            bean.setName("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
