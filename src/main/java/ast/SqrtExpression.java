package ast;

public class SqrtExpression extends UnaryExpression{
    public SqrtExpression(ArithmeticExpression child) {
        super(child);
    }

    @Override
    protected double unaryEval(double childValue) {
        return Math.sqrt(childValue);
    }
}
