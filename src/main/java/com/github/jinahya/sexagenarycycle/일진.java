package com.github.jinahya.sexagenarycycle;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Comparator;
import java.util.Objects;

/**
 * Represents a {@link 간지} assigned to a specific date.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://ko.wikipedia.org/wiki/%EC%9D%BC%EC%A7%84_(%EA%B0%84%EC%A7%80)">일진 (간지)</a>
 */
public class 일진 extends 부여된<일진> {

    static final Comparator<일진> COMPARING_월건_THEN_COMPARING_일
            = Comparator.<일진, 월건>comparing(v -> v.월건).thenComparingInt(v -> v.일);

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance from specified 日辰.
     *
     * @param 日辰 the 日辰.
     * @return a new instance created from {@code 日辰}.
     */
    @SuppressWarnings({"java:S117"})
    public static 일진 from(final 日辰 日辰) {
        Objects.requireNonNull(日辰, "日辰 is null");
        final 간지 간지 = com.github.jinahya.sexagenarycycle.간지.from(日辰.干支);
        final int 일 = 日辰.日;
        final 월건 월건 = com.github.jinahya.sexagenarycycle.월건.from(日辰.月建);
        return new 일진(간지, 일, 월건);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance with specified 간지, 월건, and day of month.
     *
     * @param 간지 the 간지.
     * @param 일  the day of month.
     * @param 월건 the 월건.
     */
    public 일진(final 간지 간지, final int 일, final 월건 월건) {
        super(Objects.requireNonNull(간지, "간지 is null"));
        this.월건 = Objects.requireNonNull(월건, "월건 is null");
        if (일 <= 0 || 일 > 30) {
            throw new IllegalArgumentException("invalid dayOfMonth: " + 일);
        }
        this.일 = 일;
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
               + "일=" + 일
               + ",월건=" + 월건
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
        final 일진 casted = (일진) o;
        return 일 == casted.일 && 월건.equals(casted.월건);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), 월건, 일);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public int compareTo(final 일진 o) {
        return COMPARING_월건_THEN_COMPARING_일.compare(this, o);
    }

    // -------------------------------------------------------------------------------------------------------------- 日辰

    /**
     * Returns an instance of {@code 日辰} created from this 일진.
     *
     * @return an instance {@code 日辰}.
     */
    public 日辰 to日辰() {
        {
            final 日辰 result = 日辰;
            if (result != null) {
                return result;
            }
        }
        synchronized (this) {
            if (日辰 == null) {
                日辰 = new 日辰(간지.to干支(), 일, 월건.to月建());
            }
            return 日辰;
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The day-of-month of this 日辰.
     */
    @Max(30)
    @Min(1)
    public final int 일;

    /**
     * The 월건 of this 日辰.
     */
    @Valid
    @NotNull
    public final 월건 월건;

    // -----------------------------------------------------------------------------------------------------------------
    private volatile 日辰 日辰;
}
