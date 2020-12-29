package com.github.jinahya.sexagenarycycle;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings({"NonAsciiCharacters", "java:S115", "java:S116"})
public enum 五更 { // 오경

    /**
     * Represents the time between {@code 19:00} and {@code 21:00}.
     */
    初更,

    /**
     * Represents the time between {@code 21:00} and {@code 23:00}.
     */
    二更,

    /**
     * Represents the time between {@code 23:00} and {@code 01:00}.
     */
    三更,

    /**
     * Represents the time between {@code 01:00} and {@code 03:00}.
     */
    四更,

    /**
     * Represents the time between {@code 03:00} and {@code 05:00}.
     */
    五更;

    // -----------------------------------------------------------------------------------------------------------------
    static final Map<Integer, 五更> VALUES_BY_ORDINALS
            = Collections.unmodifiableMap(EnumUtils.mapValuesByOrdinals(五更.class));

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the value {@link #includes(LocalTime) includes} specified time.
     *
     * @param time the time.
     * @return the value includes {@code time}
     * @throws IllegalArgumentException when no value includes {@code time};
     */
    public static 五更 valueIncludes(final LocalTime time) {
        Objects.requireNonNull(time, "time is null");
        for (final 五更 value : values()) {
            if (value.includes(time)) {
                return value;
            }
        }
        throw new IllegalArgumentException("no value includes " + time);
    }

    // -----------------------------------------------------------------------------------------------------------------
    五更() {
        時刻 = new 時刻(LocalTime.of(19, 0).plus(Duration.ofHours((long) ordinal() << 1L)), Duration.ofHours(2L));
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Checks whether {@link 時刻} includes specified time.
     *
     * @param time the time.
     * @return {@code true} if this {@link 時刻} includes {@code time}; {@code false} otherwise.
     * @see 時刻#includes(LocalTime)
     */
    public boolean includes(final LocalTime time) {
        return 時刻.includes(Objects.requireNonNull(time, "time is null"));
    }

    // -----------------------------------------------------------------------------------------------------------------
    public final 時刻 時刻;
}
