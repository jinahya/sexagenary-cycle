package com.github.jinahya.sexagenarycycle;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

final class RollingHelper {

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<Class<?>, Map<Object, Object>> PREVIOUS_VALUES = new ConcurrentHashMap<>();

    @SuppressWarnings({"unchecked"})
    static <T extends Rolling<T>> T getPrevious(final Class<? super T> clazz, final T current,
                                                final Function<? super T, ? extends T> computer) {
        Objects.requireNonNull(clazz, "clazz is null");
        Objects.requireNonNull(current, "current is null");
        Objects.requireNonNull(computer, "computer is null");
        return (T) PREVIOUS_VALUES.computeIfAbsent(clazz, k -> new ConcurrentHashMap<>())
                .computeIfAbsent(current, k -> computer.apply((T) k));
    }

    @SuppressWarnings({"unchecked"})
    static <T extends Rolling<T>> T getPrevious(final T current,
                                                final Function<? super T, ? extends T> computer) {
        Objects.requireNonNull(current, "current is null");
        return getPrevious((Class<T>) current.getClass(), current, computer);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<Class<?>, Map<Object, Object>> NEXT_VALUES = new ConcurrentHashMap<>();

    @SuppressWarnings({"unchecked"})
    static <T extends Rolling<T>> T getNext(final Class<? super T> clazz, final T current,
                                            final Function<? super T, ? extends T> computer) {
        Objects.requireNonNull(clazz, "clazz is null");
        Objects.requireNonNull(current, "current is null");
        Objects.requireNonNull(computer, "computer is null");
        return (T) NEXT_VALUES.computeIfAbsent(current.getClass(), k -> new ConcurrentHashMap<>())
                .computeIfAbsent(current, k -> computer.apply((T) k));
    }

    @SuppressWarnings({"unchecked"})
    static <T extends Rolling<T>> T getNext(final T current,
                                            final Function<? super T, ? extends T> computer) {
        Objects.requireNonNull(current, "current is null");
        return getNext((Class<T>) current.getClass(), current, computer);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private RollingHelper() {
        throw new AssertionError("instantiation is not allowed");
    }
}
