package ast;

public class Number implements ArithmeticExpression {
    double value;

    public Number(double value){
        this.value = value;
    }
    @Override
    public double evaluate() {
        return value;
    }
}
