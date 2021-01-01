package com.github.jinahya.sexagenarycycle;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings({"NonAsciiCharacters", "java:S101"})
final class 生剋五行Helper {

    // -----------------------------------------------------------------------------------------------------------------
    static <E extends Enum<E> & 生剋五行<E>> Map<五行, E> mapValuesBySubjectives(final Class<E> enumClass) {
        return EnumUtils.mapValuesBy(enumClass, 生剋五行::getSubjective, () -> new EnumMap<>(五行.class));
    }

    private static final Map<Class<?>, Map<五行, ?>> VALUES_BY_SUBJECTIVES = new ConcurrentHashMap<>();

    @SuppressWarnings({"unchecked"})
    static <E extends Enum<E> & 生剋五行<E>> E valueOfSubjective(final Class<E> clazz, final 五行 subjective) {
        Objects.requireNonNull(clazz, "clazz is null");
        Objects.requireNonNull(subjective, "subjective is null");
        return (E) VALUES_BY_SUBJECTIVES.computeIfAbsent(clazz, k -> mapValuesBySubjectives((Class<E>) k))
                .get(subjective);
    }

    // -----------------------------------------------------------------------------------------------------------------
    static <E extends Enum<E> & 生剋五行<E>> Map<五行, E> mapValuesByObjectives(final Class<E> enumClass) {
        return EnumUtils.mapValuesBy(enumClass, 生剋五行::getObjective, () -> new EnumMap<>(五行.class));
    }

    private static final Map<Class<?>, Map<五行, ?>> VALUES_BY_OBJECTIVES = new ConcurrentHashMap<>();

    @SuppressWarnings({"unchecked"})
    static <E extends Enum<E> & 生剋五行<E>> E valueOfObjective(final Class<E> clazz, final 五行 objective) {
        Objects.requireNonNull(clazz, "clazz is null");
        Objects.requireNonNull(objective, "objective is null");
        return (E) VALUES_BY_OBJECTIVES.computeIfAbsent(clazz, k -> mapValuesByObjectives((Class<E>) k))
                .get(objective);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private 生剋五行Helper() {
        throw new AssertionError("initialization is not allowed");
    }
}
