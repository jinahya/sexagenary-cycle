package com.github.jinahya.sexagenarycycle;

import java.time.LocalTime;
import java.time.chrono.IsoChronology;
import java.time.temporal.ChronoField;
import java.time.temporal.ValueRange;
import java.util.Objects;
import java.util.stream.LongStream;
import java.util.stream.Stream;

final class TimeTestUtils {

    static final long minimumMinute;

    static final long maximumMinute;

    static {
        final ValueRange range = IsoChronology.INSTANCE.range(ChronoField.MINUTE_OF_HOUR);
        minimumMinute = range.getMinimum();
        assert minimumMinute == 0L;
        maximumMinute = range.getMaximum();
        assert maximumMinute == 59L;
    }

    /**
     * Returns a stream of valid minutes in an hour which is {@code [0..60)}.
     *
     * @return a stream of valid minutes in an hour.
     */
    static LongStream minutes() {
        return LongStream.rangeClosed(minimumMinute, maximumMinute);
    }

    static Stream<LocalTime> mapMinutes(LocalTime hour) {
        Objects.requireNonNull(hour, "hour is null");
        hour = hour.withMinute(0).withSecond(0).withNano(0);
        return minutes().mapToObj(hour::plusMinutes);
    }

    static Stream<? super LocalTime> mapMinutes(final Stream<? extends LocalTime> hours) {
        Objects.requireNonNull(hours, "times is null");
        return hours.flatMap(TimeTestUtils::mapMinutes);
    }

    private TimeTestUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}