package com.github.jinahya.sexagenarycycle;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

final class 地支二十四方 {

    private static final Map<地支, 二十四方> MAP = Collections.unmodifiableMap(
            Arrays.stream(地支.values()).collect(Collectors.toMap(
                    Function.identity(),
                    v -> 二十四方.valueOfDirection(v.ordinal() * 30, true),
                    (d1, d2) -> {
                        throw new AssertionError("duplicate 地支; " + d1 + ", " + d2);
                    },
                    () -> new EnumMap<>(地支.class))
            )
    );

    static 二十四方 valueOf(final 地支 地支) {
        Objects.requireNonNull(地支, "地支 is null");
        return MAP.get(地支);
    }

    private 地支二十四方() {
        throw new AssertionError("instantiation is not allowed");
    }
}
