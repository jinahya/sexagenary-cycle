package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static java.util.Objects.requireNonNull;

@SuppressWarnings("NonAsciiCharacters")
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
    public 時刻(final LocalTime time, final Duration duration) {
        super();
        this.time = requireNonNull(time, "time is null");
        if (requireNonNull(duration, "duration is null").compareTo(Duration.ofHours(24L)) > 0) {
            throw new IllegalArgumentException("duration(" + duration + ") > PH24H");
        }
        limit = limit(this.time, false) + duration.toNanos();
    }

    // -----------------------------------------------------------------------------------------------------------------
    public boolean includes(final LocalTime time) {
        requireNonNull(time, "time is null");
        return limit(time, time.isBefore(this.time)) < this.limit;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    final LocalTime time;

    private final long limit;
}
