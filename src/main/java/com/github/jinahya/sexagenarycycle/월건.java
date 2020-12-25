package com.github.jinahya.sexagenarycycle;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.Month;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

/**
 * Represents a {@link 간지} assigned to a specific month of a year.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://ko.wikipedia.org/wiki/%EC%9B%94%EA%B1%B4">월건</a>
 */
public class 월건 extends 부여된<월건> {

    static final Comparator<월건> LEAP_MONTH_FIRST = (o1, o2) -> Boolean.compare(o1.is閏달(), o2.is閏달());

    static final Comparator<월건> LEAP_MONTH_LAST = (o1, o2) -> LEAP_MONTH_FIRST.compare(o2, o1);

    static final Comparator<월건> COMPARING_세차_THEN_COMPARING_MONTH
            = Comparator.<월건, 세차>comparing(v -> v.세차).thenComparing(v -> v.월);

    // -----------------------------------------------------------------------------------------------------------------
    public static 월건 from(final 月建 月建) {
        Objects.requireNonNull(月建, "月建 is null");
        final 간지 간지 = Optional.ofNullable(月建.干支).map(com.github.jinahya.sexagenarycycle.간지::from).orElse(null);
        final Month 月 = 月建.月;
        final 세차 세차 = com.github.jinahya.sexagenarycycle.세차.from(月建.歲次);
        return new 월건(간지, 月, 세차);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance with specified 세차 and month representing a leap month.
     *
     * @param month the month.
     * @param 세차    the 세차.
     * @return a new instance represents a leap month.
     * @see #to月建()
     */
    public static 월건 ofLeapMonth(final Month month, final 세차 세차) {
        return new 월건(null, month, 세차);
    }

    // -------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance with specified 간지, 세차, and month.
     *
     * @param 간지 the 간지; {@code null} for a leap month.
     * @param 월  the month.
     * @param 세차 the 세차.
     */
    public 월건(final 간지 간지, final Month 월, final 세차 세차) {
        super(간지);
        this.월 = Objects.requireNonNull(월, "month is null");
        this.세차 = Objects.requireNonNull(세차, " 세차 is null");
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns a 月建 representation of this 월건.
     *
     * @return a 月建 representation of this 월건.
     * @see #from(com.github.jinahya.sexagenarycycle.月建)
     */
    public 月建 to月建() {
        月建 v = 月建;
        if (v == null) {
            月建 = v = new 月建(Optional.ofNullable(간지).map(com.github.jinahya.sexagenarycycle.간지::to干支)
                                    .orElse(null), 월, 세차.to歲次());
        }
        return v;
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
               + "월=" + 월
               + ",閏달=" + is閏달()
               + ",세차=" + 세차
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
        final 월건 casted = (월건) o;
        return 세차.equals(casted.세차) && 월 == casted.월;
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), 세차, 월);
    }

    // -------------------------------------------------------------------------------------------------------------
    @Override
    public int compareTo(final 월건 o) {
        return COMPARING_세차_THEN_COMPARING_MONTH.thenComparing(LEAP_MONTH_LAST).compare(this, o);
    }

    // -------------------------------------------------------------------------------------------------------------

    /**
     * Indicates whether this 月建 represents a leap month.
     *
     * @return {@code true} when this 月建 represents a a leap month; {@code false} otherwise.
     */
    public boolean is閏달() {
        return 간지 == null;
    }

    // -------------------------------------------------------------------------------------------------------------

    /**
     * The month of this 월건.
     */
    @NotNull
    public final Month 월;

    /**
     * The 세차 of this 월건.
     */
    @Valid
    @NotNull
    public final 세차 세차;

    // -----------------------------------------------------------------------------------------------------------------
    private volatile 月建 月建;
}
