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
 * @see <a href="https://en.wikipedia.org/wiki/Earthly_Branches#Directions">Directions (Earthly Branches)</a>
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S115", "java:S3577"})
public enum 二十四方 implements RotatingEnum<二十四方> {

    /**
     * Indicates {@code 0°} (north).
     */
    子,

    /**
     * Indicates {@code 15°}.
     */
    癸,

    /**
     * Indicates {@code 30°}.
     */
    丑,

    /**
     * Indicates {@code 45°}.
     */
    艮, // 易經

    /**
     * Indicates {@code 60°}.
     */
    寅,

    /**
     * Indicates {@code 75°}.
     */
    甲,

    /**
     * Indicates {@code 90°}.
     */
    卯,

    /**
     * Indicates {@code 105°}.
     */
    乙,

    /**
     * Indicates {@code 120°}.
     */
    辰,

    /**
     * Indicates {@code 135°}.
     */
    巽, // 易經

    /**
     * Indicates {@code 150°}.
     */
    巳,

    /**
     * Indicates {@code 165°}.
     */
    丙,

    /**
     * Indicates {@code 180°}.
     */
    午,

    /**
     * Indicates {@code 195°}.
     */
    丁,

    /**
     * Indicates {@code 210°}.
     */
    未,

    /**
     * Indicates {@code 225°}.
     */
    坤, // 易經

    /**
     * Indicates {@code 240°}.
     */
    申,

    /**
     * Indicates {@code 255°}.
     */
    庚,

    /**
     * Indicates {@code 270°}.
     */
    酉,

    /**
     * Indicates {@code 285°}.
     */
    辛,

    /**
     * Indicates {@code 300°}.
     */
    戌,

    /**
     * Indicates {@code 315°} (northwest).
     */
    乾, // 易經

    /**
     * Indicates {@code 330°}.
     */
    亥,

    /**
     * Indicates {@code 345°}.
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
