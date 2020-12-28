package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings("NonAsciiCharacters")
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
    private static final Map<五行, 五方正色> VALUES_BY_五行S = Collections.unmodifiableMap(
            Arrays.stream(values()).collect(Collectors.toMap(
                    v -> v.五行,
                    Function.identity(),
                    (v1, v2) -> {
                        throw new AssertionError("duplicate value; " + v1 + ", " + v2);
                    },
                    () -> new EnumMap<>(五行.class)
            ))
    );

    public static 五方正色 valueOf(final 五行 五行) {
        Objects.requireNonNull(五行, "五行 is null");
        final 五方正色 value = VALUES_BY_五行S.get(五行);
        if (value == null) {
            throw new AssertionError("shouldn't happen; no value for " + 五行);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<五方, 五方正色> VALUES_BY_五方S = Collections.unmodifiableMap(
            Arrays.stream(values()).collect(Collectors.toMap(
                    v -> v.五方,
                    Function.identity(),
                    (v1, v2) -> {
                        throw new AssertionError("duplicate value; " + v1 + ", " + v2);
                    },
                    () -> new EnumMap<>(五方.class)
            ))
    );

    public static 五方正色 valueOf(final 五方 五方) {
        Objects.requireNonNull(五方, "五方 is null");
        final 五方正色 value = VALUES_BY_五方S.get(五方);
        if (value == null) {
            throw new AssertionError("shouldn't happen; no value for " + 五方);
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
