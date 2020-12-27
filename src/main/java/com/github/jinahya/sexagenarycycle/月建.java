package com.github.jinahya.sexagenarycycle;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.Month;
import java.util.Comparator;
import java.util.Objects;

/**
 * Represents a 干支 assigned to a specific month of a year.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://ko.wikipedia.org/wiki/%EC%9B%94%EA%B1%B4">월건</a>
 */
public class 月建 extends Assigned<月建> { // 월건

    static final Comparator<月建> 閏月_FIRST = (o1, o2) -> Boolean.compare(o1.is閏月(), o2.is閏月());

    static final Comparator<月建> 閏月_LAST = (o1, o2) -> 閏月_FIRST.compare(o2, o1);

    static final Comparator<月建> COMPARING_歲次_THEN_COMPARING_月
            = Comparator.<月建, 歲次>comparing(v -> v.歲次).thenComparing(v -> v.月);

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance with specified 月 and 歲次 representing a 閏月.
     *
     * @param 月  the 月.
     * @param 歲次 the 歲次.
     * @return a new instance represents a 閏月.
     */
    public static 月建 newInstanceOf閏月(final Month 月, final 歲次 歲次) {
        return new 月建(null, 月, 歲次);
    }

    // -------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance with specified 干支, 歲次, and month.
     *
     * @param 干支 the 干支; {@code null} for a leap month.
     * @param 月  the month.
     * @param 歲次 the 歲次.
     */
    public 月建(final 干支 干支, final Month 月, final 歲次 歲次) {
        super(干支);
        this.月 = Objects.requireNonNull(月, "月 is null");
        this.歲次 = Objects.requireNonNull(歲次, " 歲次 is null");
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
               + "月=" + 月
               + ",閏月=" + is閏月()
               + ",歲次=" + 歲次
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
        final 月建 casted = (月建) o;
        return 歲次.equals(casted.歲次) && 月 == casted.月;
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), 歲次, 月);
    }

    // -------------------------------------------------------------------------------------------------------------
    @Override
    public int compareTo(final 月建 o) {
        return COMPARING_歲次_THEN_COMPARING_月.thenComparing(閏月_LAST).compare(this, o);
    }

    // -------------------------------------------------------------------------------------------------------------

    /**
     * Indicates whether this 月建 represents a 閏月.
     *
     * @return {@code true} when this 月建 represents a a 閏月; {@code false} otherwise.
     */
    public boolean is閏月() {
        return 干支 == null;
    }

    // -------------------------------------------------------------------------------------------------------------

    /**
     * The 月 of this 月建.
     */
    @NotNull
    public final Month 月;

    /**
     * The 歲次 of this 月建.
     */
    @Valid
    @NotNull
    public final 歲次 歲次;
}
