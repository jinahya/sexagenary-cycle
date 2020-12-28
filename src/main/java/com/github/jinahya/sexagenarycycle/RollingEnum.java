package com.github.jinahya.sexagenarycycle;

interface RollingEnum<E extends Enum<E> & RollingEnum<E>> extends Rolling<E> {

    @SuppressWarnings({"unchecked"})
    default E getPrevious() {
        return RollingEnumHelper.getPrevious((E) this, c -> {
            final E[] values = (E[]) getClass().getEnumConstants();
            final int ordinal = ((E) this).ordinal();
            if (ordinal == 0) {
                return values[values.length - 1];
            }
            return values[ordinal - 1];
        });
    }

    @SuppressWarnings({"unchecked"})
    default E getNext() {
        return RollingEnumHelper.getNext((E) this, c -> {
            final E[] values = (E[]) getClass().getEnumConstants();
            final int ordinal = ((E) this).ordinal();
            if (ordinal == values.length - 1) {
                return values[0];
            }
            return values[ordinal + 1];
        });
    }
}
