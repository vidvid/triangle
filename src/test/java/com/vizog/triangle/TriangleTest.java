package com.vizog.triangle;

import org.junit.Test;

import static com.vizog.triangle.model.TriangleType.*;
import static org.assertj.core.api.Assertions.*;
import static com.vizog.triangle.model.TriangleFactory.bySideLengths;
public class TriangleTest {

    @Test
    public void testTypes() {
        assertThat(bySideLengths(1, 1, 1).getType()).isEqualTo(EQUILATERAL);
        assertThat(bySideLengths(2, 1, 2).getType()).isEqualTo(ISOSCELES);
        assertThat(bySideLengths(2, 3, 4).getType()).isEqualTo(SCALENE);
    }





}