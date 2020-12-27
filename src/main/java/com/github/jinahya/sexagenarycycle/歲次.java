package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.time.Year;
import java.util.Comparator;
import java.util.Objects;

/**
 * Represents a 干支 assigned to a specific year.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see 세차
 * @see <a href="https://ko.wikipedia.org/wiki/%EC%84%B8%EC%B0%A8_(%EA%B0%84%EC%A7%80)">세차 (간지)</a>
 */
public class 歲次 extends Assigned<歲次> implements Rolling<歲次> {

    static final Comparator<歲次> COMPARING_年 = Comparator.comparing(v -> v.年);

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance with specified 干支 and year.
     *
     * @param 干支 the 干支.
     * @param 年  the year.
     */
    public 歲次(final 干支 干支, final Year 年) {
        super(Objects.requireNonNull(干支, "干支 is null"));
        this.年 = Objects.requireNonNull(年, "year is null");
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
               + "年=" + 年
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
        final 歲次 casted = (歲次) o;
        return 年.equals(casted.年);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), 年);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public int compareTo(final 歲次 o) {
        return COMPARING_年.compare(this, o);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the previous value of this 歲次.
     *
     * @return the previous value of this 歲次.
     */
    @Override
    public 歲次 getPrevious() {
        return RollingHelper.getPrevious(歲次.class, this, c -> new 歲次(c.干支.getPrevious(), c.年.minusYears(1L)));
    }

    /**
     * Returns the next value of this 歲次.
     *
     * @return the next value of this 歲次.
     */
    @Override
    public 歲次 getNext() {
        return RollingHelper.getNext(歲次.class, this, c -> new 歲次(c.干支.getNext(), c.年.plusYears(1L)));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    public final Year 年;
}
