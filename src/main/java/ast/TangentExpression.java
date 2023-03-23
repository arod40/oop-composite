package ast;

public class TangentExpression extends UnaryExpression {
    public TangentExpression(ArithmeticExpression child) {
        super(child);
    }

    @Override
    protected double unaryEval(double childValue) {
        return Math.tan(childValue);
    }
}
