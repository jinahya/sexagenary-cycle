package com.github.jinahya.sexagenarycycle;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Maps {@link 陰陽} to {@link 地支}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S101", "java:S117"})
final class 地支陰陽 {

    private static final Map<地支, 陰陽> MAP = Collections.unmodifiableMap(
            Arrays.stream(地支.values()).collect(Collectors.toMap(
                    Function.identity(),
                    v -> (v.ordinal() & 0x01) == 0 ? 陰陽.陽 : 陰陽.陰
            ))
    );

    public static 陰陽 valueOf(final 地支 地支) {
        Objects.requireNonNull(地支, "地支 is null");
        return MAP.get(地支);
    }

    private 地支陰陽() {
        throw new AssertionError("instantiation is not allowed");
    }
}
