package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;

/**
 * Constants for overacting cycle of 五行.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://en.wikipedia.org/wiki/Wuxing_(Chinese_philosophy)#Overacting">Overacting (Wikipedia)</a>
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S115", "java:S116", "java:S117"})
public enum 五行相乘 // 오행상승
        implements 生剋五行<五行相乘> {

    /**
     * The 1st.
     * <blockquote>Wood depletes Earth (depletion of nutrients in soil, overfarming, overcultivation)</blockquote>
     */
    木乘土,

    /**
     * The 2nd.
     * <blockquote>Earth obstructs Water (over-damming)</blockquote>
     */
    土乘水,

    /**
     * The 3rd.
     * <blockquote>Water extinguishes Fire</blockquote>
     */
    水乘火,

    /**
     * The 4th.
     * <blockquote>Fire vaporizes Metal</blockquote>
     */
    火乘金,

    /**
     * The 5th.
     * <blockquote>Metal overharvests Wood (deforestation)</blockquote>
     */
    金乘木;

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the value whose {@link #getSubjective() subjective} matches to specified subjective.
     *
     * @param subjective the subjective.
     * @return the value whose {@link ##getSubjective() subjective}matches to {@code subjective}.
     */
    public static 五行相乘 valueOfSubjective(final 五行 subjective) {
        return 生剋五行Helper.valueOfSubjective(五行相乘.class, subjective);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the value whose {@link #getObjective() objective} matches to specified objective.
     *
     * @param objective the objective.
     * @return the value whose {@link #getObjective()} objective} matches to {@code objective}.
     */
    public static 五行相乘 valueOfObjective(final 五行 objective) {
        return 生剋五行Helper.valueOfObjective(五行相乘.class, objective);
    }

    // -----------------------------------------------------------------------------------------------------------------
    五行相乘() {
        五行相剋 = com.github.jinahya.sexagenarycycle.五行相剋.values()[ordinal()];
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public @NotNull 五行 getSubjective() {
        return 五行相剋.getSubjective();
    }

    @Override
    public @NotNull 五行 getObjective() {
        return 五行相剋.getObjective();
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final @NotNull 五行相剋 五行相剋;
}
