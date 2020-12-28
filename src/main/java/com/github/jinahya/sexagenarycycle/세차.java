package com.github.jinahya.sexagenarycycle;

/**
 * Represents a {@link 간지} assigned to a specific year.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see 歲次
 * @see <a href="https://ko.wikipedia.org/wiki/%EC%84%B8%EC%B0%A8_(%EA%B0%84%EC%A7%80)">세차 (간지)</a>
 */
@SuppressWarnings("NonAsciiCharacters")
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
    public 세차 getPrevious() {
        final 세차 result = previous;
        if (result != null) {
            return result;
        }
        synchronized (this) {
            if (previous == null) {
                previous = new 세차(assigned.getPrevious());
            }
            return previous;
        }
    }

    @Override
    public 세차 getNext() {
        final 세차 result = next;
        if (result != null) {
            return result;
        }
        synchronized (this) {
            if (next == null) {
                next = new 세차(assigned.getNext());
            }
            return next;
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    private volatile 세차 previous;

    private volatile 세차 next;
}
