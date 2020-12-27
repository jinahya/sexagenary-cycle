package com.github.jinahya.sexagenarycycle;

import java.util.Objects;

interface Rolling<T extends Rolling<T>> {

    // -----------------------------------------------------------------------------------------------------------------
    static <E extends Enum<E> & Rolling<E>> E getPrevious(final Class<E> enumClass, final E enumConstant) {
        Objects.requireNonNull(enumClass, "enumClass is null");
        Objects.requireNonNull(enumConstant, "enumConstant is null");
        final E[] enumConstants = enumClass.getEnumConstants();
        assert enumConstants.length > 0;
        final int ordinal = enumConstant.ordinal();
        return ordinal == 0 ? enumConstants[enumConstants.length - 1] : enumConstants[ordinal - 1];
    }

    @SuppressWarnings({"unchecked"})
    static <E extends Enum<E> & Rolling<E>> E getPrevious(final E enumConstant) {
        Objects.requireNonNull(enumConstant, "enumConstant is null");
        return getPrevious((Class<E>) enumConstant.getClass(), enumConstant);
    }

    // -----------------------------------------------------------------------------------------------------------------
    static <E extends Enum<E> & Rolling<E>> E getNext(final Class<E> enumClass, final E enumConstant) {
        Objects.requireNonNull(enumClass, "enumClass is null");
        Objects.requireNonNull(enumConstant, "enumConstant is null");
        final E[] enumConstants = enumClass.getEnumConstants();
        assert enumConstants.length > 0;
        final int ordinal = enumConstant.ordinal();
        return ordinal == enumConstants.length - 1 ? enumConstants[0] : enumConstants[ordinal + 1];
    }

    @SuppressWarnings({"unchecked"})
    static <E extends Enum<E> & Rolling<E>> E getNext(final E enumConstant) {
        Objects.requireNonNull(enumConstant, "enumConstant is null");
        return Rolling.getNext((Class<E>) enumConstant.getClass(), enumConstant);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the previous value of this value.
     *
     * @return the previous value of this value.
     */
    T getPrevious();

    /**
     * Returns the next value of this value.
     *
     * @return the next value of this value.
     */
    T getNext();
}
