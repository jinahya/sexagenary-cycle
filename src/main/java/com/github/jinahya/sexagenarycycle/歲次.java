package com.github.jinahya.sexagenarycycle;

import java.time.Year;
import java.util.Comparator;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * Represents a 干支 assigned to a specific year.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://ko.wikipedia.org/wiki/%EC%84%B8%EC%B0%A8_(%EA%B0%84%EC%A7%80)">세차 (간지)</a>
 */
public class 歲次 extends Assigned<歲次> { // 세차

    static final Comparator<歲次> COMPARING_YEAR = Comparator.comparing(歲次::getYear);

    // -------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance with specified 干支 and year.
     *
     * @param 干支   the 干支.
     * @param year the year.
     */
    public 歲次(final 干支 干支, final Year year) {
        super(requireNonNull(干支, "干支 is null"));
        this.year = requireNonNull(year, "year is null");
    }

    // -------------------------------------------------------------------------------------------------------------

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return super.toString() + '{'
               + "year=" + year
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
        if (!super.equals(o)) return false;
        歲次 歲次 = (com.github.jinahya.sexagenarycycle.歲次) o;
        return year.equals(歲次.year);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), year);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public int compareTo(final 歲次 o) {
        return COMPARING_YEAR.compare(this, o);
    }

    // -------------------------------------------------------------------------------------------------------------

    /**
     * Returns the previous value of this 歲次.
     *
     * @return the previous value of this 歲次.
     */
    public 歲次 getPrevious() {
        return new 歲次(get干支().getPrevious(), year.minusYears(1L));
    }

    /**
     * Returns the next value of this 歲次.
     *
     * @return the next value of this 歲次.
     */
    public 歲次 getNext() {
        return new 歲次(get干支().getNext(), year.plusYears(1L));
    }

    // -------------------------------------------------------------------------------------------------------------

    /**
     * Returns the year of this 歲次.
     *
     * @return the year of this 歲次.
     */
    public Year getYear() {
        return year;
    }

    // -------------------------------------------------------------------------------------------------------------
    private final Year year;
}
