package com.vizog.triangle.model;

/**
 * A scalene triangle is one which doesn't necessarily have any equal sides.
 *
 * In order to prevent creation of this class without validation of sides, I have made the
 * constructor package private which is only accessible by TriangleFactory class.
 *
 * Created by Vahid on 7/5/17.
 */
public class Scalene extends Triangle {
    Scalene(int a, int b, int c) {
        super(a, b, c);
    }

    @Override
    public TriangleType getType() {
        return TriangleType.SCALENE;
    }
}
