package com.vizog.triangle.model;

/**
 * This abstract class represents a triangle.
 * Note that for creating various types of triangles you should use {@link TriangleFactory} methods.
 * In order to prevent creation of Triangle objects without validation, I have made the
 * constructors package private which are only accessible by TriangleFactory class.
 *
 * Created by Vahid on 7/5/17.
 */
public abstract class Triangle {

    private final int a;
    private final int b;
    private final int c;

    Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "this is a triangle of type " + getType() + " with side values " + a + "," + b + "," + c;
    }

    public abstract TriangleType getType();

}

