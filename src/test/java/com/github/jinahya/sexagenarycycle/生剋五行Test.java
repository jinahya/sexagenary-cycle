package com.github.jinahya.sexagenarycycle;

import static java.util.Objects.requireNonNull;

@SuppressWarnings("NonAsciiCharacters")
abstract class 生剋五行Test<E extends Enum<E> & 生剋五行<E>> implements RollingEnumTest<E> {

    生剋五行Test(final Class<E> enumClass) {
        super();
        this.enumClass = requireNonNull(enumClass, "enumClass is null");
    }

    final Class<E> enumClass;
}