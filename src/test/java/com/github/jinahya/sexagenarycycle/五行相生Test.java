package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
class 五行相生Test extends 生剋五行Test<五行相生> {

    五行相生Test() {
        super(五行相生.class);
    }

    // ------------------------------------------------------------------------------------------- valueOfSubjective(五行)
    @Test
    void valueOfSubjective_NonNull_ForEach五行() {
        for (final 五行 subjective : 五行.values()) {
            assertThat(五行相生.valueOfSubjective(subjective)).isNotNull();
        }
    }

    @Test
    void valueOfSubjective_CollectToSetOfAll_ForAll五行() {
        final Set<五行相生> actual = Arrays.stream(五行.values()).map(五行相生::valueOfSubjective).collect(toSet());
        final Set<五行相生> expected = EnumSet.allOf(五行相生.class);
        assertThat(actual).isEqualTo(expected);
    }

    // -------------------------------------------------------------------------------------------- valueOfObjective(五行)
    @Test
    void valueOfObjective_NonNull_ForEach五行() {
        for (final 五行 objective : 五行.values()) {
            assertThat(五行相生.valueOfObjective(objective)).isNotNull();
        }
    }

    @Test
    void valueOfObjective_CollectToSetOfAll_ForAll五行() {
        final Set<五行相生> actual = Arrays.stream(五行.values()).map(五行相生::valueOfObjective).collect(toSet());
        final Set<五行相生> expected = EnumSet.allOf(五行相生.class);
        assertThat(actual).isEqualTo(expected);
    }

    // ------------------------------------------------------------------------------------------------- getSubjective()
    @Test
    void getSubjective_Expected_OfValueOfObjective() {
        assertThat(五行相生.valueOfObjective(五行.火).getSubjective()).isSameAs(五行.木);
        assertThat(五行相生.valueOfObjective(五行.土).getSubjective()).isSameAs(五行.火);
        assertThat(五行相生.valueOfObjective(五行.金).getSubjective()).isSameAs(五行.土);
        assertThat(五行相生.valueOfObjective(五行.水).getSubjective()).isSameAs(五行.金);
        assertThat(五行相生.valueOfObjective(五行.木).getSubjective()).isSameAs(五行.水);
    }

    // -------------------------------------------------------------------------------------------------- getObjective()
    @Test
    void getObjective_Expected_OfValueOfSubjective() {
        assertThat(五行相生.valueOfSubjective(五行.木).getObjective()).isSameAs(五行.火);
        assertThat(五行相生.valueOfSubjective(五行.火).getObjective()).isSameAs(五行.土);
        assertThat(五行相生.valueOfSubjective(五行.土).getObjective()).isSameAs(五行.金);
        assertThat(五行相生.valueOfSubjective(五行.金).getObjective()).isSameAs(五行.水);
        assertThat(五行相生.valueOfSubjective(五行.水).getObjective()).isSameAs(五行.木);
    }
}