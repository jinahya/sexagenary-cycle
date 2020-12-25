package com.github.jinahya.sexagenarycycle;

import static java.util.Objects.requireNonNull;

abstract class AssignedTest<T extends Assigned<T>> {

    AssignedTest(final Class<T> assignedClass) {
        super();
        this.assignedClass = requireNonNull(assignedClass, "assignedClass is null");
    }

    final Class<T> assignedClass;
}