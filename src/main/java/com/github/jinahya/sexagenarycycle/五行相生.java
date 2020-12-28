package com.github.jinahya.sexagenarycycle;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Defines constants for {@code inter-promoting} cycle and {@code weakening} cycle between values of {@link 五行}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@SuppressWarnings("NonAsciiCharacters")
public enum 五行相生 {

    木生火(五行.木, 五行.火),

    火生土(五行.火, 五行.土),

    土生金(五行.土, 五行.金),

    金生水(五行.金, 五行.水),

    水生木(五行.水, 五行.木);

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<五行, 五行相生> VALUES_BY_SUBJECTIVES = Collections.unmodifiableMap(
            Arrays.stream(values()).collect(Collectors.toMap(
                    v -> v.subjective,
                    Function.identity(),
                    (v1, v2) -> {
                        throw new AssertionError("shouldn't happen; duplicate value: " + v1 + ", " + v2);
                    },
                    () -> new EnumMap<>(五行.class)
            ))
    );

    public static 五行相生 valueOfSubjective(final 五行 subject) {
        Objects.requireNonNull(subject, "subjective is null");
        final 五行相生 value = VALUES_BY_SUBJECTIVES.get(subject);
        if (value == null) {
            throw new AssertionError("shouldn't happen; no value for subjective: " + subject);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<五行, 五行相生> VALUES_BY_OBJECTIVES = Collections.unmodifiableMap(
            Arrays.stream(values()).collect(Collectors.toMap(
                    v -> v.objective,
                    Function.identity(),
                    (v1, v2) -> {
                        throw new AssertionError("shouldn't happen; duplicate value: " + v1 + ", " + v2);
                    },
                    () -> new EnumMap<>(五行.class)
            ))
    );

    public static 五行相生 valueOfObjective(final 五行 objective) {
        Objects.requireNonNull(objective, "objective is null");
        final 五行相生 value = VALUES_BY_OBJECTIVES.get(objective);
        if (value == null) {
            throw new AssertionError("shouldn't happen; no value for objective: " + objective);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the value of specified subjective in inter-promoting cycle.
     *
     * @param subjective the subjective.
     * @return the value of {@code subjective} in inter-promoting cycle.
     */
    public static 五行相生 valueOfSubjectiveInInterPromotingCycle(final 五行 subjective) {
        return valueOfSubjective(subjective);
    }

    /**
     * Returns the value of specified objective in inter-promoting cycle.
     *
     * @param objective the objective.
     * @return the value of {@code objective} in inter-promoting cycle.
     */
    public static 五行相生 valueOfObjectiveInInterPromotingCycle(final 五行 objective) {
        return valueOfObjective(objective);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the value of specified subjective in weakening cycle.
     *
     * @param subjective the subjective.
     * @return the value of {@code subjective} in weakening cycle.
     */
    public static 五行相生 valueOfSubjectiveInWeakeningCycle(final 五行 subjective) {
        return valueOfObjectiveInInterPromotingCycle(subjective);
    }

    /**
     * Returns the value of specified objective in weakening cycle.
     *
     * @param objective the objective.
     * @return the value of {@code objective} in weakening cycle.
     */
    public static 五行相生 valueOfObjectiveInWeakeningCycle(final 五行 objective) {
        return valueOfSubjectiveInInterPromotingCycle(objective);
    }

    // -----------------------------------------------------------------------------------------------------------------
    五行相生(final 五行 subjective, final 五行 objective) {
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
    public final 五行 subjective;

    /**
     * The objective phase of this inter-promoting.
     */
    public final 五行 objective;
}
