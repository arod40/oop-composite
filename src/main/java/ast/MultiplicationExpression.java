package ast;

public class MultiplicationExpression extends BinaryExpression {
    public MultiplicationExpression(ArithmeticExpression left, ArithmeticExpression right) {
        super(left, right);
    }

    @Override
    protected double binaryEval(double leftValue, double rightValue) {
        return leftValue * rightValue;
    }
}
