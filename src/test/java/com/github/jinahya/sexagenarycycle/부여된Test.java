package com.github.jinahya.sexagenarycycle;

import static java.util.Objects.requireNonNull;

@SuppressWarnings({"NonAsciiCharacters", "java:S117"})
abstract class 부여된Test<T extends 부여된<T, U>, U extends Assigned<U>> {

    부여된Test(final Class<T> 부여된Class, final Class<U> assignedClass) {
        super();
        this.부여된Class = requireNonNull(부여된Class, "부여된Class is null");
        this.assignedClass = requireNonNull(assignedClass, "assignedClass is null");
    }

    final Class<T> 부여된Class;

    final Class<U> assignedClass;
}