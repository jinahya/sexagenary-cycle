package com.github.jinahya.sexagenarycycle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.Objects.requireNonNull;
import static java.util.Optional.ofNullable;

/**
 * A class for <a href="https://en.wikipedia.org/wiki/Sexagenary_cycle">Sexagenary cycle</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://en.wikipedia.org/wiki/Sexagenary_cycle">Sexagenary cycle</a>
 * @see <a href="https://ko.wikipedia.org/wiki/%EA%B0%84%EC%A7%80">간지</a>
 */
public final class 干支 { // \u5e72\u652f 간지(\uac04\uc9c0)

    // -----------------------------------------------------------------------------------------------------------------
    static final String REGEXP_NAME_GROUP_STEM = "stem";

    static final String REGEXP_NAME_GROUP_BRANCH = "branch";

    static final String REGEXP_NAME = "(?<" + REGEXP_NAME_GROUP_STEM + ">" + 天干.REGEXP_NAME + ")"
                                      + "(?<" + REGEXP_NAME_GROUP_BRANCH + ">" + 地支.REGEXP_NAME + ")";

    static final String REGEXP_KOREAN_NAME = "(?<" + REGEXP_NAME_GROUP_STEM + ">" + 天干.REGEXP_KOREAN_NAME + ")"
                                             + "(?<" + REGEXP_NAME_GROUP_BRANCH + ">" + 地支.REGEXP_KOREAN_NAME + ")";

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * An unmodifiable list of all values.
     */
    public static final List<干支> VALUES;

    static {
        final List<干支> values = new ArrayList<>();
        {
            final 天干[] stems = 天干.values();
            final 地支[] branches = 地支.values();
            for (int s = 0, b = 0; ; s = ++s % stems.length, b = ++b % branches.length) {
                values.add(new 干支(stems[s], branches[b]));
                if (s == stems.length - 1 && b == branches.length - 1) {
                    break;
                }
            }
        }
        VALUES = Collections.unmodifiableList(values);
    }

    private static final Map<天干, Map<地支, 干支>> HASHED_VALUES;

    static {
        final Map<天干, Map<地支, 干支>> hashedValues = new EnumMap<>(天干.class);
        VALUES.forEach(stemAndBranch -> {
            hashedValues.computeIfAbsent(stemAndBranch.getStem(), k -> new EnumMap<>(地支.class))
                    .compute(stemAndBranch.getBranch(), (k, v) -> {
                        assert v == null;
                        return stemAndBranch;
                    });
        });
        HASHED_VALUES = Collections.unmodifiableMap(hashedValues);
    }

    /**
     * Returns the value of specified 天干 and 地支.
     *
     * @param 干 the 天干.
     * @param 支 the 地支.
     * @return the value of specified 天干 and 地支.
     */
    public static 干支 valueOf(final 天干 干, final 地支 支) {
        requireNonNull(干, "干 is null");
        requireNonNull(支, "支 is null");
        return ofNullable(HASHED_VALUES.get(干))
                .map(m -> m.get(支))
                .orElseThrow(() -> new IllegalArgumentException("no value for " + 干 + " and " + 支));
    }

    /**
     * Returns the value associated to specified name.
     *
     * @param name the name.
     * @return the value of {@code name}.
     */
    public static 干支 valueOfName(final String name) {
        requireNonNull(name, "name is null");
        final int[] codepoints = name.chars().toArray();
        if (codepoints.length != 2) {
            throw new IllegalArgumentException(
                    "invalid number of codepoints(" + codepoints.length + ") from " + name);
        }
        final 天干 干 = 天干.valueOf(new String(codepoints, 0, 1));
        final 地支 支 = 地支.valueOf(new String(codepoints, 1, 1));
        return valueOf(干, 支);
    }

    /**
     * Returns the value associated to specified name in Korean.
     *
     * @param name the name.
     * @return the value of {@code name}.
     */
    public static 干支 valueOfKoreanName(final String name) {
        requireNonNull(name, "koreanName is null");
        final int[] codepoints = name.chars().toArray();
        if (codepoints.length != 2) {
            throw new IllegalArgumentException(
                    "invalid number of codepoints(" + codepoints.length + ") from " + name);
        }
        final 天干 干 = 天干.valueOfKoreanName(new String(codepoints, 0, 1));
        final 地支 支 = 地支.valueOfKoreanName(new String(codepoints, 1, 1));
        return valueOf(干, 支);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance with specified 天干 and 地支.
     *
     * @param 干 the 天干.
     * @param 支 the 地支.
     */
    private 干支(final 天干 干, final 地支 支) {
        super();
        this.干 = requireNonNull(干, "干 is null");
        this.支 = requireNonNull(支, "支 is null");
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
               + "干=" + 干
               + ",支=" + 支
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final 干支 casted = (干支) o;
        return 干 == casted.干 && 支 == casted.支;
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(干, 支);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the previous value of this 干支.
     *
     * @return previous value of this 干支.
     */
    // http://jtechies.blogspot.com/2012/07/item-71-use-lazy-initialization.html
    public 干支 getPrevious() {
        干支 p = previous;
        if (p == null) {
            previous = p = valueOf(干.getPrevious(), 支.getPrevious());
        }
        return p;
    }

    /**
     * Returns the next value of this 干支.
     *
     * @return next value of this 干支.
     */
    // http://jtechies.blogspot.com/2012/07/item-71-use-lazy-initialization.html
    public 干支 getNext() {
        干支 n = next;
        if (n == null) {
            next = n = valueOf(干.getNext(), 支.getNext());
        }
        return n;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the name of this 干支.
     *
     * @return the name of this 干支.
     * @see #valueOfName(String)
     */
    public String getName() {
        return 干.name() + 支.name();
    }

    /**
     * Returns the Korean name of this 干支.
     *
     * @return the Korean name of this 干支.
     * @see #valueOfKoreanName(String)
     */
    public String getKoreanName() {
        return 干.koreanName() + 支.koreanName();
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the 天干 of this 干支.
     *
     * @return the 天干 of this 干支.
     * @see #getStem()
     */
    public 天干 get干() {
        return 干;
    }

    /**
     * Returns the 天干 of this 干支.
     *
     * @return the 天干 of this 干支.
     * @see #get干()
     */
    public 天干 getStem() {
        return get干();
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the 地支 of this 干支.
     *
     * @return the 地支 of this 干支.
     * @see #getBranch()
     */
    public 地支 get支() {
        return 支;
    }

    /**
     * Returns the 地支 of this 干支.
     *
     * @return the 地支 of this 干支.
     * @see #get支()
     */
    public 地支 getBranch() {
        return get支();
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final 天干 干;

    private final 地支 支;

    // -----------------------------------------------------------------------------------------------------------------
    private volatile 干支 previous;

    private volatile 干支 next;
}