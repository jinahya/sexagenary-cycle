package com.github.jinahya.sexagenarycycle;

interface RollingEnumTest<E extends Enum<E> & RotatingEnum<E>> {

    @SuppressWarnings({"unchecked"})
    default E[] values() {
        return (E[]) getClass().getEnumConstants();
    }
}
