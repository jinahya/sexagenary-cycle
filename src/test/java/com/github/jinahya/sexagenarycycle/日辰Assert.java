package com.github.jinahya.sexagenarycycle;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class 日辰Assert extends AssignedAssert<日辰Assert, 日辰> {

    日辰Assert(日辰 actual) {
        super(日辰.class, actual, 日辰Assert.class);
    }

    public 日辰Assert hasDayOfMonth(final int dayOfMonth) {
        isNotNull();
        assertThat(actual.日).isSameAs(dayOfMonth);
        return this;
    }
}
