package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.function.UnaryOperator;

interface RollingEnum<E extends Enum<E> & RollingEnum<E>> extends Rolling<E> {

    static <E extends Enum<E> & RollingEnum<E>> UnaryOperator<E> previousMapper(final Class<E> enumClass) {
        Objects.requireNonNull(enumClass, "enumClass is null");
        return c -> {
            Objects.requireNonNull(c, "enumConstant is null");
            final E[] values = enumClass.getEnumConstants();
            final int ordinal = c.ordinal();
            if (ordinal == 0) {
                return values[values.length - 1];
            }
            return values[ordinal - 1];
        };
    }

    static <E extends Enum<E> & RollingEnum<E>> UnaryOperator<E> nextMapper(final Class<E> enumClass) {
        Objects.requireNonNull(enumClass, "enumClass is null");
        return c -> {
            Objects.requireNonNull(c, "enumConstant is null");
            final E[] values = enumClass.getEnumConstants();
            final int ordinal = c.ordinal();
            if (ordinal == values.length - 1) {
                return values[0];
            }
            return values[ordinal + 1];
        };
    }

    @SuppressWarnings({"unchecked"})
    @Override
    default @NotNull E getPrevious() {
        return RollingEnumHelper.getPrevious((E) this, previousMapper((Class<E>) getClass()));
    }

    @SuppressWarnings({"unchecked"})
    @Override
    default @NotNull E getNext() {
        return RollingEnumHelper.getNext((E) this, nextMapper((Class<E>) getClass()));
    }
}
