package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

/**
 * Constants for five times in a night.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see 五更
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S115", "java:S116", "java:S117"})
public enum 五夜 { // 오야

    /**
     * 19: The 1st time between {@code 19:00} and {@code 21:00}.
     *
     * @see 五更#初更
     */
    初夜,

    /**
     * 21: The 2nd time between {@code 21:00} and {@code 23:00}.
     *
     * @see 五更#二更
     */
    乙夜,

    /**
     * 23: The 3rd time between {@code 23:00} and {@code 01:00}.
     *
     * @see 五更#三更
     */
    丙夜,

    /**
     * 25: The 4th time between {@code 01:00} and {@code 03:00}.
     *
     * @see 五更#四更
     */
    丁夜,

    /**
     * 27: The 5th time between {@code 03:00} and {@code 05:00}.
     *
     * @see 五更#五更
     */
    戊夜;

    // -----------------------------------------------------------------------------------------------------------------
    static final Map<五更, 五夜> VALUES_BY_五更S = Collections.unmodifiableMap(
            EnumUtils.mapValuesBy(五夜.class, v -> v.五更, () -> new EnumMap<>(五更.class))
    );

    /**
     * Returns the value associated with specified 五更.
     *
     * @param 五更 the 五更.
     * @return the value associated with {@code 五更}.
     */
    public static 五夜 valueOf(final 五更 五更) {
        Objects.requireNonNull(五更, "五更 is null");
        final 五夜 value = VALUES_BY_五更S.get(五更);
        if (value == null) {
            throw new AssertionError("no value for " + 五更);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the value {@link 時刻#includes(LocalTime) includes} specified time.
     *
     * @param time the time.
     * @return the value includes {@code time}.
     * @throws IllegalArgumentException when no value includes {@code time}.
     */
    public static 五夜 valueOf(final LocalTime time) {
        Objects.requireNonNull(time, "time is null");
        for (final 五夜 value : values()) {
            if (value.includes(time)) {
                return value;
            }
        }
        throw new IllegalArgumentException("no value of " + time);
    }

    // -----------------------------------------------------------------------------------------------------------------
    五夜() {
        五更 = com.github.jinahya.sexagenarycycle.五更.values()[ordinal()];
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Checks whether this 五夜 includes specified time.
     *
     * @param time the time.
     * @return {@code true} if this 五夜 includes {@code time}; {@code false} otherwise.
     */
    public boolean includes(final LocalTime time) {
        return 五更.時刻.includes(Objects.requireNonNull(time, "time is null"));
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final @NotNull 五更 五更;
}
