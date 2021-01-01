package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.Objects;

import static com.github.jinahya.sexagenarycycle.時刻.durationOfTwoHours;
import static com.github.jinahya.sexagenarycycle.時刻.localTimeOfTheClock;

/**
 * Constants for five times in a night.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
// https://www.compart.com/en/unicode/block/U+1F300
// https://www.compart.com/en/unicode/U+33C2 (Square Am)
// https://www.compart.com/en/unicode/U+33D8 (Square Pm)
@SuppressWarnings({"NonAsciiCharacters", "java:S115", "java:S116"})
public enum 五更 { // 오경

    /**
     * The 1st time between {@code 19:00} and {@code 21:00}.
     */
    // https://www.compart.com/en/unicode/U+1F556
    // https://www.compart.com/en/unicode/U+1F558 (Clock Face Nine Oclock)
    初更,

    /**
     * The 2nd time between {@code 21:00} and {@code 23:00}.
     */
    // https://www.compart.com/en/unicode/U+1F558
    二更,

    /**
     * The 3rd time between {@code 23:00} and {@code 01:00}.
     */
    三更,

    /**
     * The 4th time between {@code 01:00} and {@code 03:00}.
     */
    四更,

    /**
     * The 5th time between {@code 03:00} and {@code 05:00}.
     */
    五更;

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the value whose {@link #時刻} {@link 時刻#includes(LocalTime) includes} specified time.
     *
     * @param time the time.
     * @return the value includes {@code time}
     * @throws IllegalArgumentException when no value includes {@code time};
     */
    public static 五更 valueOf(final LocalTime time) {
        Objects.requireNonNull(time, "time is null");
        for (final 五更 value : values()) {
            if (value.時刻.includes(time)) {
                return value;
            }
        }
        throw new IllegalArgumentException("no value for " + time);
    }

    // -----------------------------------------------------------------------------------------------------------------
    五更() {
        時刻 = new 時刻(localTimeOfTheClock(19, (long) ordinal() << 1L), durationOfTwoHours());
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The 時刻 associated with this 五更.
     */
    public final @NotNull 時刻 時刻;
}
