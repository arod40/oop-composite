import parsing.Parser;

public class App {
    public static void main(String[] args) {
        System.out.println(Parser.parse("5+(3-6.5)^2").evaluate());
    }



}
