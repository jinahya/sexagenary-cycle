package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

/**
 * Constants for <a href="https://en.wikipedia.org/wiki/Chinese_zodiac">Chinese zodiac</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://zh.wikipedia.org/wiki/%E7%94%9F%E8%82%96">生肖</a>
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S115", "java:S116", "java:S117"})
public enum 生肖 {

    /**
     * Rat.
     */
    鼠(com.github.jinahya.sexagenarycycle.地支.子),

    /**
     * Ox.
     */
    牛(com.github.jinahya.sexagenarycycle.地支.丑),

    /**
     * Tiger.
     */
    虎(com.github.jinahya.sexagenarycycle.地支.寅),

    /**
     * Rabbit.
     */
    兔(com.github.jinahya.sexagenarycycle.地支.卯),

    /**
     * Dragon.
     */
    龙(com.github.jinahya.sexagenarycycle.地支.辰),

    /**
     * Snake.
     */
    蛇(com.github.jinahya.sexagenarycycle.地支.巳),

    /**
     * Horse.
     */
    马(com.github.jinahya.sexagenarycycle.地支.午),

    /**
     * Goat.
     */
    羊(com.github.jinahya.sexagenarycycle.地支.未),

    /**
     * Monkey.
     */
    猴(com.github.jinahya.sexagenarycycle.地支.申),

    /**
     * Rooster.
     */
    鸡(com.github.jinahya.sexagenarycycle.地支.酉),

    /**
     * Dog.
     */
    狗(com.github.jinahya.sexagenarycycle.地支.戌),

    /**
     * Pig.
     */
    猪(com.github.jinahya.sexagenarycycle.地支.亥);

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<地支, 生肖> VALUES_BY_地支S = Collections.unmodifiableMap(EnumUtils.mapValuesBy(
            生肖.class, v -> v.地支, () -> new EnumMap<>(地支.class)
    ));

    /**
     * Returns the value associated with specified 地支.
     *
     * @param 地支 the 地支.
     * @return the value associated with {@code 地支}.
     */
    public static 生肖 valueOf(final 地支 地支) {
        Objects.requireNonNull(地支, "地支 is null");
        final 生肖 value = VALUES_BY_地支S.get(地支);
        if (value == null) {
            throw new AssertionError("no value for " + 地支);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    生肖(final 地支 地支) {
        this.地支 = Objects.requireNonNull(地支, "地支 is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    public final 地支 地支;
}
