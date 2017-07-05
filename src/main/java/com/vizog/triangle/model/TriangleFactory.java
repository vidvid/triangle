package com.vizog.triangle.model;

import com.vizog.triangle.model.validator.EquilateralValidator;
import com.vizog.triangle.model.validator.IsoscelesValidator;
import com.vizog.triangle.model.validator.ScaleneValidator;

/**
 * Creates a {@link Triangle} based on the sides given.
 * Created by Vahid on 7/5/17.
 */
@SuppressWarnings("SameParameterValue")
public class TriangleFactory {

    private static final EquilateralValidator equilateralValidator = new EquilateralValidator();
    private static final IsoscelesValidator isoscelesValidator = new IsoscelesValidator();
    private static final ScaleneValidator scaleneValidator = new ScaleneValidator();

    /**
     * factory method for automatic detection of triangle type using the given side values.
     *
     * @throws IllegalArgumentException if the side values are invalid.
     */
    public static Triangle bySideLengths(int a, int b, int c) {
        if (equilateralValidator.matches(a, b, c)) {
            return new Equilateral(a, b, c);
        } else if (isoscelesValidator.matches(a, b, c)) {
            return new Isosceles(a, b, c);
        } else if (scaleneValidator.matches(a, b, c)) {
            return new Scalene(a, b, c);
        }

        else {
            //since the validators throw an exception if the values are incorrect,
            // the following line should never be reached
            throw new RuntimeException("this should not happen");
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
