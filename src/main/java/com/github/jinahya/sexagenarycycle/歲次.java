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
public class 歲次 extends Assigned<歲次> {

    static final Comparator<歲次> COMPARING_YEAR = Comparator.comparing(v -> v.年);

    // -------------------------------------------------------------------------------------------------------------

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

    // -------------------------------------------------------------------------------------------------------------

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
        歲次 歲次 = (歲次) o;
        return 年.equals(歲次.年);
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
        return COMPARING_YEAR.compare(this, o);
    }

    // -------------------------------------------------------------------------------------------------------------

    /**
     * Returns the previous value of this 歲次.
     *
     * @return the previous value of this 歲次.
     */
    public 歲次 getPrevious() {
        {
            final 歲次 p = previous;
            if (p != null) {
                return p;
            }
        }
        synchronized (this) {
            if (previous == null) {
                previous = new 歲次(干支.getPrevious(), 年.minusYears(1L));
            }
            return previous;
        }
    }

    /**
     * Returns the next value of this 歲次.
     *
     * @return the next value of this 歲次.
     */
    public 歲次 getNext() {
        {
            歲次 n = next;
            if (n != null) {
                return n;
            }
        }
        synchronized (this) {
            if (next == null) {
                next = new 歲次(干支.getNext(), 年.plusYears(1L));
            }
            return next;
        }
    }

    // -------------------------------------------------------------------------------------------------------------
    @NotNull
    public final Year 年;

    // -----------------------------------------------------------------------------------------------------------------
    private volatile 歲次 previous;

    private volatile 歲次 next;
}
