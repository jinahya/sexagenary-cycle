package com.github.jinahya.sexagenarycycle;

import java.util.Objects;
import java.util.function.Function;

final class RollingEnumHelper {

    // -----------------------------------------------------------------------------------------------------------------
    static <E extends Enum<E> & RotatingEnum<E>> E getPrevious(final Class<E> clazz, final E current,
                                                               final Function<? super E, ? extends E> mapper) {
        return RollingHelper.getPrevious(clazz, current, mapper);
    }

    @SuppressWarnings({"unchecked"})
    static <E extends Enum<E> & RotatingEnum<E>> E getPrevious(final E current,
                                                               final Function<? super E, ? extends E> mapper) {
        Objects.requireNonNull(current, "current is null");
        return getPrevious((Class<E>) current.getClass(), current, mapper);
    }

    // -----------------------------------------------------------------------------------------------------------------
    static <E extends Enum<E> & RotatingEnum<E>> E getNext(final Class<E> clazz, final E current,
                                                           final Function<? super E, ? extends E> mapper) {
        return RollingHelper.getNext(clazz, current, mapper);
    }

    @SuppressWarnings({"unchecked"})
    static <E extends Enum<E> & RotatingEnum<E>> E getNext(final E current,
                                                           final Function<? super E, ? extends E> mapper) {
        Objects.requireNonNull(current, "current is null");
        return getNext((Class<E>) current.getClass(), current, mapper);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private RollingEnumHelper() {
        throw new AssertionError("instantiation is not allowed");
    }
}
