package com.github.jinahya.sexagenarycycle;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings({"NonAsciiCharacters", "java:S100", "java:S101", "java:S117"})
final class 天干五方 {

    private static final Map<天干, 五方> 五方S_BY_天干S = Collections.unmodifiableMap(
            Arrays.stream(天干.values()).collect(Collectors.toMap(
                    Function.identity(), v -> 五方.VALUES_BY_ORDINALS.get(v.ordinal() >> 1)
            ))
    );

    public static 五方 五方Of(final 天干 天干) {
        Objects.requireNonNull(天干, "天干 is null");
        final 五方 五方 = 五方S_BY_天干S.get(天干);
        if (五方 == null) {
            throw new AssertionError("no 五方 for " + 天干);
        }
        return 五方;
    }

    private 天干五方() {
        throw new AssertionError("instantiation is not allowed");
    }
}
