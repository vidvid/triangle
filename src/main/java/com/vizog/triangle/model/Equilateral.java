package com.vizog.triangle.model;

/**
 * An equilateral triangle is one with 3 equal sides
 *
 * In order to prevent creation of this class without validation of sides, I have made the
 * constructor package private which is only accessible by TriangleFactory class.
 *
 * Created by Vahid on 7/5/17.
 */
public class Equilateral extends Triangle {
    Equilateral(int a, int b, int c) {
        super(a, b, c);
    }

    @Override
    public TriangleType getType() {
        return TriangleType.EQUILATERAL;
    }
}
