package com.github.jinahya.sexagenarycycle;

public class AssignedAssertions {

    static 歲次Assert assertThat(final 歲次 actual) {
        return new 歲次Assert(actual);
    }

    static 月建Assert assertThat(final 月建 actual) {
        return new 月建Assert(actual);
    }

    static 日辰Assert assertThat(final 日辰 actual) {
        return new 日辰Assert(actual);
    }

    private AssignedAssertions() {
        throw new AssertionError("instantiation is not allowed");
    }
}
