package com.vizog.triangle;

import com.vizog.triangle.model.Triangle;
import com.vizog.triangle.model.TriangleFactory;

/**
 * Run this class to see a showcase of Triangle project implementation
 * Created by Vahid on 7/5/17.
 */
public class TriangleDemo {


    public static void main(String[] args) {
        demoFactoryBySideValues();

        demoInvalidValues();

        demoFactorySpecificMethods();

    }

    private static void demoFactoryBySideValues() {
        printHeader("Trying detection of triangle type by side lengths");

        Triangle equilateral = TriangleFactory.bySideLengths(1, 1, 1);
        System.out.println("TriangleFactory.bySideLengths(1, 1, 1) -> " + equilateral);

        Triangle isosceles = TriangleFactory.bySideLengths(2, 1, 2);
        System.out.println("TriangleFactory.bySideLengths(2, 1, 2) -> " + isosceles);

        Triangle scalene = TriangleFactory.bySideLengths(2, 3, 4);
        System.out.println("TriangleFactory.bySideLengths(2, 3, 4) -> " + scalene);
    }


    private static void demoInvalidValues() {
        printHeader("Trying Invalid Values");

        tryInvalidValues(0, 1, 2);
        tryInvalidValues(-1, 3, 4);
        tryInvalidValues(2, 3, 5);
    }

    private static void demoFactorySpecificMethods() {
        printHeader("Trying specific factory methods");

        Triangle equilateral = TriangleFactory.equilateral(1, 1, 1);
        System.out.println("TriangleFactory.equilateral(1, 1, 1) -> " + equilateral);

        Triangle isosceles = TriangleFactory.isosceles(2, 1, 2);
        System.out.println("TriangleFactory.isosceles(2, 1, 2) -> " + isosceles);

        Triangle scalene = TriangleFactory.scalene(2, 3, 4);
        System.out.println("TriangleFactory.scalene(2, 3, 4) -> " + scalene);

        try {
            TriangleFactory.equilateral(2, 3, 4);
        } catch (IllegalArgumentException e) {
            System.out.print("calling TriangleFactory.equilateral(2, 3, 4) throws exception: ");
            System.out.println(e.getMessage());
        }
    }

    private static void tryInvalidValues(int a, int b, int c) {
        try {
            TriangleFactory.bySideLengths(a, b, c);
        } catch (IllegalArgumentException e) {
            System.out.println("Calling TriangleFactory.bySideLengths(" + a + ", " + b + ", " + c + ")" +
                    " throws IllegalArgumentException with message: " + e.getMessage());
        }
    }

    private static void printHeader(String header) {
        System.out.println();
        System.out.println();
        System.out.println("===============================================");
        System.out.println(header + ":");
        System.out.println("===============================================");
    }

}
