package com.github.jinahya.sexagenarycycle;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

enum 地支時刻 {

    /**
     * Represents the time between {@code 23:00} and {@code 01:00}.
     */
    子時(com.github.jinahya.sexagenarycycle.地支.子), // 자시
    丑時(com.github.jinahya.sexagenarycycle.地支.丑), // 축시
    寅時(com.github.jinahya.sexagenarycycle.地支.寅), // 인시
    卯時(com.github.jinahya.sexagenarycycle.地支.卯), // 묘시
    辰時(com.github.jinahya.sexagenarycycle.地支.辰), // 진시
    巳時(com.github.jinahya.sexagenarycycle.地支.巳), // 사시
    午時(com.github.jinahya.sexagenarycycle.地支.午), // 오시
    未時(com.github.jinahya.sexagenarycycle.地支.未), // 미시
    申時(com.github.jinahya.sexagenarycycle.地支.申), // 신시
    酉時(com.github.jinahya.sexagenarycycle.地支.酉), // 유시
    戌時(com.github.jinahya.sexagenarycycle.地支.戌), // 술시
    亥時(com.github.jinahya.sexagenarycycle.地支.亥); // 해시

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<地支, 地支時刻> VALUES_BY_地支s = Collections.unmodifiableMap(
            Arrays.stream(values()).collect(Collectors.toMap(
                    v -> v.地支,
                    Function.identity(),
                    (v1, v2) -> {
                        throw new AssertionError("duplicate key: " + v1 + ", " + v2);
                    },
                    () -> new EnumMap<>(地支.class)
            ))
    );

    public static 地支時刻 valueOf(final 地支 地支) {
        requireNonNull(地支, "地支 is null");
        final 地支時刻 value = VALUES_BY_地支s.get(地支);
        if (value == null) {
            throw new AssertionError("no value for " + 地支);
        }
        return value;
    }

    public static 時刻 時刻Of(final 地支 地支) {
        return valueOf(地支).時刻;
    }

    // -----------------------------------------------------------------------------------------------------------------
    地支時刻(final 地支 地支) {
        this.地支 = requireNonNull(地支, "地支 is null");
        時刻 = new 時刻(
                LocalTime.MIDNIGHT.plus(Duration.ofHours(((long) 地支.ordinal() << 1L) - 1L)),
                Duration.ofHours(2L)
        );
    }

    public final 地支 地支;

    public final 時刻 時刻;
}
