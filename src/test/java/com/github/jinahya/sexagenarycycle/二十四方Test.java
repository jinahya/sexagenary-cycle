package com.github.jinahya.sexagenarycycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
class 二十四方Test implements RollingEnumTest<二十四方> {

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void valueOfIndex_NonNullExpected_NegativeOne() {
        assertThat(二十四方.valueOfOrdinal(-1)).isNotNull().isSameAs(二十四方.壬);
    }

    @Test
    void valueOfIndex_NonNullExpected_NegativeTwo() {
        assertThat(二十四方.valueOfOrdinal(-2)).isNotNull().isSameAs(二十四方.亥);
    }

    // ---------------------------------------------------------------------------------- valueOfDirection(I,B)L...二十四方;
    @Test
    void valueOfDirection_NonNullExpected() {
        {
            assertThat(二十四方.valueOfDirection(-721, false)).isNotNull().isSameAs(二十四方.子);
            assertThat(二十四方.valueOfDirection(-720, true)).isNotNull().isSameAs(二十四方.子);
            assertThat(二十四方.valueOfDirection(-719, false)).isNotNull().isSameAs(二十四方.子);
        }
        assertThat(二十四方.valueOfDirection(-360, true)).isNotNull().isSameAs(二十四方.子);
        assertThat(二十四方.valueOfDirection(-15, true)).isNotNull().isSameAs(二十四方.壬);
        {
            assertThat(二十四方.valueOfDirection(-14, false)).isNotNull().isSameAs(二十四方.壬);
            assertThat(二十四方.valueOfDirection(-8, false)).isNotNull().isSameAs(二十四方.壬);
            assertThat(二十四方.valueOfDirection(-7, false)).isNotNull().isSameAs(二十四方.子);
            assertThat(二十四方.valueOfDirection(-1, false)).isNotNull().isSameAs(二十四方.子);
            assertThat(二十四方.valueOfDirection(0, true)).isNotNull().isSameAs(二十四方.子);
            assertThat(二十四方.valueOfDirection(1, false)).isNotNull().isSameAs(二十四方.子);
            assertThat(二十四方.valueOfDirection(7, false)).isNotNull().isSameAs(二十四方.子);
            assertThat(二十四方.valueOfDirection(8, false)).isNotNull().isSameAs(二十四方.癸);
        }
        assertThat(二十四方.valueOfDirection(15, true)).isNotNull().isSameAs(二十四方.癸);
        {
            assertThat(二十四方.valueOfDirection(Integer.MIN_VALUE, false)).isNotNull();
            assertThat(二十四方.valueOfDirection(Integer.MAX_VALUE, false)).isNotNull();
        }
    }

    // ------------------------------------------------------------------------------------------------------- direction
    @Test
    void direction_OrdinalTimes15() {
        for (final 二十四方 value : 二十四方.values()) {
            assertThat(value.direction).isEqualTo(value.ordinal() * 15);
        }
    }
}