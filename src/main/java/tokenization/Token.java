package tokenization;

public class Token {
    public enum Type{
        NUMBER,
        PLUS,
        MINUS,
        STAR,
        DIV,
        POW,
        FUNC,
        OPEN_PAR,
        CLOSED_PAR;
    }

    Type type;

    String text;

    public Token(Type type, String text) {
        this.type = type;
        this.text  = text;
    }

    public Token(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type.name() + ":" +text;
    }
}
