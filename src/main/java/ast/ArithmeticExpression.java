package ast;

public interface ArithmeticExpression {

    // this should be a Visitor, but for the purposes of this assignment, I'm gonna make it like this
    double evaluate();
}
