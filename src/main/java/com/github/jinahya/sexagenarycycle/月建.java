package com.github.jinahya.sexagenarycycle;

import java.time.Month;
import java.time.Year;
import java.util.Comparator;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * Represents a 干支 assigned to a specific month of a year.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://ko.wikipedia.org/wiki/%EC%9B%94%EA%B1%B4">월건</a>
 */
public class 月建 extends Assigned<月建> { // 월건

    static final Comparator<月建> LEAP_MONTH_FIRST = (o1, o2) -> Boolean.compare(o1.isLeapMonth(), o2.isLeapMonth());

    static final Comparator<月建> LEAP_MONTH_LAST = (o1, o2) -> LEAP_MONTH_FIRST.compare(o2, o1);

    static final Comparator<月建> COMPARING_歲次_THEN_COMPARING_MONTH
            = Comparator.comparing(月建::get歲次).thenComparing(月建::getMonth);

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance with specified 歲次 and month representing a leap month.
     *
     * @param month the month.
     * @param 歲次    the 歲次.
     * @return a new instance represents a leap month.
     */
    public static 月建 ofLeapMonth(final Month month, final 歲次 歲次) {
        return new 月建(null, month, 歲次);
    }

    // -------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance with specified 干支, 歲次, and month.
     *
     * @param 干支    the 干支; {@code null} for a leap month.
     * @param month the month.
     * @param 歲次    the 歲次.
     */
    public 月建(final 干支 干支, final Month month, final 歲次 歲次) {
        super(干支);
        this.歲次 = requireNonNull(歲次, " 歲次 is null");
        this.month = requireNonNull(month, "month is null");
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
               + "歲次=" + 歲次
               + ",month=" + month
               + ",leapMonth=" + isLeapMonth()
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
        月建 月建 = (com.github.jinahya.sexagenarycycle.月建) o;
        return 歲次.equals(月建.歲次) && month == 月建.month;
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), 歲次, month);
    }

    // -------------------------------------------------------------------------------------------------------------
    @Override
    public int compareTo(final 月建 o) {
        return COMPARING_歲次_THEN_COMPARING_MONTH.thenComparing(LEAP_MONTH_LAST).compare(this, o);
    }

    // -------------------------------------------------------------------------------------------------------------

    /**
     * Returns the 歲次 of this 月建.
     *
     * @return the 歲次 of this 月建.
     */
    public 歲次 get歲次() {
        return 歲次;
    }

    /**
     * Returns the year of this the 月建.
     *
     * @return the year of this the 月建.
     */
    public Year getYear() {
        return get歲次().getYear();
    }

    /**
     * Returns the month of this the 月建.
     *
     * @return the month of this the 月建.
     */
    public Month getMonth() {
        return month;
    }

    /**
     * Indicates whether this 月建 represents a leap month.
     *
     * @return {@code true} when this 月建 represents a a leap month; {@code false} otherwise.
     */
    public boolean isLeapMonth() {
        return get干支() == null;
    }

    // -------------------------------------------------------------------------------------------------------------
    private final 歲次 歲次;

    private final Month month;
}
