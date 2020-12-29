package com.github.jinahya.sexagenarycycle;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/**
 * Defines constants for {@code inter-regulating} cycle and {@code overacting} cycle, and {@code counteracting} cycle
 * between values of {@link 五行}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S115"})
public enum 五行相剋 implements RollingEnum<五行相剋> {

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
    public static 五行相剋 valueOfSubjectiveInInterRegulatingCycle(final 五行 subjective) {
        return valueOfSubjective(subjective);
    }

    public static 五行相剋 valueOfObjectiveInInterRegulatingCycle(final 五行 objective) {
        return valueOfObjective(objective);
    }

    // -----------------------------------------------------------------------------------------------------------------
    public static 五行相剋 valueOfSubjectiveInOveractingCycle(final 五行 subjective) {
        return valueOfSubjectiveInInterRegulatingCycle(subjective);
    }

    public static 五行相剋 valueOfObjectiveInOveractingCycle(final 五行 objective) {
        return valueOfObjectiveInInterRegulatingCycle(objective);
    }

    // -----------------------------------------------------------------------------------------------------------------
    public static 五行相剋 valueOfSubjectiveInCounteractingCycle(final 五行 subjective) {
        return valueOfObjectiveInOveractingCycle(subjective);
    }

    public static 五行相剋 valueOfObjectiveInCounteractingCycle(final 五行 objective) {
        return valueOfSubjectiveInOveractingCycle(objective);
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
    public 五行相剋 getPreviousInInterRegulatingCycle() {
        return getPrevious();
    }

    public 五行相剋 getNextInInterRegulatingCycle() {
        return getNext();
    }

    // -----------------------------------------------------------------------------------------------------------------
    public 五行相剋 getPreviousInOveractingCycle() {
        return getPreviousInInterRegulatingCycle();
    }

    public 五行相剋 getNextInOveractingCycle() {
        return getNextInInterRegulatingCycle();
    }

    // -----------------------------------------------------------------------------------------------------------------
    public 五行相剋 getPreviousInCounteractingCycle() {
        return getNextInOveractingCycle();
    }

    public 五行相剋 getNextInCounteractingCycle() {
        return getPreviousInOveractingCycle();
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The subjective phase of this inter-promoting.
     */
    public final 五行 subjective;

    /**
     * The objective phase of this inter-promoting.
     */
    public final 五行 objective;
}
