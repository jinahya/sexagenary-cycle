package com.github.jinahya.sexagenarycycle;

import java.time.Month;

import static java.util.Objects.requireNonNull;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class 月建Assert extends AssignedAssert<月建Assert, 月建> {

    月建Assert(月建 actual) {
        super(月建.class, actual, 月建Assert.class);
    }

    public 月建Assert hasMonth(final Month month) {
        requireNonNull(month, "month is null");
        isNotNull();
        assertThat(actual.月).isSameAs(month);
        return this;
    }

    public 月建Assert isLeapMonth() {
        isNotNull();
        assertThat(actual.is閏月()).isTrue();
        return this;
    }

    public 月建Assert isNotLeapMonth() {
        isNotNull();
        assertThat(actual.is閏月()).isFalse();
        return this;
    }
}
