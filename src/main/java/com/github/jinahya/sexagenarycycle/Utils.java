package com.github.jinahya.sexagenarycycle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

final class Utils {

    static <K, E extends Enum<E>> Map<K, E> mapValuesBy(final Class<E> enumClass,
                                                        final Function<? super E, ? extends K> keyMapper) {
        requireNonNull(enumClass, "enumClass is null");
        requireNonNull(keyMapper, "keyMapper is null");
        return Arrays.stream(enumClass.getEnumConstants()).collect(Collectors.toMap(
                keyMapper,
                Function.identity(),
                (v1, v2) -> {
                    throw new AssertionError("duplicate values: " + v1 + ", " + v2);
                },
                HashMap::new));
    }

    static <E extends Enum<E>> Map<String, E> mapValuesByNames(final Class<E> enumClass) {
        return mapValuesBy(enumClass, Enum::name);
    }

    static <E extends Enum<E>> Map<Integer, E> mapValuesByOrdinals(final Class<E> enumClass) {
        return mapValuesBy(enumClass, Enum::ordinal);
    }

    private Utils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
