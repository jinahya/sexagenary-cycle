package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
class 五夜Test {

    // ----------------------------------------------------------------------------------------------------- valueOf(五更)
    @DisplayName("valueOf(五更) returns non-null for each 五更")
    @Test
    void valueOf五更_NonNull_ForEach五更() {
        for (final 五更 五更 : 五更.values()) {
            assertThat(五夜.valueOf(五更)).isNotNull();
        }
    }

    // ---------------------------------------------------------------------------------------------- valueOf(LocalTime)
    @DisplayName("valueOf(time) throws IllegalArgumentException when time is between 05:00 and 19:00")
    @Test
    void valueOfLocalTime_IllegalArgumentException_TimeIsBetween0500And1900() {
        // total iteration count = 14 * 60;
        IntStream.range(5, 19)
                .mapToObj(h -> LocalTime.of(h, 0))
                .flatMap(TimeTestUtils::mapMinutes)
                .forEach(t -> {
                    assertThatThrownBy(() -> 五夜.valueIncludes(t)).isInstanceOf(IllegalArgumentException.class);
                })
        ;
    }

    @DisplayName("valueOf(time) returns non-null when time is between 19:00 and 05:00")
    @Test
    void valueOfLocalTime_NonNull_TimeIsBetween1900And0500() {
        // total iteration count = 10 * 60;
        LongStream.range(0L, 10L)
                .mapToObj(h -> LocalTime.of(19, 0).plusHours(h))
                .flatMap(TimeTestUtils::mapMinutes)
                .map(五夜::valueIncludes)
                .forEach(v -> {
                    assertThat(v).isNotNull();
                })
        ;
    }
}