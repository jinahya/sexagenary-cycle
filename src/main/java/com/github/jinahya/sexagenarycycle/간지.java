package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A class for <a href="https://en.wikipedia.org/wiki/Sexagenary_cycle">Sexagenary cycle</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://ko.wikipedia.org/wiki/%EA%B0%84%EC%A7%80">간지</a>
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S100", "java:S101", "java:S116", "java:S117"})
public final class 간지 implements Rolling<간지> { // \uac04\uc9c0

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * A regular expression for matching {@link #getName() name}. The value is {@value}.
     */
    public static final String REGEXP_NAME
            = "(?<" + com.github.jinahya.sexagenarycycle.干支.REGEXP_NAME_GROUP_STEM + ">" + 천간.REGEXP_NAME + ")"
              + "(?<" + com.github.jinahya.sexagenarycycle.干支.REGEXP_NAME_GROUP_BRANCH + ">" + 지지.REGEXP_NAME + ")";

    // -----------------------------------------------------------------------------------------------------------------
    static final List<간지> VALUES = Collections.unmodifiableList(
            com.github.jinahya.sexagenarycycle.干支.VALUES.stream().map(간지::new).collect(Collectors.toList()));

    // -----------------------------------------------------------------------------------------------------------------
    static final Map<干支, 간지> VALUES_BY_干支S = Collections.unmodifiableMap(
            VALUES.stream().collect(Collectors.toMap(v -> v.干支, Function.identity()))
    );

    public static 간지 valueOf(final 干支 干支) {
        Objects.requireNonNull(干支, "干支 is null");
        final 간지 value = VALUES_BY_干支S.get(干支);
        if (value == null) {
            throw new AssertionError("no value for " + 干支);
        }
        return value;
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
        final 간지 value = VALUES_BY_NAMES.get(name);
        if (value == null) {
            throw new IllegalArgumentException("no value for name: " + name);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance with specified 干支.
     *
     * @param 干支 the 干支.
     */
    private 간지(final 干支 干支) {
        super();
        this.干支 = Objects.requireNonNull(干支, "干支 is null");
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
               + "干支=" + 干支
               + '}';
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        간지 casted = (간지) o;
        return 干支.equals(casted.干支);
    }

    @Override
    public int hashCode() {
        return Objects.hash(干支);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the name of this 간지.
     *
     * @return the name of this 간지.
     * @see #valueOfName(String)
     */
    public String getName() {
        return get간().name() + get지().name();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public 간지 getPrevious() {
        return RollingHelper.getPrevious(this, c -> valueOf(c.干支.getPrevious()));
    }

    @Override
    public 간지 getNext() {
        return RollingHelper.getNext(this, c -> valueOf(c.干支.getNext()));
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the 천간 of this 간지.
     *
     * @return the 천간 of this 간지.
     */
    public 천간 get간() {
        // racy single-check idiom
        천간 result = 간;
        if (result == null) {
            간 = result = 천간.valueOf(干支.干);
        }
        return result;
    }

    /**
     * Returns the 지지 of this 간지.
     *
     * @return the 지지 of this 간지.
     */
    public 지지 get지() {
        // racy single-check idiom
        지지 result = 지;
        if (result == null) {
            지 = result = 지지.valueOf(干支.支);
        }
        return result;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The 干支 equivalent to this 간지.
     */
    @NotNull
    public final 干支 干支;

    // -----------------------------------------------------------------------------------------------------------------
    private volatile 천간 간;

    private volatile 지지 지;
}