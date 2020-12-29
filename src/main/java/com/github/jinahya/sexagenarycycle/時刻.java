package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * Represents a time between two specific local times in a day.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S101"})
public final class 時刻 { // 시각

    public static Duration forTwoHours() {
        return Duration.ofHours(2L);
    }

    public static 時刻 newInstanceForTwoHoursFrom(final int hour) {
        return new 時刻(LocalTime.of(hour, 0), forTwoHours());
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static long limit(final LocalTime time, final boolean leap) {
        return ChronoUnit.NANOS.between(LocalTime.MIDNIGHT, time) + (leap ? Duration.ofHours(24L).toNanos() : 0L);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance with specified time and duration.
     *
     * @param time     the staring time.
     * @param duration the duration of the time.
     * @throws IllegalArgumentException when {@code duration} is greater than {@code PT24H}.
     */
    public 時刻(final LocalTime time, final Duration duration) {
        super();
        this.time = Objects.requireNonNull(time, "time is null");
        if (Objects.requireNonNull(duration, "duration is null").compareTo(Duration.ofHours(24L)) > 0) {
            throw new IllegalArgumentException("duration(" + duration + ") > PH24H");
        }
        limit = limit(this.time, false) + duration.toNanos();
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Checks whether this time includes specified time.
     *
     * @param time the time to check.
     * @return {@code true} if this time includes {@code time}; {@code false} otherwise.
     */
    public boolean includes(final LocalTime time) {
        Objects.requireNonNull(time, "time is null");
        return limit(time, time.isBefore(this.time)) < this.limit;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    final LocalTime time;

    private final long limit;
}
