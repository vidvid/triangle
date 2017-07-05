package com.vizog.triangle;

import com.vizog.triangle.model.Triangle;
import com.vizog.triangle.model.TriangleFactory;

/**
 * Created by Vahid on 7/5/17.
 */
public class TriangleDemo {


    public static void main(String[] args) {
        Triangle equilateral = TriangleFactory.bySideLengths(1, 1, 1);
        System.out.println("TriangleFactory.bySideLengths(1, 1, 1):");
        System.out.println(equilateral.toString());

        System.out.println("-----------------");

        Triangle isosceles = TriangleFactory.bySideLengths(2, 1, 2);
        System.out.println("TriangleFactory.bySideLengths(2, 1, 2):");
        System.out.println(isosceles.toString());

        System.out.println("-----------------");

        Triangle scalene = TriangleFactory.bySideLengths(2, 3, 4);
        System.out.println("TriangleFactory.bySideLengths(2, 3, 4):");
        System.out.println(scalene.toString());


        demoInvalidValues(0, 1, 2);
        demoInvalidValues(-1, 3, 4);
        demoInvalidValues(2, 3, 5);

    }

    private static void demoInvalidValues(int a, int b, int c) {
        try {
            TriangleFactory.bySideLengths(a, b, c);
        } catch (IllegalArgumentException e) {
            System.out.println("Calling TriangleFactory.bySideLengths(" + a + ", " + b + ", " + c + ")" +
                    " throws IllegalArguemenException with message: " + e.getMessage());
        }
    }
}
