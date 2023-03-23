package ast;

public class SineExpression extends UnaryExpression {
    public SineExpression(ArithmeticExpression child) {
        super(child);
    }

    @Override
    protected double unaryEval(double childValue) {
        return Math.sin(childValue);
    }
}
