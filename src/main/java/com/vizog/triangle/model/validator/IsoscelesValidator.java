package com.vizog.triangle.model.validator;

import static com.vizog.triangle.model.Messages.NOT_ISOSCELES;

/**
 * Created by Vahid on 7/5/17.
 */
public class IsoscelesValidator extends TriangleValidator {

    @Override
    protected void validateSides(int a, int b, int c) {
        if(!matchesSides(a, b, c)){
            throw new IllegalArgumentException(NOT_ISOSCELES);
        }
    }

    /**
     * if at least 2 sides are equal then it is isosceles
     */
    @Override
    protected boolean matchesSides(int a, int b, int c) {
        return a == b || b == c || a ==c;
    }
}
