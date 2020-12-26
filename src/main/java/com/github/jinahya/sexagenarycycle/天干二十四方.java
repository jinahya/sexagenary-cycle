package com.github.jinahya.sexagenarycycle;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

final class 天干二十四方 {

    private static final Map<天干, 二十四方> MAP = Collections.unmodifiableMap(
            Arrays.stream(天干.values())
                    .filter(v -> v.get五方() != 五方.中)
                    .collect(Collectors.toMap(
                            Function.identity(),
                            v -> 二十四方.valueOf(v.name()),
                            (v1, v2) -> {
                                throw new AssertionError("duplicate value; " + v1 + ", " + v2);
                            },
                            () -> new EnumMap<>(天干.class)))
    );

    static 二十四方 valueOf(final 天干 天干) {
        requireNonNull(天干, "天干 is null");
        return MAP.get(天干);
    }

    private 天干二十四方() {
        throw new AssertionError("instantiation is not allowed");
    }
}
