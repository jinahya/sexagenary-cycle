package com.github.jinahya.sexagenarycycle;

import java.time.LocalTime;
import java.time.chrono.IsoChronology;
import java.time.temporal.ChronoField;
import java.time.temporal.ValueRange;
import java.util.Objects;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.concurrent.ThreadLocalRandom.current;

final class TimeTestUtils {

    // -----------------------------------------------------------------------------------------------------------------
    static final long MINIMUM_HOUR_OF_DAY;

    static final long MAXIMUM_HOUR_OF_DAY;

    static {
        final ValueRange range = IsoChronology.INSTANCE.range(ChronoField.HOUR_OF_DAY);
        MINIMUM_HOUR_OF_DAY = range.getMinimum();
        assert MINIMUM_HOUR_OF_DAY == 0L;
        MAXIMUM_HOUR_OF_DAY = range.getMaximum();
        assert MAXIMUM_HOUR_OF_DAY == 23L;
    }

    static int randomHourOfDay() {
        return (int) current().nextLong(MINIMUM_HOUR_OF_DAY, MAXIMUM_HOUR_OF_DAY + 1);
    }

    // -----------------------------------------------------------------------------------------------------------------
    static final long MINIMUM_MINUTE_OF_HOUR;

    static final long MAXIMUM_MINUTE_OF_HOUR;

    static {
        final ValueRange range = IsoChronology.INSTANCE.range(ChronoField.MINUTE_OF_HOUR);
        MINIMUM_MINUTE_OF_HOUR = range.getMinimum();
        assert MINIMUM_MINUTE_OF_HOUR == 0L;
        MAXIMUM_MINUTE_OF_HOUR = range.getMaximum();
        assert MAXIMUM_MINUTE_OF_HOUR == 59L;
    }

    static int randomMinuteOfHour() {
        return (int) current().nextLong(MINIMUM_HOUR_OF_DAY, MAXIMUM_HOUR_OF_DAY + 1);
    }

    // -----------------------------------------------------------------------------------------------------------------
    static final long MINIMUM_SECOND_OF_MINUTE;

    static final long MAXIMUM_SECOND_OF_MINUTE;

    static {
        final ValueRange range = IsoChronology.INSTANCE.range(ChronoField.SECOND_OF_MINUTE);
        MINIMUM_SECOND_OF_MINUTE = range.getMinimum();
        assert MINIMUM_SECOND_OF_MINUTE == 0L;
        MAXIMUM_SECOND_OF_MINUTE = range.getMaximum();
        assert MAXIMUM_SECOND_OF_MINUTE == 59L;
    }

    static int randomSecondOfMinute() {
        return (int) current().nextLong(MINIMUM_SECOND_OF_MINUTE, MAXIMUM_SECOND_OF_MINUTE + 1);
    }

    // -----------------------------------------------------------------------------------------------------------------
    static final long MINIMUM_NANO_OF_MINUTE;

    static final long MAXIMUM_NANO_OF_MINUTE;

    static {
        final ValueRange range = IsoChronology.INSTANCE.range(ChronoField.NANO_OF_SECOND);
        MINIMUM_NANO_OF_MINUTE = range.getMinimum();
        assert MINIMUM_NANO_OF_MINUTE == 0L;
        MAXIMUM_NANO_OF_MINUTE = range.getMaximum();
        assert MAXIMUM_NANO_OF_MINUTE == 999_999_999L;
    }

    static int randomNanoOfSecond() {
        return (int) current().nextLong(MINIMUM_NANO_OF_MINUTE, MAXIMUM_NANO_OF_MINUTE + 1);
    }

    // -----------------------------------------------------------------------------------------------------------------
    static LocalTime randomLocalTime() {
        return LocalTime.of(randomHourOfDay(), randomMinuteOfHour(), randomSecondOfMinute(), randomNanoOfSecond());
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns a stream of valid minutes in an hour which is {@code [0..60)}.
     *
     * @return a stream of valid minutes in an hour.
     */
    static LongStream minutes() {
        return LongStream.rangeClosed(MINIMUM_MINUTE_OF_HOUR, MAXIMUM_MINUTE_OF_HOUR);
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

    // -----------------------------------------------------------------------------------------------------------------
    private TimeTestUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}