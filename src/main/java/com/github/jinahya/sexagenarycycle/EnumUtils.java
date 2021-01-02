package com.github.jinahya.sexagenarycycle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SuppressWarnings({"java:S1192"})
final class EnumUtils {

    // -----------------------------------------------------------------------------------------------------------------
    static <E extends Enum<E>, K> Map<K, E> mapValuesBy(final Class<E> enumClass,
                                                        final Function<? super E, ? extends K> keyMapper,
                                                        final Supplier<? extends Map<K, E>> mapFactory) {
        Objects.requireNonNull(enumClass, "enumClass is null");
        Objects.requireNonNull(keyMapper, "keyMapper is null");
        Objects.requireNonNull(mapFactory, "mapFactory is null");
        return Arrays.stream(enumClass.getEnumConstants()).collect(Collectors.toMap(
                keyMapper,
                Function.identity(),
                (k1, k2) -> {
                    throw new AssertionError("duplicate mapped keys: " + k1 + ", " + k2);
                },
                mapFactory));
    }

    static <E extends Enum<E>, K> Map<K, E> mapValuesBy(final Class<E> enumClass,
                                                        final Function<? super E, ? extends K> keyMapper) {
        return mapValuesBy(enumClass, keyMapper, HashMap::new);
    }

    // -----------------------------------------------------------------------------------------------------------------

    private EnumUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
