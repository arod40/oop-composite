package ast;

public abstract class UnaryExpression implements ArithmeticExpression {
    ArithmeticExpression child;

    public UnaryExpression(ArithmeticExpression child){
        this.child = child;
    }

    @Override
    public double evaluate() {
        return this.unaryEval(this.child.evaluate());
    }

    protected abstract double unaryEval(double childValue);
}
