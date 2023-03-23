package ast;

public class DivisionExpression extends BinaryExpression{
    public DivisionExpression(ArithmeticExpression left, ArithmeticExpression right) {
        super(left, right);
    }

    @Override
    protected double binaryEval(double leftValue, double rightValue) {
        return leftValue / rightValue;
    }
}
