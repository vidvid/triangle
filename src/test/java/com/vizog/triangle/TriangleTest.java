package com.vizog.triangle;

import org.junit.Test;

import static com.vizog.triangle.model.Messages.INVALID_INPUT;
import static com.vizog.triangle.model.Messages.NON_MATCHING_SIDES;
import static com.vizog.triangle.model.Messages.NOT_EQUILATERAL;
import static com.vizog.triangle.model.TriangleType.*;
import static org.assertj.core.api.Assertions.*;

import com.vizog.triangle.model.TriangleFactory;

public class TriangleTest {

    @Test
    public void testTypes() {
        assertThat(TriangleFactory.bySideLengths(1, 1, 1).getType()).isEqualTo(EQUILATERAL);
        assertThat(TriangleFactory.bySideLengths(2, 1, 2).getType()).isEqualTo(ISOSCELES);
        assertThat(TriangleFactory.bySideLengths(2, 3, 4).getType()).isEqualTo(SCALENE);
    }

    @Test
    public void testExceptions() {
        assertThatIllegalArgumentException().isThrownBy(() -> TriangleFactory.isosceles(0, 1, 2)).withMessage(INVALID_INPUT);
        assertThatIllegalArgumentException().isThrownBy(() -> TriangleFactory.isosceles(1, 1, 2)).withMessage(NON_MATCHING_SIDES);
        assertThatIllegalArgumentException().isThrownBy(() -> TriangleFactory.equilateral(3, 3, 4)).withMessage(NOT_EQUILATERAL);
    }


}