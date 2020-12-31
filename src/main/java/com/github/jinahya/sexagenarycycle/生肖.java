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
// https://www.compart.com/en/unicode/block/U+1F300
@SuppressWarnings({"NonAsciiCharacters", "java:S115", "java:S116", "java:S117"})
public enum 生肖 {

    /**
     * Rat(&#x1F400;).
     */
    // https://www.compart.com/en/unicode/U+1F400
    // https://www.compart.com/en/unicode/U+1F42D
    鼠(com.github.jinahya.sexagenarycycle.地支.子),

    /**
     * Ox(&#x1F402;).
     */
    // https://www.compart.com/en/unicode/U+1F402
    // https://www.compart.com/en/unicode/U+1F42E
    牛(com.github.jinahya.sexagenarycycle.地支.丑),

    /**
     * Tiger(&#x1F405;).
     */
    // https://www.compart.com/en/unicode/U+1F405
    // https://www.compart.com/en/unicode/U+1F42F
    虎(com.github.jinahya.sexagenarycycle.地支.寅),

    /**
     * Rabbit(&#x1F407;).
     */
    // https://www.compart.com/en/unicode/U+1F407
    // https://www.compart.com/en/unicode/U+1F430
    兔(com.github.jinahya.sexagenarycycle.地支.卯),

    /**
     * Dragon(&#x1F409;).
     */
    // https://www.compart.com/en/unicode/U+1F409
    // https://www.compart.com/en/unicode/U+1F432
    龙(com.github.jinahya.sexagenarycycle.地支.辰),

    /**
     * Snake(&#x1F40D;).
     */
    // https://www.compart.com/en/unicode/U+1F40D
    蛇(com.github.jinahya.sexagenarycycle.地支.巳),

    /**
     * Horse(&#x1F40E;).
     */
    // https://www.compart.com/en/unicode/U+1F40E
    // https://www.compart.com/en/unicode/U+1F434
    马(com.github.jinahya.sexagenarycycle.地支.午),

    /**
     * Goat(&#x1F410;).
     */
    // https://www.compart.com/en/unicode/U+1F410
    羊(com.github.jinahya.sexagenarycycle.地支.未),

    /**
     * Monkey(&#x1F412;).
     */
    // https://www.compart.com/en/unicode/U+1F412
    // https://www.compart.com/en/unicode/U+1F435
    猴(com.github.jinahya.sexagenarycycle.地支.申),

    /**
     * Rooster(&#x1F413;).
     */
    // https://www.compart.com/en/unicode/U+1F413
    鸡(com.github.jinahya.sexagenarycycle.地支.酉),

    /**
     * Dog(&#x1F415;).
     */
    // https://www.compart.com/en/unicode/U+1F415
    // https://www.compart.com/en/unicode/U+1F436
    狗(com.github.jinahya.sexagenarycycle.地支.戌),

    /**
     * Pig(&#x1F416;).
     */
    // https://www.compart.com/en/unicode/U+1F416
    // https://www.compart.com/en/unicode/U+1F437
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

    /**
     * The 地支 associated with this 生肖.
     */
    @NotNull
    public final 地支 地支;
}
