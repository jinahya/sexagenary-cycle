package com.github.jinahya.sexagenarycycle;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Comparator;
import java.util.Objects;

/**
 * Represents a 干支 assigned to a specific date.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://ko.wikipedia.org/wiki/%EC%9D%BC%EC%A7%84_(%EA%B0%84%EC%A7%80)">일진 (간지)</a>
 */
public class 日辰 extends Assigned<日辰> {

    static final Comparator<日辰> COMPARING_月建_THEN_COMPARING_DAY_OF_MONTH
            = Comparator.<日辰, 月建>comparing(v -> v.月建).thenComparingInt(v -> v.日);

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance with specified 干支, 月建, and day of month.
     *
     * @param 干支 the 干支.
     * @param 日  the day of month.
     * @param 月建 the 月建.
     */
    public 日辰(final 干支 干支, final int 日, final 月建 月建) {
        super(Objects.requireNonNull(干支, "干支 is null"));
        this.月建 = Objects.requireNonNull(月建, "月 is null");
        if (日 <= 0 || 日 > 30) {
            throw new IllegalArgumentException("invalid 日: " + 日);
        }
        this.日 = 日;
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
               + "日=" + 日
               + ",月建=" + 月建
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
        final 日辰 casted = (日辰) o;
        return 日 == casted.日 && 月建.equals(casted.月建);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), 月建, 日);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public int compareTo(final 日辰 o) {
        return COMPARING_月建_THEN_COMPARING_DAY_OF_MONTH.compare(this, o);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The day-of-month of this 日辰.
     */
    @NotNull
    public final int 日;

    /**
     * The 月建 of this 日辰.
     */
    @Valid
    @NotNull
    public final 月建 月建;
}
