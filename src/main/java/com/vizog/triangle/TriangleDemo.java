package com.vizog.triangle;

import com.vizog.triangle.model.Triangle;
import com.vizog.triangle.model.TriangleFactory;

/**
 * Created by Vahid on 7/5/17.
 */
public class TriangleDemo {


    public static void main(String[] args) {
        demoFactoryBySideValues();

        demoInvalidValues();

        demoFactorySpecificMethods();

    }

    private static void demoInvalidValues() {
        System.out.println("===============================================");
        System.out.println("Trying Invalid Values:");
        System.out.println("===============================================");
        System.out.println();
        System.out.println();

        tryInvalidValues(0, 1, 2);
        tryInvalidValues(-1, 3, 4);
        tryInvalidValues(2, 3, 5);
    }

    private static void demoFactoryBySideValues() {
        System.out.println("===============================================");
        System.out.println("Trying detection of triangle type by side lengths:");
        System.out.println("===============================================");

        Triangle equilateral = TriangleFactory.bySideLengths(1, 1, 1);
        System.out.print("TriangleFactory.bySideLengths(1, 1, 1) -> ");
        System.out.println(equilateral);
        System.out.println("-----------------");

        Triangle isosceles = TriangleFactory.bySideLengths(2, 1, 2);
        System.out.print("TriangleFactory.bySideLengths(2, 1, 2) -> ");
        System.out.println(isosceles);
        System.out.println("-----------------");

        Triangle scalene = TriangleFactory.bySideLengths(2, 3, 4);
        System.out.print("TriangleFactory.bySideLengths(2, 3, 4) -> ");
        System.out.println(scalene);
        System.out.println("-----------------");
    }

    private static void tryInvalidValues(int a, int b, int c) {
        try {
            TriangleFactory.bySideLengths(a, b, c);
        } catch (IllegalArgumentException e) {
            System.out.println("Calling TriangleFactory.bySideLengths(" + a + ", " + b + ", " + c + ")" +
                    " throws IllegalArgumentException with message: " + e.getMessage());
        }
    }

    private static void demoFactorySpecificMethods() {
        System.out.println("===============================================");
        System.out.println("Trying specific factory methods:");
        System.out.println("===============================================");

        Triangle equilateral = TriangleFactory.equilateral(1, 1, 1);
        System.out.print("TriangleFactory.equilateral(1, 1, 1) -> ");
        System.out.println(equilateral);
        System.out.println("-----------------");

        Triangle isosceles = TriangleFactory.isosceles(2, 1, 2);
        System.out.print("TriangleFactory.isosceles(2, 1, 2) -> ");
        System.out.println(isosceles);
        System.out.println("-----------------");

        Triangle scalene = TriangleFactory.scalene(2, 3, 4);
        System.out.print("TriangleFactory.scalene(2, 3, 4) -> ");
        System.out.println(scalene);
        System.out.println("-----------------");

        try {
            TriangleFactory.equilateral(2, 3, 4);
        } catch (IllegalArgumentException e) {
            System.out.print("calling TriangleFactory.equilateral(2, 3, 4) throws exception: ");
            System.out.println(e.getMessage());
        }
    }

}
