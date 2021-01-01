package com.github.jinahya.sexagenarycycle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SuppressWarnings({"java:S1192"})
final class EnumUtils {

    static <K, E extends Enum<E>> Map<K, E> mapValuesBy(final Class<E> enumClass,
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

    static <K, E extends Enum<E>> Map<K, E> mapValuesBy(final Class<E> enumClass,
                                                        final Function<? super E, ? extends K> keyMapper) {
        return mapValuesBy(enumClass, keyMapper, HashMap::new);
    }

    static <E extends Enum<E>> Map<String, E> mapValuesByNames(final Class<E> enumClass) {
        Objects.requireNonNull(enumClass, "enumClass is null");
        return Arrays.stream(enumClass.getEnumConstants()).collect(Collectors.toMap(Enum::name, Function.identity()));
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<Class<?>, Map<String, ?>> VALUES_BY_NAMES = new ConcurrentHashMap<>();

    @SuppressWarnings({"unchecked"})
    static <E extends Enum<E>> E valueOfName(final Class<E> clazz, final String name) {
        Objects.requireNonNull(clazz, "enumClass is null");
        Objects.requireNonNull(name, "name is null");
        final E value = (E) VALUES_BY_NAMES.computeIfAbsent(clazz, k -> mapValuesByNames((Class<E>) k)).get(name);
        if (value == null) {
            throw new IllegalArgumentException("no value for " + name);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------

    private EnumUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
