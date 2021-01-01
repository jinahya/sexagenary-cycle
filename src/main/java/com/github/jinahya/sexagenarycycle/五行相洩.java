package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Constants for weakening cycle of 五行.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://en.wikipedia.org/wiki/Wuxing_(Chinese_philosophy)#Weakening">Weakening (Wikipedia)</a>
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S115", "java:S116", "java:S117"})
public enum 五行相洩 // 오행상설
        implements 生剋五行<五行相洩> {

    /**
     * The 1st.
     * <blockquote>Wood depletes Water</blockquote>
     */
    木洩水(com.github.jinahya.sexagenarycycle.五行相生.水生木),

    /**
     * The 2nd.
     * <blockquote>Water rusts Metal</blockquote>
     */
    水洩金(com.github.jinahya.sexagenarycycle.五行相生.金生水),

    /**
     * The 3rd.
     * <blockquote>Metal impoverishes Earth (overmining or over-extraction of the earth's minerals)</blockquote>
     */
    金洩土(com.github.jinahya.sexagenarycycle.五行相生.土生金),

    /**
     * Thd 4th.
     * <blockquote>Earth smothers Fire</blockquote>
     */
    土洩火(com.github.jinahya.sexagenarycycle.五行相生.火生土),

    /**
     * The 5th.
     * <blockquote>Fire burns Wood (forest fires)</blockquote>
     */
    火洩木(com.github.jinahya.sexagenarycycle.五行相生.木生火);

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the value whose {@link #getSubjective() subjective} matches to specified subjective.
     *
     * @param subjective the subjective.
     * @return the value whose {@link ##getSubjective() subjective}matches to {@code subjective}.
     */
    public static 五行相洩 valueOfSubjective(final 五行 subjective) {
        return 生剋五行Helper.valueOfSubjective(五行相洩.class, subjective);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the value whose {@link #getObjective() objective} matches to specified objective.
     *
     * @param objective the objective.
     * @return the value whose {@link #getObjective()} objective} matches to {@code objective}.
     */
    public static 五行相洩 valueOfObjective(final 五行 objective) {
        return 生剋五行Helper.valueOfObjective(五行相洩.class, objective);
    }

    // -----------------------------------------------------------------------------------------------------------------
    五行相洩(final 五行相生 五行相生) {
        this.五行相生 = Objects.requireNonNull(五行相生, "五行相生 is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public @NotNull 五行 getSubjective() {
        return 五行相生.getObjective();
    }

    @Override
    public @NotNull 五行 getObjective() {
        return 五行相生.getSubjective();
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final @NotNull 五行相生 五行相生;
}
