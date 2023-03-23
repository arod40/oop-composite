package ast;

public class AdditionExpression extends BinaryExpression{
    public AdditionExpression(ArithmeticExpression left, ArithmeticExpression right) {
        super(left, right);
    }

    @Override
    protected double binaryEval(double leftValue, double rightValue) {
        return leftValue + rightValue;
    }
}
