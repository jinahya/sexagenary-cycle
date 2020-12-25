package com.github.jinahya.sexagenarycycle;

import org.assertj.core.api.AbstractAssert;

import static java.util.Objects.requireNonNull;
import static org.assertj.core.api.Assertions.assertThat;

abstract class AssignedAssert<T extends AssignedAssert<T, U>, U extends Assigned<U>> extends AbstractAssert<T, U> {

    AssignedAssert(final Class<U> assignedClass, final U actual, final Class<T> assertClass) {
        super(actual, assertClass);
        this.assignedClass = requireNonNull(assignedClass, "assignedClass is null");
    }

    @SuppressWarnings({"unchecked"})
    public T hasSame干支As(final 干支 干支) {
        requireNonNull(干支, "干支 is null");
        isNotNull();
        assertThat(actual.干支).isSameAs(干支);
        return (T) this;
    }

    final Class<U> assignedClass;
}
