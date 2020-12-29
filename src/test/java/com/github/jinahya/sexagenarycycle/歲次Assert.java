package com.github.jinahya.sexagenarycycle;

import java.time.Year;

import static java.util.Objects.requireNonNull;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class 歲次Assert extends AssignedAssert<歲次Assert, 歲次> {

    歲次Assert(final 歲次 actual) {
        super(歲次.class, actual, 歲次Assert.class);
    }

    歲次Assert hasYear(final Year year) {
        requireNonNull(year, "year is null");
        isNotNull();
        assertThat(actual.年).isEqualTo(year);
        return this;
    }

    歲次Assert hasYear(final int year) {
        return hasYear(Year.of(year));
    }

    歲次Assert hasSameYearAsThatOf(final 歲次 歲次) {
        requireNonNull(歲次, "歲次 is null");
        return hasYear(歲次.年);
    }
}
