package com.vizog.triangle.model;

/**
 * Created by Vahid on 7/5/17.
 */
public class Isosceles extends Triangle {
    Isosceles(int a, int b, int c) {
        super(a, b, c);
    }

    @Override
    public TriangleType getType() {
        return TriangleType.ISOSCELES;
    }
}
