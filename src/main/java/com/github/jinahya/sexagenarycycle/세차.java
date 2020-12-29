package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;

/**
 * Represents a {@link 간지} assigned to a specific year.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see 歲次
 * @see <a href="https://ko.wikipedia.org/wiki/%EC%84%B8%EC%B0%A8_(%EA%B0%84%EC%A7%80)">세차 (간지)</a>
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S101", "java:S117"})
public class 세차 extends 부여된<세차, 歲次> implements Rolling<세차> {

    // -------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance with specified 歲次.
     *
     * @param 歲次 the 歲次.
     */
    public 세차(final 歲次 歲次) {
        super(歲次);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public @NotNull 세차 getPrevious() {
        세차 result = previous;
        if (result == null) {
            previous = result = new 세차(assigned.getPrevious());
        }
        return result;
    }

    @Override
    public @NotNull 세차 getNext() {
        세차 result = next;
        if (result == null) {
            next = result = new 세차(assigned.getNext());
        }
        return result;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @SuppressWarnings({"java:S3077"})
    private volatile 세차 previous;

    @SuppressWarnings({"java:S3077"})
    private volatile 세차 next;
}
