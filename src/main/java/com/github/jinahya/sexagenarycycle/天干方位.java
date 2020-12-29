package com.github.jinahya.sexagenarycycle;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Class for mapping {@link 二十四方} for each value of {@link 天干}. Note that there is no {@code 二十四方} associated to any
 * {@code 天干} whose {@link 天干#get五方() 五方} is {@link 五方#中 中}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S100", "java:S101", "java:S117"})
final class 天干方位 {

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<天干, 二十四方> 二十四方S_BY_天干S = Collections.unmodifiableMap(
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

    /**
     * Returns a value of {@link 二十四方} associated to specified 天干.
     *
     * @param 天干 the 天干.
     * @return the value mapped to specified 天干; {@code null} if none associated which means {@code 天干}'s {@link
     * 天干#get五方() 五方} is {@link 五方#中 中}.
     */
    public static 二十四方 方位Of(final 天干 天干) {
        Objects.requireNonNull(天干, "天干 is null");
        return 二十四方S_BY_天干S.get(天干);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private 天干方位() {
        throw new AssertionError("instantiation is not allowed");
    }
}
