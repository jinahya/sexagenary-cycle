package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/**
 * Constants for inter-regulating cycle of 五行.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S115"})
public enum 五行相剋 implements 生剋五行<五行相剋> {

    /**
     * The 1st.
     * <blockquote>Wood parts (or stabilizes) Earth (roots of trees can prevent soil erosion)</blockquote>
     */
    木剋土(五行.木, 五行.土),

    /**
     * The 2nd.
     * <blockquote>Earth contains (or directs) Water (dams or river banks)</blockquote>
     */
    土剋水(五行.土, 五行.水),

    /**
     * The 3rd.
     * <blockquote>Water dampens (or regulates) Fire</blockquote>
     */
    水剋火(五行.水, 五行.火),

    /**
     * The 4th.
     * <blockquote>ire melts (or refines or shapes) Metal</blockquote>
     */
    火剋金(五行.火, 五行.金),

    /**
     * The 5th.
     * <blockquote>Metal chops (or carves) Wood</blockquote>
     */
    金剋木(五行.金, 五行.木);

    // -----------------------------------------------------------------------------------------------------------------
    /**
     * Returns the value associated with specified subjective.
     *
     * @param subjective the subjective.
     * @return the value associated with {@code subjective}.
     */
    public static 五行相剋 valueOfSubjective(final 五行 subjective) {
        return 生剋五行Helper.valueOfSubjective(五行相剋.class, subjective);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the value associated with specified objective.
     *
     * @param objective the objective.
     * @return the value associated with {@code objective}.
     */
    public static 五行相剋 valueOfObjective(final 五行 objective) {
        return 生剋五行Helper.valueOfObjective(五行相剋.class, objective);
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
    @Override
    public @NotNull 五行 getSubjective() {
        return subjective;
    }

    @Override
    public @NotNull 五行 getObjective() {
        return objective;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The subjective phase of this inter-promoting.
     */
    private final @NotNull 五行 subjective;

    /**
     * The objective phase of this inter-promoting.
     */
    private final @NotNull 五行 objective;
}
