package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

interface RotatingTest<T extends Rotating<T>> {

    T[] values();

    @Test
    default void getPrevious_NonNull_() {
        for (final T value : values()) {
            assertThat(value.getPrevious()).isNotNull();
            assertThat(value.getPrevious()).isNotNull();
        }
    }

    @Test
    default void getNext_NonNull_() {
        for (final T value : values()) {
            assertThat(value.getNext()).isNotNull();
            assertThat(value.getNext()).isNotNull();
        }
    }
}
