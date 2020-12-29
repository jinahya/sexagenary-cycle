package com.github.jinahya.sexagenarycycle;

import org.assertj.core.api.AbstractAssert;

import java.time.LocalTime;

import static java.util.Objects.requireNonNull;

@SuppressWarnings("NonAsciiCharacters")
class 時刻Assert extends AbstractAssert<時刻Assert, 時刻> {

    public static 時刻Assert assertThat(final 時刻 actual) {
        return new 時刻Assert(actual);
    }

    public 時刻Assert(final 時刻 actual) {
        super(actual, 時刻Assert.class);
    }

    public 時刻Assert hasTime(final LocalTime expected) {
        requireNonNull(expected, "time is null");
        isNotNull();
        if (!actual.time.equals(expected)) {
            failWithMessage("expected time to be <%d> but was <%d>", expected, actual.time);
        }
        return this;
    }

    public 時刻Assert hasTimeOfHour(final int hour) {
        return hasTime(LocalTime.of(hour, 0));
    }
}
