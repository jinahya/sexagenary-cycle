package com.github.jinahya.sexagenarycycle;

import java.time.LocalTime;

import static java.util.Objects.requireNonNull;

public enum 五夜 { // 오야

    /**
     * Represents the time between {@code 19:00} and {@code 21:00}.
     */
    初夜(com.github.jinahya.sexagenarycycle.五更.初更),

    /**
     * Represents the time between {@code 21:00} and {@code 23:00}.
     */
    乙夜(com.github.jinahya.sexagenarycycle.五更.二更),

    /**
     * Represents the time between {@code 23:00} and {@code 01:00}.
     */
    丙夜(com.github.jinahya.sexagenarycycle.五更.三更),

    /**
     * Represents the time between {@code 01:00} and {@code 03:00}.
     */
    丁夜(com.github.jinahya.sexagenarycycle.五更.四更),

    /**
     * Represents the time between {@code 03:00} and {@code 05:00}.
     */
    戊夜(com.github.jinahya.sexagenarycycle.五更.五更);

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the value {@link #includes(LocalTime) includes} specified time.
     *
     * @param time the time.
     * @return the value includes {@code time}
     * @throws IllegalArgumentException when no value includes {@code time};
     */
    public static 五夜 valueOf(final LocalTime time) {
        for (final 五夜 value : values()) {
            if (value.includes(time)) {
                return value;
            }
        }
        throw new IllegalArgumentException("no value of " + time);
    }

    // -----------------------------------------------------------------------------------------------------------------
    五夜(final 五更 五更) {
        this.五更 = requireNonNull(五更, "五更 is null");
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Checks whether this 時刻 includes specified time.
     *
     * @param time the time.
     * @return {@code true} if this 時刻 includes {@coee time}; {@code false} otherwise.
     * @see 五更#includes(LocalTime)
     */
    public boolean includes(final LocalTime time) {
        return 五更.時刻.includes(requireNonNull(time, "time is null"));
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final 五更 五更;
}
