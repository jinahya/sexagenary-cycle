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
public enum 二十四方 implements RollingEnum<二十四方> {

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

    寅,

    甲,

    卯,

    乙,

    辰,

    巽, // 易經

    巳,

    丙,

    午,

    丁,

    未,

    坤, // 易經

    申,

    庚,

    酉,

    辛,

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
