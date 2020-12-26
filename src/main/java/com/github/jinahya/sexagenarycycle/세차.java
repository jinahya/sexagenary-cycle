package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.time.Year;
import java.util.Objects;

import static com.github.jinahya.sexagenarycycle.歲次.COMPARING_YEAR;

/**
 * Represents a {@link 간지} assigned to a specific year.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see 歲次
 * @see <a href="https://ko.wikipedia.org/wiki/%EC%84%B8%EC%B0%A8_(%EA%B0%84%EC%A7%80)">세차 (간지)</a>
 */
public class 세차 extends 부여된<세차> {

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance from specified 歲次.
     *
     * @param 歲次 the 歲次.
     * @return new instance created from {@code 歲次}.
     */
    public static 세차 from(final 歲次 歲次) {
        Objects.requireNonNull(歲次, "歲次 is null");
        return new 세차(com.github.jinahya.sexagenarycycle.간지.from(歲次.干支), 歲次.年);
    }

    // -------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance with specified 간지 and year.
     *
     * @param 간지 the 간지.
     * @param 년  the year.
     */
    public 세차(final 간지 간지, final Year 년) {
        super(간지);
        this.년 = Objects.requireNonNull(년, "년 is null");
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
               + "년=" + 년
               + '}';
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        세차 casted = (세차) o;
        return 년.equals(casted.년);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), 년);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public int compareTo(final 세차 o) {
        return COMPARING_YEAR.compare(to歲次(), o.to歲次());
    }

    // --------------------------------------------------------------------------------------------------------------- 년

    // -------------------------------------------------------------------------------------------------------------- 歲次

    /**
     * Returns a 歲次 equivalent to this 세차.
     *
     * @return a 歲次 equivalent to this 세차.
     */
    public 歲次 to歲次() {
        {
            final 歲次 v = 歲次;
            if (v != null) {
                return v;
            }
        }
        synchronized (this) {
            if (歲次 == null) {
                歲次 = new 歲次(간지.to干支(), 년);
            }
            return 歲次;
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The year of this 세차.
     */
    @NotNull
    public final Year 년;

    // -----------------------------------------------------------------------------------------------------------------
    private volatile 歲次 歲次;
}
