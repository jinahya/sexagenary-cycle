package com.github.jinahya.sexagenarycycle;

import java.util.Objects;

@SuppressWarnings("NonAsciiCharacters")
abstract class 五方間色Test<T extends 五方間色> {

    五方間色Test(final Class<T> 五方間色Class) {
        super();
        this.五方間色Class = Objects.requireNonNull(五方間色Class, "五方間色Test is null");
    }

    final Class<T> 五方間色Class;
}