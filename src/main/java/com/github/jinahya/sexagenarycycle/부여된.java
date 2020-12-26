package com.github.jinahya.sexagenarycycle;

import java.util.Objects;

abstract class 부여된<T extends 부여된<T>> implements Comparable<T>, Cloneable {

    부여된(final 간지 간지) {
        super();
        this.간지 = 간지;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return super.toString() + '{' +
               "간지=" + 간지 +
               '}';
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        부여된<?> casted = (부여된<?>) o;
        return Objects.equals(간지, casted.간지);
    }

    @Override
    public int hashCode() {
        return Objects.hash(간지);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    @SuppressWarnings({"unchecked"})
    public T clone() {
        try {
            return (T) super.clone();
        } catch (final CloneNotSupportedException cnse) {
            throw new AssertionError("failed to clone; " + cnse.toString());
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The 간지 assigned to this value; maybe {@code null} when none assigned.
     */
    public final 간지 간지;
}
