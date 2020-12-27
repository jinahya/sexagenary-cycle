package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.util.EnumSet;
import java.util.Set;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class 五更Test {

    @DisplayName("valueOf(time) throws IllegalArgumentException when time is out of valid range")
    @Test
    void valueOf_IllegalArgumentException_TimeOutOfRange() {
        IntStream.range(5, 19).mapToObj(h -> LocalTime.of(h, 0)).forEach(t -> {
            assertThatThrownBy(() -> 五更.valueOf(t))
                    .isInstanceOf(IllegalArgumentException.class);
        });
        assertThatThrownBy(() -> 五更.valueOf(LocalTime.of(18, 59, 59, 999999999)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("valueOf(time) returns non-null")
    @Test
    void valueOf_NonNullUnique_ForEachStaringHours() {
        final Set<五更> set = EnumSet.noneOf(五更.class);
        IntStream.range(0, 5)
                .mapToObj(i -> LocalTime.of(19, 0).plus(Duration.ofHours((long) i << 1L)))
                .forEach(t -> {
                    assertThat(五更.valueOf(t)).isNotNull().satisfies(v -> {
                        assertThat(set.add(v)).isTrue();
                    });
                });
    }
}