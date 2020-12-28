package com.github.jinahya.sexagenarycycle;

import java.util.Map;
import java.util.Optional;

import static com.github.jinahya.sexagenarycycle.Utils.mapValuesBy;
import static com.github.jinahya.sexagenarycycle.Utils.mapValuesByOrdinals;
import static java.util.Collections.unmodifiableMap;

/**
 * Represents 24 directions.
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@SuppressWarnings("NonAsciiCharacters")
public enum 二十四方 implements RollingEnum<二十四方> {

    @SuppressWarnings({"java:S115"})
    子,

    @SuppressWarnings({"java:S115"})
    癸,

    @SuppressWarnings({"java:S115"})
    丑,

    @SuppressWarnings({"java:S115"})
    艮, // 易經

    @SuppressWarnings({"java:S115"})
    寅,

    @SuppressWarnings({"java:S115"})
    甲,

    @SuppressWarnings({"java:S115"})
    卯,

    @SuppressWarnings({"java:S115"})
    乙,

    @SuppressWarnings({"java:S115"})
    辰,

    @SuppressWarnings({"java:S115"})
    巽, // 易經

    @SuppressWarnings({"java:S115"})
    巳,

    @SuppressWarnings({"java:S115"})
    丙,

    @SuppressWarnings({"java:S115"})
    午,

    @SuppressWarnings({"java:S115"})
    丁,

    @SuppressWarnings({"java:S115"})
    未,

    @SuppressWarnings({"java:S115"})
    坤, // 易經

    @SuppressWarnings({"java:S115"})
    申,

    @SuppressWarnings({"java:S115"})
    庚,

    @SuppressWarnings({"java:S115"})
    酉,

    @SuppressWarnings({"java:S115"})
    辛,

    @SuppressWarnings({"java:S115"})
    戌,

    @SuppressWarnings({"java:S115"})
    乾, // 易經

    @SuppressWarnings({"java:S115"})
    亥,

    @SuppressWarnings({"java:S115"})
    壬;

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<Integer, 二十四方> VALUES_BY_ORDINALS = unmodifiableMap(mapValuesByOrdinals(二十四方.class));

    static 二十四方 valueOfOrdinal(final int ordinal) {
        final int i = (ordinal % 24) + (ordinal < 0 ? 24 : 0);
        final 二十四方 value = VALUES_BY_ORDINALS.get(i);
        if (value == null) {
            throw new AssertionError("invalid index(" + i + ") calculated from " + ordinal);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<Integer, 二十四方> VALUES_BY_DIRECTIONS
            = unmodifiableMap(mapValuesBy(二十四方.class, v -> v.direction));

    public static 二十四方 valueOfDirection(final int direction, final boolean exact) {
        final int d = (direction % 360) + (direction < 0 ? 360 : 0);
        if (exact) {
            return Optional.ofNullable(VALUES_BY_DIRECTIONS.get(d % 360))
                    .orElseThrow(() -> new IllegalArgumentException("no value for direction " + direction));
        } else {
            final int index = Math.round(d / 15.0f);
            return valueOfOrdinal(index);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    二十四方() {
        direction = ordinal() * 15;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public final int direction;
}
