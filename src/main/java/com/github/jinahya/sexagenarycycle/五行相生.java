package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

/**
 * Constants for inter-promoting cycle of 五行.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S115"})
public enum 五行相生 implements 生剋五行<五行相生> {

    木生火(五行.木, 五行.火),

    火生土(五行.火, 五行.土),

    土生金(五行.土, 五行.金),

    金生水(五行.金, 五行.水),

    水生木(五行.水, 五行.木);

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<五行, 五行相生> VALUES_BY_SUBJECTIVES = Collections.unmodifiableMap(
            EnumUtils.mapValuesBy(五行相生.class, v -> v.subjective, () -> new EnumMap<>(五行.class))
    );

    /**
     * Returns the value whose {@link #subjective} matches to specified value.
     *
     * @param subjective the value for {@link #subjective} to match.
     * @return the value whose {@link #subjective} matches to {@code subjective}.
     */
    public static 五行相生 valueOfSubjective(final 五行 subjective) {
        Objects.requireNonNull(subjective, "subjective is null");
        final 五行相生 value = VALUES_BY_SUBJECTIVES.get(subjective);
        if (value == null) {
            throw new AssertionError("no value for subjective: " + subjective);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<五行, 五行相生> VALUES_BY_OBJECTIVES = Collections.unmodifiableMap(
            EnumUtils.mapValuesBy(五行相生.class, v -> v.objective, () -> new EnumMap<>(五行.class))
    );

    /**
     * Returns the value whose {@link #objective} matches to specified value.
     *
     * @param objective the value for {@link #objective} to match.
     * @return the value whose {@link #objective} matches to {@code objective}.
     */
    public static 五行相生 valueOfObjective(final 五行 objective) {
        Objects.requireNonNull(objective, "objective is null");
        final 五行相生 value = VALUES_BY_OBJECTIVES.get(objective);
        if (value == null) {
            throw new AssertionError("no value for objective: " + objective);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    五行相生(final 五行 subjective, final 五行 objective) {
        Objects.requireNonNull(subjective, "subjective is null");
        Objects.requireNonNull(objective, "objective is null");
        if (objective == subjective) {
            throw new IllegalArgumentException("objective(" + objective + " == " + "subjective(" + subjective + ")");
        }
        this.subjective = subjective;
        this.objective = objective;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The subjective phase of this inter-promoting.
     */
    public final @NotNull 五行 subjective;

    /**
     * The objective phase of this inter-promoting.
     */
    public final @NotNull 五行 objective;
}
