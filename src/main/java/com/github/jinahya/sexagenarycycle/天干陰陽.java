package com.github.jinahya.sexagenarycycle;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings({"NonAsciiCharacters", "java:S100", "java:S101", "java:S117"})
final class 天干陰陽 {

    private static final Map<天干, 陰陽> 陰陽S_BY_天干S = Collections.unmodifiableMap(
            Arrays.stream(天干.values()).collect(Collectors.toMap(
                    Function.identity(),
                    v -> (v.ordinal() & 0x01) == 0 ? 陰陽.陽 : 陰陽.陰
            ))
    );

    public static 陰陽 陰陽Of(final 天干 天干) {
        Objects.requireNonNull(天干, "天干 is null");
        final 陰陽 陰陽 = 陰陽S_BY_天干S.get(天干);
        if (陰陽 == null) {
            throw new AssertionError("no 陰陽 for " + 天干);
        }
        return 陰陽;
    }

    private 天干陰陽() {
        throw new AssertionError("instantiation is not allowed");
    }
}
