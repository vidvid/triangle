package com.vizog.triangle.model.validator;

import static com.vizog.triangle.model.Messages.*;

/**
 * Created by Vahid on 7/5/17.
 */
public abstract class TriangleValidator {

    public final void validate(int a, int b, int c) {
        validate0(a, b, c);
        validateSides(a, b, c);
    }

    private void validate0(int a, int b, int c) {
        if (!validateInputs(a, b, c)) {
            throw new IllegalArgumentException(INVALID_INPUT);
        } else if (!validateInequalityTheorem(a, b, c)) {
            throw new IllegalArgumentException(NON_MATCHING_SIDES);
        }
    }


    public final boolean matches(int a, int b, int c) {
        validate0(a, b, c);
        return matchesSides(a, b, c);
    }

    protected abstract void validateSides(int a, int b, int c);

    protected abstract boolean matchesSides(int a, int b, int c);


    private static boolean validateInequalityTheorem(int a, int b, int c) {
        return (a + b > c && a + c > b && b + c > a);
    }

    private static boolean validateInputs(int a, int b, int c) {
        return (a > 0 && b > 0 && c > 0);
    }

}
