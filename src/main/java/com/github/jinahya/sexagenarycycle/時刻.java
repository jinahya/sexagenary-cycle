package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * &#x231A; Represents a time between two specific local times in a day.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S101", "java:S117"})
public final class 時刻 { // 시각

    static Duration durationOfTwoHours() {
        return Duration.ofHours(2L);
    }

    static LocalTime localTimeOfTheClock(final int hour) {
        return LocalTime.of(hour, 0);
    }

    static LocalTime localTimeOfTheClock(final int hour, final long hoursToAdd) {
        return localTimeOfTheClock(hour).plusHours(hoursToAdd);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static long nanos(final LocalTime time, final boolean leap) {
        return ChronoUnit.NANOS.between(LocalTime.MIDNIGHT, time) + (leap ? Duration.ofHours(24L).toNanos() : 0L);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance with specified time and duration.
     *
     * @param base     the staring time.
     * @param duration the duration of the time.
     * @throws IllegalArgumentException when {@code duration} is greater than {@code PT24H}.
     */
    public 時刻(final LocalTime base, final Duration duration) {
        super();
        this.base = Objects.requireNonNull(base, "time is null");
        if (Objects.requireNonNull(duration, "duration is null").compareTo(Duration.ofHours(24L)) > 0) {
            throw new IllegalArgumentException("duration(" + duration + ") > PH24H");
        }
        nanos = nanos(this.base, false) + duration.toNanos();
    }

    /**
     * Creates a new instance coping specified instance.
     *
     * @param 時刻 the instance to copy.
     */
    public 時刻(final 時刻 時刻) {
        this(Objects.requireNonNull(時刻, "時刻 is null").base, 時刻.duration());
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns a string representation of this object.
     *
     * @return a string representation of this object.
     */
    @Override
    public String toString() {
        return super.toString() + '{'
               + "base=" + base
               + ",nanos=" + nanos
               + '}';
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final 時刻 casted = (時刻) obj;
        return nanos == casted.nanos && base.equals(casted.base);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(base, nanos);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Checks whether this 時刻 includes specified time.
     *
     * @param time the time to check.
     * @return {@code true} if this time includes {@code time}; {@code false} otherwise.
     */
    public boolean includes(final LocalTime time) {
        Objects.requireNonNull(time, "time is null");
        return nanos(time, time.isBefore(base)) < nanos;
    }

    // -----------------------------------------------------------------------------------------------------------------
    Duration duration() {
        return Duration.ofNanos(nanos - ChronoUnit.NANOS.between(LocalTime.MIDNIGHT, base));
    }

    // -----------------------------------------------------------------------------------------------------------------
    final @NotNull LocalTime base;

    private final @PositiveOrZero long nanos;
}
