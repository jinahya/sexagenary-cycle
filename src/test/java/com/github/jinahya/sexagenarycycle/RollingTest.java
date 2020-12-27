package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

interface RollingTest<T extends Rolling<T>> {

    T[] values();

    @Test
    default void getPrevious_NonNull_() {
        for (final T value : values()) {
            assertThat(value.getPrevious()).isNotNull().satisfies(v -> {
                assertThat(v.getNext()).isNotNull().isEqualTo(value);
            });
        }
    }

    @Test
    default void getNext_NonNull_() {
        for (final T value : values()) {
            assertThat(value.getNext()).isNotNull().satisfies(v -> {
                assertThat(v.getPrevious()).isNotNull().isEqualTo(value);
            });
        }
    }
}
