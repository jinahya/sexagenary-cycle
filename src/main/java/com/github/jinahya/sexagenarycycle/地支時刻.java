package com.github.jinahya.sexagenarycycle;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings({"NonAsciiCharacters", "java:S100", "java:S115", "java:S116", "java:S117"})
enum 地支時刻 {

    /**
     * Represents the time between {@code 23:00} and {@code 01:00}.
     */
    子時, // 자시
    丑時, // 축시
    寅時, // 인시
    卯時, // 묘시
    辰時, // 진시
    巳時, // 사시
    午時, // 오시
    未時, // 미시
    申時, // 신시
    酉時, // 유시
    戌時, // 술시
    亥時; // 해시

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<地支, 地支時刻> VALUES_BY_地支s = Collections.unmodifiableMap(
            EnumUtils.mapValuesBy(地支時刻.class, v -> v.地支, () -> new EnumMap<>(地支.class))
    );

    public static 地支時刻 valueOf(final 地支 地支) {
        Objects.requireNonNull(地支, "地支 is null");
        final 地支時刻 value = VALUES_BY_地支s.get(地支);
        if (value == null) {
            throw new AssertionError("no value for " + 地支);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public static 時刻 時刻Of(final 地支 地支) {
        return valueOf(地支).時刻;
    }

    // -----------------------------------------------------------------------------------------------------------------
    地支時刻() {
        地支 = com.github.jinahya.sexagenarycycle.地支.valueOf(name().substring(0, 1));
        時刻 = new 時刻(
                LocalTime.MIDNIGHT.plus(Duration.ofHours(((long) 地支.ordinal() << 1L) - 1L)),
                Duration.ofHours(2L)
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    public final 地支 地支;

    public final 時刻 時刻;
}
