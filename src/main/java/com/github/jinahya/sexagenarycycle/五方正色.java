package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/**
 * Constants for <a href="https://en.wikipedia.org/wiki/Obangsaek">Obangsaek</a>.
 *
 * @see <a href="https://ko.wikipedia.org/wiki/%EC%98%A4%EB%B0%A9%EC%83%89">오방색</a>
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S115", "java:S116", "java:S117"})
public enum 五方正色 {

    /**
     * Blue(<font color="blue">&#x2b24;</font>) for Wood({@link com.github.jinahya.sexagenarycycle.五行#木 木}) and
     * East({@link com.github.jinahya.sexagenarycycle.五方#東 東}).
     */
    靑(com.github.jinahya.sexagenarycycle.五行.木, com.github.jinahya.sexagenarycycle.五方.東),

    /**
     * Red(<font color="red">&#x2b24;</font>) for Fire({@link com.github.jinahya.sexagenarycycle.五行#火 火}) and
     * South({@link com.github.jinahya.sexagenarycycle.五方#南 南}).
     */
    赤(com.github.jinahya.sexagenarycycle.五行.火, com.github.jinahya.sexagenarycycle.五方.南),

    /**
     * Yellow(<font color="yellow">&#x2b24;</font>) for Earth({@link com.github.jinahya.sexagenarycycle.五行#土 土}) and
     * Center({@link com.github.jinahya.sexagenarycycle.五方#中 中}).
     */
    黃(com.github.jinahya.sexagenarycycle.五行.土, com.github.jinahya.sexagenarycycle.五方.中),

    /**
     * White(<font color="white">&#x2b24;</font>) for Metal({@link com.github.jinahya.sexagenarycycle.五行#金 金}) and
     * West({@link com.github.jinahya.sexagenarycycle.五方#西 西}).
     */
    白(com.github.jinahya.sexagenarycycle.五行.金, com.github.jinahya.sexagenarycycle.五方.西),

    /**
     * Black(<font color="black">&#x2b24;</font>) for Water({@link com.github.jinahya.sexagenarycycle.五行#水 水}) and
     * North({@link com.github.jinahya.sexagenarycycle.五方#北 北}).
     */
    黑(com.github.jinahya.sexagenarycycle.五行.水, com.github.jinahya.sexagenarycycle.五方.北);

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<五行, 五方正色> VALUES_BY_五行S
            = Collections.unmodifiableMap(EnumUtils.mapValuesBy(五方正色.class, v -> v.五行));

    /**
     * Returns the value associated with specified 五行.
     *
     * @param 五行 the 五行.
     * @return the value associated with {@code 五行}.
     */
    public static 五方正色 valueOf(final 五行 五行) {
        Objects.requireNonNull(五行, "五行 is null");
        final 五方正色 value = VALUES_BY_五行S.get(五行);
        if (value == null) {
            throw new AssertionError("no value for " + 五行);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<五方, 五方正色> VALUES_BY_五方S
            = Collections.unmodifiableMap(EnumUtils.mapValuesBy(五方正色.class, v -> v.五方));

    /**
     * Returns the value associated with specified 五方.
     *
     * @param 五方 the 五方.
     * @return the value associated with {@code 五方}.
     */
    public static 五方正色 valueOf(final 五方 五方) {
        Objects.requireNonNull(五方, "五方 is null");
        final 五方正色 value = VALUES_BY_五方S.get(五方);
        if (value == null) {
            throw new AssertionError("no value for " + 五方);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    五方正色(final 五行 五行, final 五方 五方) {
        this.五行 = Objects.requireNonNull(五行, "五行 is null");
        this.五方 = Objects.requireNonNull(五方, "五方 is null");
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The 五行 associated with this 五方正色.
     */
    public final @NotNull 五行 五行;

    /**
     * The 五方 associated with this 五方正色.
     */
    public final @NotNull 五方 五方;
}
