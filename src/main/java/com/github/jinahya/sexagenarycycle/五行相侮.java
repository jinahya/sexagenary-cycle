package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Constants for Counteracting cycle of 五行.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://en.wikipedia.org/wiki/Wuxing_(Chinese_philosophy)#Counteracting">Counteracting (Wikipedia)</a>
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S115", "java:S116", "java:S117"})
public enum 五行相侮 // 오행상모
        implements 生剋五行<五行相侮> {

    /**
     * The 1st.
     * <blockquote>Wood dulls Metal</blockquote>
     */
    木侮金(com.github.jinahya.sexagenarycycle.五行相剋.金剋木),

    /**
     * The 2nd.
     * <blockquote>Metal de-energizes Fire (metals conduct heat away)</blockquote>
     */
    金侮火(com.github.jinahya.sexagenarycycle.五行相剋.火剋金),

    /**
     * The 3rd.
     * <blockquote>Fire evaporates Water</blockquote>
     */
    火侮水(com.github.jinahya.sexagenarycycle.五行相剋.水剋火),

    /**
     * The 4th.
     * <blockquote>Water muddies (or destabilizes) Earth</blockquote>
     */
    水侮土(com.github.jinahya.sexagenarycycle.五行相剋.土剋水),

    /**
     * The 5th.
     * <blockquote>arth rots Wood (overpiling soil on wood can rot the wood)</blockquote>
     */
    土乘木(com.github.jinahya.sexagenarycycle.五行相剋.木剋土);

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the value whose {@link #getSubjective() subjective} matches to specified subjective.
     *
     * @param subjective the subjective.
     * @return the value whose {@link ##getSubjective() subjective}matches to {@code subjective}.
     */
    public static 五行相侮 valueOfSubjective(final 五行 subjective) {
        return 生剋五行Helper.valueOfSubjective(五行相侮.class, subjective);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the value whose {@link #getObjective() objective} matches to specified objective.
     *
     * @param objective the objective.
     * @return the value whose {@link #getObjective()} objective} matches to {@code objective}.
     */
    public static 五行相侮 valueOfObjective(final 五行 objective) {
        return 生剋五行Helper.valueOfObjective(五行相侮.class, objective);
    }

    // -----------------------------------------------------------------------------------------------------------------
    五行相侮(final 五行相剋 五行相剋) {
        this.五行相剋 = Objects.requireNonNull(五行相剋, "五行相剋 is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public @NotNull 五行 getSubjective() {
        return 五行相剋.getObjective();
    }

    @Override
    public @NotNull 五行 getObjective() {
        return 五行相剋.getSubjective();
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final @NotNull 五行相剋 五行相剋;
}
