package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.IntStream;

import static java.util.concurrent.ThreadLocalRandom.current;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
class 時刻Test {

    static 時刻 randomInstance() {
        return new 時刻(TimeTestUtils.randomTime(), Duration.ofMinutes(current().nextInt(0, 1200)));
    }

    @Test
    void test() {
        final 時刻 v = new 時刻(LocalTime.MIDNIGHT, Duration.ofNanos(1L));
        assertThat(v.includes(LocalTime.MIDNIGHT)).isTrue();
        assertThat(v.includes(LocalTime.MIDNIGHT.plus(1L, ChronoUnit.NANOS))).isFalse();
    }

    @Test
    void test_00_24() {
        final 時刻 v = new 時刻(LocalTime.MIDNIGHT, Duration.ofHours(24L));
        assertThat(v.includes(LocalTime.MIDNIGHT)).isTrue();
        assertThat(v.includes(LocalTime.of(0, 0))).isTrue();
        assertThat(v.includes(LocalTime.of(0, 1))).isTrue();
        assertThat(v.includes(LocalTime.of(23, 59))).isTrue();
        assertThat(v.includes(LocalTime.of(23, 59, 59))).isTrue();
        assertThat(v.includes(LocalTime.of(23, 59, 59, 999999999))).isTrue();
    }

    @Test
    void test_23_02() {
        final 時刻 v = new 時刻(LocalTime.of(23, 0), Duration.ofHours(2L));
        assertThat(v.includes(LocalTime.of(22, 59, 59, 999999999))).isFalse();
        assertThat(v.includes(LocalTime.of(23, 0))).isTrue();
        assertThat(v.includes(LocalTime.of(23, 1))).isTrue();
        assertThat(v.includes(LocalTime.of(23, 59))).isTrue();
        assertThat(v.includes(LocalTime.of(0, 0))).isTrue();
        assertThat(v.includes(LocalTime.of(0, 59, 59, 999999999))).isTrue();
        assertThat(v.includes(LocalTime.of(1, 0))).isFalse();
        assertThat(v.includes(LocalTime.of(1, 0, 0, 1))).isFalse();
    }

    @Test
    void test_22_23() {
        final 時刻 v = new 時刻(LocalTime.of(22, 0), Duration.ofHours(23L));
        assertThat(v.includes(LocalTime.of(21, 59, 59, 999999999))).isFalse();
        assertThat(v.includes(LocalTime.of(22, 0))).isTrue();
        assertThat(v.includes(LocalTime.MIDNIGHT)).isTrue();
        IntStream.rangeClosed(1, 20).mapToObj(h -> LocalTime.of(h, 0)).forEach(t -> {
            assertThat(v.includes(t)).isTrue();
        });
        assertThat(v.includes(LocalTime.of(20, 59, 59, 999999999))).isTrue();
        assertThat(v.includes(LocalTime.of(21, 0))).isFalse();
    }

    // -------------------------------------------------------------------------------------------------------- tostring
    @Test
    void toString_NonBlank_Random() {
        assertThat(randomInstance().toString()).isNotBlank();
    }

    // ---------------------------------------------------------------------------------------------------------- equals
    @SuppressWarnings("java:S5838")
    @RepeatedTest(128)
    void equals_True_Self() {
        final 時刻 instance = randomInstance();
        assertThat(instance).isEqualTo(instance);
        //noinspection EqualsWithItself
        assertThat(instance.equals(instance)).isTrue();
    }

    @RepeatedTest(128)
    void equals_True_Copy() {
        final 時刻 instance = randomInstance();
        assertThat(instance).isEqualTo(new 時刻(instance));
    }

    // -------------------------------------------------------------------------------------------------------- hashCode
    @Test
    void hashCode_NoException_() {
        final 時刻 instance = randomInstance();
        Assertions.assertDoesNotThrow(() -> {
            final int hashCode = instance.hashCode();
        });
    }
}