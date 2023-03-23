package ast;

public class CosineExpression extends UnaryExpression {
    public CosineExpression(ArithmeticExpression child) {
        super(child);
    }

    @Override
    protected double unaryEval(double childValue) {
        return Math.cos(childValue);
    }
}
