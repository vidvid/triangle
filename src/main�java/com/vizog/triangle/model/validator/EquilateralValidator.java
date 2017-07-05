package com.vizog.triangle.model.validator;

import static com.vizog.triangle.model.Messages.NOT_EQUILATERAL;

/**
 * Created by Vahid on 7/5/17.
 */
public class EquilateralValidator extends TriangleValidator {

    @Override
    protected void validateSides(int a, int b, int c) {
        if(!matchesSides(a, b, c)){
            throw new IllegalArgumentException(NOT_EQUILATERAL);
        }
    }

    /**
     * if all sides are equal then it is equilateral
     */
    @Override
    public boolean matchesSides(int a, int b, int c) {
        return a == b && b == c;
    }
}
