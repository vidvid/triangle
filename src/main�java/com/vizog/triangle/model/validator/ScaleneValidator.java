package com.vizog.triangle.model.validator;

/**
 * Created by Vahid on 7/5/17.
 */
public class ScaleneValidator extends TriangleValidator {

    @Override
    protected void validateSides(int a, int b, int c) {
        // no need to do anything because if this is a triangle, it can be a scalene
    }

    @Override
    protected boolean matchesSides(int a, int b, int c) {
        return true;
    }


}
