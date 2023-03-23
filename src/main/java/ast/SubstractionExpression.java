package ast;

public class SubstractionExpression extends BinaryExpression {
    public SubstractionExpression(ArithmeticExpression left, ArithmeticExpression right) {
        super(left, right);
    }

    @Override
    protected double binaryEval(double leftValue, double rightValue) {
        return leftValue - rightValue;
    }
}
