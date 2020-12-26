package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class 월건Test {

    // ---------------------------------------------------------------------------------------------------------- from月建
    @MethodSource("com.github.jinahya.sexagenarycycle.月建Test#parameters")
    @ParameterizedTest
    void from月建_NonNull(final 月建 月建) {
        final 월건 월건 = com.github.jinahya.sexagenarycycle.월건.from(月建);
        assertThat(월건).isNotNull();
    }

    // ----------------------------------------------------------------------------------------------------- ofLeapMonth
    @MethodSource("com.github.jinahya.sexagenarycycle.月建Test#parameters")
    @ParameterizedTest
    void ofLeapMonth_(final 月建 月建) {
        if (!月建.is閏月()) {
            return;
        }
        final 월건 월건 = com.github.jinahya.sexagenarycycle.월건.of윤달(月建.月, 세차.from(月建.歲次));
        assertThat(월건).isNotNull().satisfies(v -> {
            assertThat(v.is윤달()).isTrue();
        });
    }

    // -----------------------------------------------------------------------------------------------------------------
    static Stream<월건> parameters() {
        return 月建Test.parameters()
                .map(월건::from);
    }

    // ------------------------------------------------------------------------------------------------------------ to月建
    @MethodSource({"parameters"})
    @ParameterizedTest
    void to月建_NonNull_(final 월건 월건) {
        final 月建 月建 = 월건.to月建();
        assertThat(月建).isNotNull();
    }

    // -------------------------------------------------------------------------------------------------------- toString
    @MethodSource({"parameters"})
    @ParameterizedTest
    void toString_NonBlank_(final 월건 월건) {
        final String string = 월건.toString();
        assertThat(string).isNotBlank();
    }

    // ---------------------------------------------------------------------------------------------------------- equals
    @MethodSource({"parameters"})
    @ParameterizedTest
    void equals_True_Self(final 월건 월건) {
        assertThat(월건).isEqualByComparingTo(월건);
        assertThat(월건.equals(월건)).isTrue();
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void equals_True_Clone(final 월건 월건) throws CloneNotSupportedException {
        assertThat(월건).isEqualByComparingTo(월건.clone());
        assertThat(월건.equals(월건.clone())).isTrue();
    }

    // -------------------------------------------------------------------------------------------------------- hashCode
    @MethodSource({"parameters"})
    @ParameterizedTest
    void hashCode_NoException_(final 월건 월건) {
        final int hashCode = 월건.hashCode();
    }
}
