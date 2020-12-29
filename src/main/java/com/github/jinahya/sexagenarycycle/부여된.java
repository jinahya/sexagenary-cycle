package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Optional;

@SuppressWarnings({"NonAsciiCharacters", "java:S101", "java:S116", "java:S3577"})
abstract class 부여된<T extends 부여된<T, U>, U extends Assigned<U>> implements Comparable<T> {

    부여된(final U assigned) {
        super();
        this.assigned = Objects.requireNonNull(assigned, "assigned is null");
        간지 = Optional.ofNullable(this.assigned.干支).map(com.github.jinahya.sexagenarycycle.간지::valueOf).orElse(null);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return super.toString() + '{'
               + "assigned=" + assigned
               + '}';
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        부여된<?, ?> casted = (부여된<?, ?>) o;
        return assigned.equals(casted.assigned);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assigned);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public int compareTo(T o) {
        return assigned.compareTo(o.assigned);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    protected final U assigned;

    /**
     * The 간지 of this value.
     */
    public final 간지 간지;
}
