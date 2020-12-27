package com.github.jinahya.sexagenarycycle;

import java.util.Objects;
import java.util.function.Function;

final class RollingEnumHelper {

    // -----------------------------------------------------------------------------------------------------------------
    static <E extends Enum<E> & RollingEnum<E>> E getPrevious(final Class<? super E> clazz, final E current,
                                                              final Function<? super E, ? extends E> computer) {
        return RollingHelper.getPrevious(clazz, current, computer);
    }

    @SuppressWarnings({"unchecked"})
    static <E extends Enum<E> & RollingEnum<E>> E getPrevious(final E current,
                                                              final Function<? super E, ? extends E> computer) {
        Objects.requireNonNull(current, "current is null");
        return getPrevious(
                (Class<? super E>) current.getClass(),
                current,
                computer);
    }

    // -----------------------------------------------------------------------------------------------------------------
    static <E extends Enum<E> & RollingEnum<E>> E getNext(final Class<? super E> clazz, final E current,
                                                          final Function<? super E, ? extends E> computer) {
        return RollingHelper.getNext(clazz, current, computer);
    }

    @SuppressWarnings({"unchecked"})
    static <E extends Enum<E> & RollingEnum<E>> E getNext(final E current,
                                                          final Function<? super E, ? extends E> computer) {
        Objects.requireNonNull(current, "current is null");
        return getNext((Class<? super E>) current.getClass(), current, computer);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private RollingEnumHelper() {
        throw new AssertionError("instantiation is not allowed");
    }
}
