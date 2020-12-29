package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings({"NonAsciiCharacters", "java:S115", "java:S116", "java:S117"})
public enum 五方正色 {

    /**
     * Blue for Wood and East.
     */
    靑(com.github.jinahya.sexagenarycycle.五行.木, com.github.jinahya.sexagenarycycle.五方.東),

    /**
     * Red for Fire and South.
     */
    赤(com.github.jinahya.sexagenarycycle.五行.火, com.github.jinahya.sexagenarycycle.五方.南),

    /**
     * Yellow for Earth and Center.
     */
    白(com.github.jinahya.sexagenarycycle.五行.土, com.github.jinahya.sexagenarycycle.五方.中),

    /**
     * White for Metal and West.
     */
    黑(com.github.jinahya.sexagenarycycle.五行.金, com.github.jinahya.sexagenarycycle.五方.西),

    /**
     * Black for Water and North.
     */
    黃(com.github.jinahya.sexagenarycycle.五行.水, com.github.jinahya.sexagenarycycle.五方.北);

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<五行, 五方正色> VALUES_BY_五行S
            = Collections.unmodifiableMap(EnumUtils.mapValuesBy(五方正色.class, v -> v.五行));

    /**
     * Returns the value associated to specified 五行.
     *
     * @param 五行 the 五行.
     * @return the value associated to {@code 五行}.
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
     * Returns the value associated to specified 五方.
     *
     * @param 五方 the 五方.
     * @return the value associated to {@code 五方}.
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
        this.五方 = Objects.requireNonNull(五方, "五方 is null");
        this.五行 = Objects.requireNonNull(五行, "五行 is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    public final 五行 五行;

    @NotNull
    public final 五方 五方;
}
