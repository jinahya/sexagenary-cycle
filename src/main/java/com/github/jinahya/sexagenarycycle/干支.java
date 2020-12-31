package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
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
 * @see 간지
 * @see <a href="https://zh.wikipedia.org/wiki/%E5%B9%B2%E6%94%AF">干支</a>.
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S101", "java:S116", "java:S117"})
public final class 干支 implements Rolling<干支> { // \u5e72\u652f

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * A group name for matching {@code 干} group in {@link #REGEXP_NAME}. The value is {@value}.
     */
    public static final String REGEXP_NAME_GROUP_STEM = "stem";

    /**
     * A group name for matching {@code 支} group in {@link #REGEXP_NAME}. The value is {@value}.
     */
    public static final String REGEXP_NAME_GROUP_BRANCH = "branch";

    /**
     * A regular expression for matching {@link #getName() name}. The value is {@value}.
     */
    public static final String REGEXP_NAME = "(?<" + REGEXP_NAME_GROUP_STEM + ">" + 天干.REGEXP_NAME + ")"
                                             + "(?<" + REGEXP_NAME_GROUP_BRANCH + ">" + 地支.REGEXP_NAME + ")";

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * An unmodifiable list of all values.
     */
    static final List<干支> VALUES;

    static {
        final List<干支> values = new ArrayList<>();
        final 天干[] stems = 天干.values();
        final 地支[] branches = 地支.values();
        for (int s = 0, b = 0; ; s = ++s % stems.length, b = ++b % branches.length) {
            values.add(new 干支(stems[s], branches[b]));
            if (s == stems.length - 1 && b == branches.length - 1) {
                break;
            }
        }
        VALUES = Collections.unmodifiableList(values);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<天干, Map<地支, 干支>> VALUES_BY_天干S_BY地支S;

    static {
        final Map<天干, Map<地支, 干支>> map = new EnumMap<>(天干.class);
        VALUES.forEach(天干 -> map.computeIfAbsent(天干.干, k -> new EnumMap<>(地支.class))
                .compute(天干.支, (k, v) -> {
                    assert v == null;
                    return 天干;
                })
        );
        VALUES_BY_天干S_BY地支S = Collections.unmodifiableMap(map);
    }

    /**
     * Returns the value of specified 天干 and 地支.
     *
     * @param 干 the value of 天干.
     * @param 支 the value of 地支.
     * @return the value of {@code 干} and {@code 支}.
     */
    public static 干支 valueOf(final 天干 干, final 地支 支) {
        Objects.requireNonNull(干, "干 is null");
        Objects.requireNonNull(支, "支 is null");
        return Optional.ofNullable(VALUES_BY_天干S_BY地支S.get(干))
                .map(m -> m.get(支))
                .orElseThrow(() -> new IllegalArgumentException("no value for " + 干 + " and " + 支));
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<String, 干支> VALUES_BY_NAMES = Collections.unmodifiableMap(
            VALUES.stream().collect(Collectors.toMap(干支::getName, Function.identity())));

    /**
     * Returns the value associated with specified name.
     *
     * @param name the name.
     * @return the value associated with {@code name}.
     */
    public static 干支 valueOfName(final String name) {
        Objects.requireNonNull(name, "name is null");
        return Optional.ofNullable(VALUES_BY_NAMES.get(name))
                .orElseThrow(() -> new IllegalArgumentException("no value for name: " + name));
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance with specified 天干 and 地支.
     *
     * @param 干 the value of 天干.
     * @param 支 the value of 地支.
     */
    private 干支(final 天干 干, final 地支 支) {
        super();
        this.干 = Objects.requireNonNull(干, "干 is null");
        this.支 = Objects.requireNonNull(支, "支 is null");
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
    @Override
    public @NotNull 干支 getPrevious() {
        return RollingHelper.getPrevious(this, c -> valueOf(c.干.getPrevious(), c.支.getPrevious()));
    }

    /**
     * Returns the next value of this 干支.
     *
     * @return next value of this 干支.
     */
    @Override
    public @NotNull 干支 getNext() {
        return RollingHelper.getNext(this, c -> valueOf(c.干.getNext(), c.支.getNext()));
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

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    public final 天干 干;

    @NotNull
    public final 地支 支;
}