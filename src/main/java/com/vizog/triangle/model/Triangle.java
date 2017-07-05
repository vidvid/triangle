package com.vizog.triangle.model;

/**
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

