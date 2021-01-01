package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Constants for 24 cardinal directions.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://en.wikipedia.org/wiki/Earthly_Branches#Directions">Directions (Earthly Branches)
 * (Wikipedia)</a>
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S115", "java:S3577"})
public enum 二十四方 implements RotatingEnum<二十四方> {

    /**
     * 00: Indicates {@code 0°} (north).
     */
    子,

    /**
     * 01: Indicates {@code 15°}.
     */
    癸,

    /**
     * 02: Indicates {@code 30°}.
     */
    丑,

    /**
     * 03: Indicates {@code 45°}.
     */
    艮, // 易經

    /**
     * 04: Indicates {@code 60°}.
     */
    寅,

    /**
     * 05: Indicates {@code 75°}.
     */
    甲,

    /**
     * 06: Indicates {@code 90°}.
     */
    卯,

    /**
     * 07: Indicates {@code 105°}.
     */
    乙,

    /**
     * 08: Indicates {@code 120°}.
     */
    辰,

    /**
     * 09: Indicates {@code 135°}.
     */
    巽, // 易經

    /**
     * 0A: Indicates {@code 150°}.
     */
    巳,

    /**
     * 0B: Indicates {@code 165°}.
     */
    丙,

    /**
     * 0C: Indicates {@code 180°}.
     */
    午,

    /**
     * 0D: Indicates {@code 195°}.
     */
    丁,

    /**
     * 0F: Indicates {@code 210°}.
     */
    未,

    /**
     * 10: Indicates {@code 225°}.
     */
    坤, // 易經

    /**
     * 11: Indicates {@code 240°}.
     */
    申,

    /**
     * 12: Indicates {@code 255°}.
     */
    庚,

    /**
     * 13: Indicates {@code 270°}.
     */
    酉,

    /**
     * 14: Indicates {@code 285°}.
     */
    辛,

    /**
     * 15: Indicates {@code 300°}.
     */
    戌,

    /**
     * 16: Indicates {@code 315°} (northwest).
     */
    乾, // 易經

    /**
     * 17: Indicates {@code 330°}.
     */
    亥,

    /**
     * 18: Indicates {@code 345°}.
     */
    壬;

    // -----------------------------------------------------------------------------------------------------------------
    private static final List<二十四方> VALUES = Arrays.asList(values());

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<Integer, 二十四方> VALUES_BY_DIRECTIONS
            = Collections.unmodifiableMap(EnumUtils.mapValuesBy(二十四方.class, v -> v.direction));

    public static 二十四方 valueOfDirection(final int direction, final boolean exact) {
        final int d = (direction % 360) + (direction < 0 ? 360 : 0);
        if (exact) {
            return Optional.ofNullable(VALUES_BY_DIRECTIONS.get(d % 360))
                    .orElseThrow(() -> new IllegalArgumentException("no value for (exact) direction: " + direction));
        } else {
            return VALUES.get(Math.round(d / 15.0f) % VALUES.size());
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    二十四方() {
        direction = ordinal() * 15;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The cardinal direction of this 二十四方 in {@code [0..360)°}.
     */
    @Max(345)
    @Min(0)
    public final int direction;
}
