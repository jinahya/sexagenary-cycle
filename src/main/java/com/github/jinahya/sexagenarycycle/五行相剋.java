package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/**
 * Constants for 剋 cycle.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S115"})
public enum 五行相剋 implements RollingEnum<五行相剋>, 生剋五行<五行相剋> {

    木剋土(五行.木, 五行.土),

    土剋水(五行.土, 五行.水),

    水剋火(五行.水, 五行.火),

    火剋金(五行.火, 五行.金),

    金剋木(五行.金, 五行.木);

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<五行, 五行相剋> VALUES_BY_SUBJECTIVES
            = Collections.unmodifiableMap(EnumUtils.mapValuesBy(五行相剋.class, v -> v.subjective));

    /**
     * Returns the value associated to specified subjective.
     *
     * @param subjective the subjective.
     * @return the value associated to {@code subjective}.
     */
    public static 五行相剋 valueOfSubjective(final 五行 subjective) {
        Objects.requireNonNull(subjective, "subjective is null");
        final 五行相剋 value = VALUES_BY_SUBJECTIVES.get(subjective);
        if (value == null) {
            throw new AssertionError("no value for subjective: " + subjective);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<五行, 五行相剋> VALUES_BY_OBJECTIVES
            = Collections.unmodifiableMap(EnumUtils.mapValuesBy(五行相剋.class, v -> v.objective));

    /**
     * Returns the value associated to specified objective.
     *
     * @param objective the objective.
     * @return the value associated to {@code objective}.
     */
    public static 五行相剋 valueOfObjective(final 五行 objective) {
        Objects.requireNonNull(objective, "objective is null");
        final 五行相剋 value = VALUES_BY_OBJECTIVES.get(objective);
        if (value == null) {
            throw new AssertionError("no value for objective: " + objective);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    五行相剋(final 五行 subjective, final 五行 objective) {
        Objects.requireNonNull(subjective, "subjective is null");
        Objects.requireNonNull(objective, "objective is null");
        if (subjective == objective) {
            throw new IllegalArgumentException("subjective(" + subjective + ") == objective(" + objective + ")");
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
