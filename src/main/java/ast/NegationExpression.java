package ast;

public class NegationExpression extends UnaryExpression{
    public NegationExpression(ArithmeticExpression child) {
        super(child);
    }

    @Override
    protected double unaryEval(double childValue) {
        return -childValue;
    }
}
