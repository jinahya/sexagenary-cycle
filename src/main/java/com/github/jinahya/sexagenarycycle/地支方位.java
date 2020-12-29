package com.github.jinahya.sexagenarycycle;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings({"NonAsciiCharacters", "java:S100", "java:S101", "java:S117"})
final class 地支方位 {

    private static final Map<地支, 二十四方> 二十四方S_BY_地支S = Collections.unmodifiableMap(
            Arrays.stream(地支.values()).collect(Collectors.toMap(
                    Function.identity(),
                    v -> 二十四方.valueOfDirection(v.ordinal() * 30, true),
                    (v1, v2) -> {
                        throw new AssertionError("duplicate value; " + v1 + ", " + v2);
                    },
                    () -> new EnumMap<>(地支.class))
            )
    );

    public static 二十四方 方位Of(final 地支 地支) {
        Objects.requireNonNull(地支, "地支 is null");
        return 二十四方S_BY_地支S.get(地支);
    }

    private 地支方位() {
        throw new AssertionError("instantiation is not allowed");
    }
}
