package tokenization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tokenizer {
    Map<Character, Token> staticTokens = new HashMap() {{
        put('+', new Token(Token.Type.PLUS));
        put('-', new Token(Token.Type.MINUS));
        put('(', new Token(Token.Type.OPEN_PAR));
        put(')', new Token(Token.Type.CLOSED_PAR));
        put('*', new Token(Token.Type.STAR));
        put('/', new Token(Token.Type.DIV));
        put('^', new Token(Token.Type.POW));
    }};

    public List<Token> tokenize(String text){
        List<Token> tokens = new ArrayList<>();

        boolean funcOpen = false;
        boolean numberOpen = false;
        List<Character> buffer = new ArrayList<>();

        for (int pos = 0; pos < text.length(); pos++) {
            Character c = text.charAt(pos);

            if (c >= '0' && c <= '9'){
                if (!numberOpen) {
                    numberOpen = true;
                    buffer = new ArrayList<>();
                }
                buffer.add(c);
            }
            else if (numberOpen) {
                numberOpen = false;
                tokens.add(new Token(Token.Type.NUMBER, buffer.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining())));
            }

            if (c >= 'a' && c <= 'z'){
                if (!funcOpen) {
                    funcOpen = true;
                    buffer = new ArrayList<>();
                }
                buffer.add(c);
            }
            else if (funcOpen) {
                funcOpen = false;
                tokens.add(new Token(Token.Type.FUNC, buffer.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining())));
            }

            if (!numberOpen && !funcOpen) {
                if (c == ' ')
                    ;
                else if (staticTokens.containsKey(c))
                    tokens.add(staticTokens.get(c));
                else {
                    throw new RuntimeException("Unexpected character: '" + c + "'");
                }
            }

        }

        return tokens;
    }
}
