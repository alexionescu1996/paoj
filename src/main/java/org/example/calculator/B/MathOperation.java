package org.example.calculator.B;

public interface MathOperation {

    double applyFunction(GenericFunction function, double a, double b);

    void applyFunctionWithCallback(GenericFunction function,
                                   double a,
                                   double b,
                                   CallbackFunction callbackFunction);
}
