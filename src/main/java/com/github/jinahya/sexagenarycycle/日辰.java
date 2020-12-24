package com.github.jinahya.sexagenarycycle;

import java.time.Month;
import java.time.Year;
import java.util.Comparator;
import java.util.Objects;

/**
 * Represents a 干支 assigned to a specific date.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://ko.wikipedia.org/wiki/%EC%9D%BC%EC%A7%84_(%EA%B0%84%EC%A7%80)">일진 (간지)</a>
 */
public class 日辰 extends Assigned<日辰> { // 일진

    static final Comparator<日辰> COMPARING_月建_THEN_COMPARING_DAY_OF_MOHTH =
            Comparator.comparing(日辰::get月建).thenComparingInt(日辰::getDayOfMonth);

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance with specified 干支, 月建, and day of month.
     *
     * @param 干支         the 干支.
     * @param dayOfMonth the day of month.
     * @param 月建         the 月建.
     */
    public 日辰(final 干支 干支, final int dayOfMonth, final 月建 月建) {
        super(Objects.requireNonNull(干支, "干支 is null"));
        this.月建 = Objects.requireNonNull(月建, "月建 is null");
        if (dayOfMonth <= 0 || dayOfMonth > 30) {
            throw new IllegalArgumentException("invalid dayOfMonth: " + dayOfMonth);
        }
        this.dayOfMonth = dayOfMonth;
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
               + "月建=" + 月建
               + ",dayOfMonth=" + dayOfMonth
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
        日辰 日辰 = (日辰) o;
        return dayOfMonth == 日辰.dayOfMonth && 月建.equals(日辰.月建);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), 月建, dayOfMonth);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public int compareTo(final 日辰 o) {
        return COMPARING_月建_THEN_COMPARING_DAY_OF_MOHTH.compare(this, o);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the 月建 of this 日辰.
     *
     * @return the 月建 of this 日辰.
     */
    public 月建 get月建() {
        return 月建;
    }

    /**
     * Returns the year of this 日辰.
     *
     * @return the year of this 日辰.
     */
    public Year getYear() {
        return get月建().getYear();
    }

    /**
     * Returns the month of this 日辰.
     *
     * @return the month of this 日辰.
     */
    public Month getMonth() {
        return get月建().getMonth();
    }

    /**
     * Returns the day of month of this 日辰.
     *
     * @return the day of month of this 日辰.
     */
    public int getDayOfMonth() {
        return dayOfMonth;
    }

    // -------------------------------------------------------------------------------------------------------------
    private final 月建 月建;

    private final int dayOfMonth;
}
