package com.github.jinahya.sexagenarycycle;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings({"NonAsciiCharacters", "java:S115", "java:S116", "java:S117"})
enum 相生間色 implements 五方間色 {

    // 정
    靘(com.github.jinahya.sexagenarycycle.五行相生.木生火),

    // 훈
    纁(com.github.jinahya.sexagenarycycle.五行相生.火生土),

    // 규
    硅(com.github.jinahya.sexagenarycycle.五行相生.土生金),

    // 불
    黻(com.github.jinahya.sexagenarycycle.五行相生.金生水),

    // 암
    黯(com.github.jinahya.sexagenarycycle.五行相生.水生木);

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<五行相生, 相生間色> VALUES_BY_五行相生S = Collections.unmodifiableMap(
            EnumUtils.mapValuesBy(相生間色.class, v -> v.五行相生, () -> new EnumMap<>(五行相生.class))
    );

    public static 相生間色 valueOf(final 五行相生 五行相生) {
        Objects.requireNonNull(五行相生, "五行相生 is null");
        final 相生間色 value = VALUES_BY_五行相生S.get(五行相生);
        if (value == null) {
            throw new AssertionError("no value for " + 五行相生);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    相生間色(final 五行相生 五行相生) {
        this.五行相生 = Objects.requireNonNull(五行相生, "五行相生 is null");
    }

    /**
     * The 五行相生 associated with this 相生間色.
     */
    public final 五行相生 五行相生;
}
