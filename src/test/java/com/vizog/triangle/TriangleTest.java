package com.vizog.triangle;

import org.junit.Test;

import static com.vizog.triangle.TriangleType.*;
import static org.assertj.core.api.Assertions.*;

public class TriangleTest {

    @Test
    public void testWithInvalidInput() {
        assertThatIllegalArgumentException().isThrownBy(() -> triangle(0, 0, 0)).withMessage("invalid input for sides");
        assertThatIllegalArgumentException().isThrownBy(() -> triangle(0, 1, 2)).withMessage("invalid input for sides");
        assertThatIllegalArgumentException().isThrownBy(() -> triangle(1, 0, 2)).withMessage("invalid input for sides");
        assertThatIllegalArgumentException().isThrownBy(() -> triangle(1, 1, 0)).withMessage("invalid input for sides");
        assertThatIllegalArgumentException().isThrownBy(() -> triangle(-1, 4, 2)).withMessage("invalid input for sides");
    }


    @Test
    public void testWithNonMatchingSides() {
        assertThatIllegalArgumentException().isThrownBy(() -> triangle(1, 1, 2)).withMessage("side lengths don't match for a triangle");
        assertThatIllegalArgumentException().isThrownBy(() -> triangle(1, 2, 1)).withMessage("side lengths don't match for a triangle");
        assertThatIllegalArgumentException().isThrownBy(() -> triangle(2, 1, 1)).withMessage("side lengths don't match for a triangle");
        assertThatCode(() -> triangle(1, 1, 1)).doesNotThrowAnyException();
    }

    @Test
    public void testTypes() {
        assertThat(triangle(1, 1, 1).getType()).isEqualTo(EQUILATERAL);
        assertThat(triangle(2, 1, 2).getType()).isEqualTo(ISOSCELES);
        assertThat(triangle(2, 3, 4).getType()).isEqualTo(SCALENE);
    }
    

    //helper method for more readable tests
    private Triangle triangle(int a, int b, int c) {
        return TriangleFactory.bySideLengths(a, b, c);
    }

}