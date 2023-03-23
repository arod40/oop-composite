package ast;

public abstract class BinaryExpression implements ArithmeticExpression{
    ArithmeticExpression left;
    ArithmeticExpression right;

    public BinaryExpression(ArithmeticExpression left, ArithmeticExpression right){
        this.left =  left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        return this.binaryEval(this.left.evaluate(), this.right.evaluate());
    }

    protected abstract double binaryEval(double leftValue, double rightValue);
}
