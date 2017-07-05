package com.vizog.triangle.model;

import com.vizog.triangle.model.validator.EquilateralValidator;
import com.vizog.triangle.model.validator.IsoscelesValidator;
import com.vizog.triangle.model.validator.ScaleneValidator;

/**
 * Creates a {@link Triangle} based on the sides given.
 * Created by Vahid on 7/5/17.
 */
public class TriangleFactory {

    private static final EquilateralValidator equilateralValidator = new EquilateralValidator();
    private static final IsoscelesValidator isoscelesValidator = new IsoscelesValidator();
    private static final ScaleneValidator scaleneValidator = new ScaleneValidator();

    public static Triangle bySideLengths(int a, int b, int c) {
        if (equilateralValidator.matches(a, b, c)) {
            return new Equilateral(a,b,c);
        } else if (isoscelesValidator.matches(a, b, c)) {
            return new Isosceles(a,b,c);
        }
        else {
            return new Scalene(a, b, c);
        }
    }

    public static Triangle equilateral(int a, int b, int c) {
        equilateralValidator.validate(a, b, c);
        return new Equilateral(a, b, c);
    }

    public static Triangle isosceles(int a, int b, int c) {
        isoscelesValidator.validate(a, b, c);
        return new Isosceles(a, b, c);
    }

    public static Triangle scalene(int a, int b, int c) {
        scaleneValidator.validate(a, b, c);
        return new Scalene(a, b, c);
    }

}
