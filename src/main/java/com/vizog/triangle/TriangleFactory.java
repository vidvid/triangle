package com.vizog.triangle;

/**
 * Creates a {@link Triangle} based on the sides given.
 * Created by Vahid on 7/5/17.
 */
public class TriangleFactory {

    public static Triangle bySideLengths(int a, int b, int c) {
        return new Triangle(a, b, c);
    }
}
