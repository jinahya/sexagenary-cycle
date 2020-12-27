package com.github.jinahya.sexagenarycycle;

import org.assertj.core.api.AbstractAssert;

class 二十四方Assert extends AbstractAssert<二十四方Assert, 二十四方> {

    // -----------------------------------------------------------------------------------------------------------------
    public static 二十四方Assert assertThat(final 二十四方 actual) {
        return new 二十四方Assert(actual);
    }

    public static 二十四方Assert assertThatValueOf(final 天干 天干) {
        return assertThat(天干二十四方.valueOf(天干));
    }

    public static 二十四方Assert assertThatValueOf(final 地支 地支) {
        return assertThat(地支二十四方.valueOf(地支));
    }

    // -----------------------------------------------------------------------------------------------------------------
    private 二十四方Assert(final 二十四方 actual) {
        super(actual, 二十四方Assert.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    public 二十四方Assert hasDirection(final int expected) {
        isNotNull();
        if (actual.direction != expected) {
            failWithMessage("expected direction to be <%d> but was <%d>", expected, actual.direction);
        }
        return this;
    }
}
