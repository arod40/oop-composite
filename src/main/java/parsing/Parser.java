package parsing;

import ast.*;
import ast.Number;

public class Parser {

    // Taken from https://stackoverflow.com/questions/3422673/how-to-evaluate-a-math-expression-given-in-string-form
    // and modified to return an AST
    public static ArithmeticExpression parse(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            ArithmeticExpression parse() {
                nextChar();
                ArithmeticExpression x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)` | number
            //        | functionName `(` expression `)` | functionName factor
            //        | factor `^` factor

            ArithmeticExpression parseExpression() {
                ArithmeticExpression x = parseTerm();
                for (;;) {
                    if      (eat('+')) x = new AdditionExpression(x, parseTerm()); // addition
                    else if (eat('-')) x = new SubstractionExpression(x, parseTerm()); // subtraction
                    else return x;
                }
            }

            ArithmeticExpression parseTerm() {
                ArithmeticExpression x = parseFactor();
                for (;;) {
                    if      (eat('*')) x = new MultiplicationExpression(x, parseFactor()); // multiplication
                    else if (eat('/')) x = new DivisionExpression(x, parseFactor()); // division
                    else return x;
                }
            }

            ArithmeticExpression parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return new NegationExpression(parseFactor()); // unary minus

                ArithmeticExpression x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    if (!eat(')')) throw new RuntimeException("Missing ')'");
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = new Number(Double.parseDouble(str.substring(startPos, this.pos)));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    if (eat('(')) {
                        x = parseExpression();
                        if (!eat(')')) throw new RuntimeException("Missing ')' after argument to " + func);
                    } else {
                        x = parseFactor();
                    }
                    if (func.equals("sqrt")) x = new SqrtExpression(x);
                    else if (func.equals("sin")) x = new SineExpression(x);
                    else if (func.equals("cos")) x = new CosineExpression(x);
                    else if (func.equals("tan")) x = new TangentExpression(x);
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = new PowerExpression(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}
