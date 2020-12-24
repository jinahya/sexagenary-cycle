package com.github.jinahya.sexagenarycycle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A class for <a href="https://en.wikipedia.org/wiki/Sexagenary_cycle">Sexagenary cycle</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://ko.wikipedia.org/wiki/%EA%B0%84%EC%A7%80">간지</a>
 */
public final class 간지 { // \uac04\uc9c0

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * A regular expression for matching {@link #getName() name}. The value is {@value}.
     */
    public static final String REGEXP_NAME = "(?<" + 干支.REGEXP_NAME_GROUP_STEM + ">" + 천간.REGEXP_NAME + ")"
                                             + "(?<" + 干支.REGEXP_NAME_GROUP_BRANCH + ">" + 지지.REGEXP_NAME + ")";

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * An unmodifiable list of all values.
     */
    public static final List<간지> VALUES;

    static {
        final List<간지> values = new ArrayList<>();
        {
            final 천간[] stems = 천간.values();
            final 지지[] branches = 지지.values();
            for (int s = 0, b = 0; ; s = ++s % stems.length, b = ++b % branches.length) {
                values.add(new 간지(stems[s], branches[b]));
                if (s == stems.length - 1 && b == branches.length - 1) {
                    break;
                }
            }
        }
        VALUES = Collections.unmodifiableList(values);
    }

    private static final Map<천간, Map<지지, 간지>> HASHED_VALUES;

    static {
        final Map<천간, Map<지지, 간지>> hashedValues = new EnumMap<>(천간.class);
        VALUES.forEach(천간 -> {
            hashedValues.computeIfAbsent(천간.간, k -> new EnumMap<>(지지.class))
                    .compute(천간.지, (k, v) -> {
                        assert v == null;
                        return 천간;
                    });
        });
        HASHED_VALUES = Collections.unmodifiableMap(hashedValues);
    }

    /**
     * Returns the value of specified 천간 and 지지.
     *
     * @param 간 the value of 천간.
     * @param 지 the value of 지지.
     * @return the value of {@code 간} and {@code 지}.
     */
    public static 간지 valueOf(final 천간 간, final 지지 지) {
        Objects.requireNonNull(간, "간 is null");
        Objects.requireNonNull(지, "지 is null");
        return Optional.ofNullable(HASHED_VALUES.get(간))
                .map(m -> m.get(지))
                .orElseThrow(() -> new IllegalArgumentException("no value for " + 간 + " and " + 지));
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<String, 간지> VALUES_BY_NAMES = Collections.unmodifiableMap(
            VALUES.stream().collect(Collectors.toMap(간지::getName, Function.identity())));

    /**
     * Returns the value associated to specified name.
     *
     * @param name the name.
     * @return the value of {@code name}.
     */
    public static 간지 valueOfName(final String name) {
        Objects.requireNonNull(name, "name is null");
        return Optional.ofNullable(VALUES_BY_NAMES.get(name))
                .orElseThrow(() -> new IllegalArgumentException("no value for name: " + name));
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the value of specified 干支.
     *
     * @param 干支 the 干支.
     * @return the value of {@code 干支}.
     */
    public static 간지 valueOf(final 干支 干支) {
        Objects.requireNonNull(干支, "干支 is null");
        return valueOf(천간.valueOf天干(干支.干), 지지.valueOf地支(干支.支));
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance with specified 천간 and 지지.
     *
     * @param 간 the value of 천간.
     * @param 지 the value of 지지.
     */
    private 간지(final 천간 간, final 지지 지) {
        super();
        this.간 = Objects.requireNonNull(간, "干 is null");
        this.지 = Objects.requireNonNull(지, "支 is null");
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
               + "간=" + 간
               + ",지=" + 지
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
        final 간지 casted = (간지) o;
        return 간 == casted.간 && 지 == casted.지;
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(간, 지);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the 干支 value equivalent to this 지지.
     *
     * @return the 干支 value equivalent to this 지지.
     */
    public 干支 get干支() {
        return 干支.valueOf(간.天干, 지.地支);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the name of this 간지.
     *
     * @return the name of this 간지.
     * @see #valueOfName(String)
     */
    public String getName() {
        return 간.name() + 지.name();
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the previous value of this 간지.
     *
     * @return previous value of this 간지.
     */
    // http://jtechies.blogspot.com/2012/07/item-71-use-lazy-initialization.html
    public 간지 getPrevious() {
        간지 p = previous;
        if (p == null) {
            previous = p = valueOf(간.getPrevious(), 지.getPrevious());
        }
        return p;
    }

    /**
     * Returns the next value of this 간지.
     *
     * @return next value of this 간지.
     */
    // http://jtechies.blogspot.com/2012/07/item-71-use-lazy-initialization.html
    public 간지 getNext() {
        간지 n = next;
        if (n == null) {
            next = n = valueOf(간.getNext(), 지.getNext());
        }
        return n;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public final 천간 간;

    public final 지지 지;

    // -----------------------------------------------------------------------------------------------------------------
    private volatile 간지 previous;

    private volatile 간지 next;
}