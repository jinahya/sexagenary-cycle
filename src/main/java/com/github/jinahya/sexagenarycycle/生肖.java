package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

/**
 * Constants for the <a href="https://en.wikipedia.org/wiki/Chinese_zodiac">Chinese zodiac</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://zh.wikipedia.org/wiki/%E7%94%9F%E8%82%96">生肖 (Wikipedia)</a>
 */
// https://www.compart.com/en/unicode/block/U+1F300
@SuppressWarnings({"NonAsciiCharacters", "java:S115", "java:S116", "java:S117"})
public enum 生肖 {

    /**
     * 0: Rat(&#x1F400;).
     */
    鼠, // 쥐 서

    /**
     * 1: Ox(&#x1F402;).
     */
    牛, // 소 우

    /**
     * 2: Tiger(&#x1F405;).
     */
    虎, // 범 호

    /**
     * 3: Rabbit(&#x1F407;).
     */
    兔, // 토끼 토, 兎

    /**
     * 4: Dragon(&#x1F409;).
     */
    龙, // 용 용, 龍

    /**
     * 5: Snake(&#x1F40D;).
     */
    蛇, // 뱀 사

    /**
     * 6: Horse(&#x1F40E;).
     */
    马, // 말 마, 馬

    /**
     * 7: Goat(&#x1F410;).
     */
    羊, // 양 양

    /**
     * 8: Monkey(&#x1F412;).
     */
    猴, // 원숭이 후

    /**
     * 9: Rooster(&#x1F413;).
     */
    鸡, // 닭 계, 雞

    /**
     * A: Dog(&#x1F415;).
     */
    狗, // 개 구, 견(犬)

    /**
     * B: Pig(&#x1F416;).
     */
    猪; // 돼지 저, 豬

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<地支, 生肖> VALUES_BY_地支S = Collections.unmodifiableMap(
            EnumUtils.mapValuesBy(生肖.class, v -> v.地支, () -> new EnumMap<>(地支.class))
    );

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
    生肖() {
        地支 = com.github.jinahya.sexagenarycycle.地支.values()[ordinal()];
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The 地支 associated with this 生肖.
     */
    public final @NotNull 地支 地支;
}
