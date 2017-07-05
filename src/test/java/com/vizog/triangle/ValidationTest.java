package com.vizog.triangle;

import com.vizog.triangle.model.validator.EquilateralValidator;
import com.vizog.triangle.model.validator.IsoscelesValidator;
import com.vizog.triangle.model.validator.ScaleneValidator;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static com.vizog.triangle.model.Messages.*;

public class ValidationTest {

    private EquilateralValidator equilateralValidator;
    private IsoscelesValidator isoscelesValidator;
    private ScaleneValidator scaleneValidator;

    @Before
    public void init() {
        equilateralValidator = new EquilateralValidator();
        isoscelesValidator = new IsoscelesValidator();
        scaleneValidator = new ScaleneValidator();
    }

    @Test
    public void testWithInvalidInput() {
        assertThatIllegalArgumentException().isThrownBy(() -> scaleneValidator.validate(0, 0, 0)).withMessage(INVALID_INPUT);
        assertThatIllegalArgumentException().isThrownBy(() -> scaleneValidator.validate(0, 1, 2)).withMessage(INVALID_INPUT);
        assertThatIllegalArgumentException().isThrownBy(() -> scaleneValidator.validate(1, 0, 2)).withMessage(INVALID_INPUT);
        assertThatIllegalArgumentException().isThrownBy(() -> scaleneValidator.validate(1, 1, 0)).withMessage(INVALID_INPUT);
        assertThatIllegalArgumentException().isThrownBy(() -> scaleneValidator.validate(-1, 4, 2)).withMessage(INVALID_INPUT);
    }

    @Test
    public void testInequalityTheorem() {
        assertThatIllegalArgumentException().isThrownBy(() -> scaleneValidator.validate(1, 1, 2)).withMessage(NON_MATCHING_SIDES);
        assertThatIllegalArgumentException().isThrownBy(() -> scaleneValidator.validate(1, 2, 1)).withMessage(NON_MATCHING_SIDES);
        assertThatIllegalArgumentException().isThrownBy(() -> scaleneValidator.validate(2, 1, 1)).withMessage(NON_MATCHING_SIDES);
        assertThatCode(() -> scaleneValidator.validate(1, 1, 1)).doesNotThrowAnyException();
        assertThatCode(() -> scaleneValidator.validate(2, 4, 3)).doesNotThrowAnyException();
    }

    @Test
    public void testEquilateralValidator() {
        assertThatIllegalArgumentException().isThrownBy(() -> equilateralValidator.validate(2, 4, 3)).withMessage(NOT_EQUILATERAL);
        assertThatCode(() -> equilateralValidator.validate(1, 1, 1)).doesNotThrowAnyException();
    }

    @Test
    public void testIsoscelesValidator() {
        assertThatIllegalArgumentException().isThrownBy(() -> isoscelesValidator.validate(2, 4, 3)).withMessage(NOT_ISOSCELES);
        assertThatCode(() -> isoscelesValidator.validate(1, 1, 1)).doesNotThrowAnyException();
        assertThatCode(() -> isoscelesValidator.validate(3, 3, 5)).doesNotThrowAnyException();
    }

    @Test
    public void testScaleneValidator() {
        assertThatCode(() -> scaleneValidator.validate(2, 4, 3)).doesNotThrowAnyException();
        assertThatCode(() -> scaleneValidator.validate(1, 1, 1)).doesNotThrowAnyException();
        assertThatCode(() -> scaleneValidator.validate(3, 3, 5)).doesNotThrowAnyException();
    }
}