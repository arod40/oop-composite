import tokenization.Token;
import tokenization.Tokenizer;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer();
        List<Token> tokens = tokenizer.tokenize("5+3- cos(4)");

        for (Token t:tokens) {
            System.out.println(t);
        }
    }
}
