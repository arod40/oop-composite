package ast;

public class PowerExpression extends BinaryExpression{
    public PowerExpression(ArithmeticExpression left, ArithmeticExpression right) {
        super(left, right);
    }

    @Override
    protected double binaryEval(double leftValue, double rightValue) {
        return Math.pow(leftValue, rightValue);
    }
}
