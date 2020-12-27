package com.github.jinahya.sexagenarycycle;

interface RollingEnumTest<E extends Enum<E> & RollingEnum<E>> {

    @SuppressWarnings({"unchecked"})
    default E[] values() {
        return (E[]) getClass().getEnumConstants();
    }
}
