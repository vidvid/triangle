package com.vizog.triangle.model.validator;

import static com.vizog.triangle.model.Messages.*;

/**
 * Base class for validation and matching of triangles by the given side values.
 * The {@link #validate(int, int, int)} method is exposed to other classes for handling
 * validation with exception.
 * The {@link #matches(int, int, int)} method is exposed for checking if the concrete subclass
 * matches the given side values.
 *
 * Created by Vahid on 7/5/17.
 */
public abstract class TriangleValidator {

    /**
     * calls internal {@link #validateTriangle(int, int, int)} to see if the inputs are correct for
     * a triangle.
     * then forces calling of children's validateSide methods.
     */
    public final void validate(int a, int b, int c) {
        validateTriangle(a, b, c);
        validateSides(a, b, c);
    }

    /**
     * this method is overridden to validate that the concrete type (like equilateral)
     * can be created by given side values.
     * subclasses should not re-implement sanity checks for a common triangle and should only
     * provide the specific validation of the type.
     **/
    protected abstract void validateSides(int a, int b, int c);

    /**
     * sanity checks the side values.
     * all values should be greater than zero and some of all pairs of sides must be greater than the other one.
     */
    private void validateTriangle(int a, int b, int c) {
        if (!sanityCheckInputs(a, b, c)) {
            throw new IllegalArgumentException(INVALID_INPUT);
        } else if (!validateInequalityTheorem(a, b, c)) {
            throw new IllegalArgumentException(NON_MATCHING_SIDES);
        }
    }


    /**
     * returns true if a valid triangle can be constructed and the side values match
     * the specific type (provided by subclasses).
     * This method is exposed for other classes but can't be overridden.
     */
    public final boolean matches(int a, int b, int c) {
        validateTriangle(a, b, c);
        return matchesSidesForType(a, b, c);
    }

    /**
     * overridden by specific subclasses to ensure that the given side values match the type
     */
    protected abstract boolean matchesSidesForType(int a, int b, int c);


    private static boolean validateInequalityTheorem(int a, int b, int c) {
        return (a + b > c && a + c > b && b + c > a);
    }

    private static boolean sanityCheckInputs(int a, int b, int c) {
        return (a > 0 && b > 0 && c > 0);
    }

}
