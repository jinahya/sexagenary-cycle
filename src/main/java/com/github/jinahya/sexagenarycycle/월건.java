package com.github.jinahya.sexagenarycycle;

/**
 * Represents a {@link 간지} assigned to a specific month of a year.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://ko.wikipedia.org/wiki/%EC%9B%94%EA%B1%B4">월건</a>
 */
@SuppressWarnings("NonAsciiCharacters")
public class 월건 extends 부여된<월건, 月建> {

    /**
     * Creates a new instance with specified 月建.
     *
     * @param 月建 the 月建.
     */
    public 월건(final 月建 月建) {
        super(月建);
    }

    // --------------------------------------------------------------------------------------------------------------- 월

    /**
     * Indicates whether this 월건 represents a leap month.
     *
     * @return {@code true} when this 월건 represents a a leap month; {@code false} otherwise.
     */
    public boolean is윤달() {
        return assigned.is閏月();
    }
}
