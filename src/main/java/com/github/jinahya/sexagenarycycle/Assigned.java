package com.github.jinahya.sexagenarycycle;

import java.util.Objects;

abstract class Assigned<T extends Assigned<T>> implements Comparable<T>, Cloneable {

    /**
     * Creates a new instance with specified 干支.
     *
     * @param 干支 the 干支
     */
    Assigned(final 干支 干支) {
        super();
        this.干支 = 干支;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return super.toString() + '{'
               + "干支=" + 干支
               + '}';
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assigned<?> assigned = (Assigned<?>) o;
        return Objects.equals(干支, assigned.干支);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(干支);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    @SuppressWarnings({"unchecked"})
    public T clone() throws CloneNotSupportedException {
        return (T) super.clone();
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the 干支 of this object.
     *
     * @return the 干支 of this object.
     * @see #getGanzhi()
     */
    public 干支 get干支() {
        return 干支;
    }

    /**
     * Returns the ganzhi of this object.
     *
     * @return the ganzhi of this object.
     * @see #get干支()
     */
    public 干支 getGanzhi() {
        return get干支();
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final 干支 干支; // may be null
}
