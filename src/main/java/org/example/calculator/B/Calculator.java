package org.example.calculator.B;

public class Calculator
        implements MathOperation {

    @Override
    public double applyFunction(GenericFunction function, double a, double b) {
        return function.apply(a, b);
    }

    @Override
    public void applyFunctionWithCallback(GenericFunction function,
                                            double a,
                                            double b,
                                            CallbackFunction callbackFunction) {

        double result = function.apply(a, b);

        callbackFunction.onComplete(result);
    }
}
