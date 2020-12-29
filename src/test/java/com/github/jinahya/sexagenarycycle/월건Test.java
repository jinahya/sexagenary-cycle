package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
class 월건Test {

    // -----------------------------------------------------------------------------------------------------------------
    static Stream<월건> parameters() {
        return 月建Test.parameters()
                .map(월건::new);
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
        assertThat(월건).isEqualTo(월건);
    }

    // -------------------------------------------------------------------------------------------------------- hashCode
    @MethodSource({"parameters"})
    @ParameterizedTest
    void hashCode_NoException_(final 월건 월건) {
        assertThatNoException().isThrownBy(월건::hashCode);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"parameters"})
    @ParameterizedTest
    void is윤달(final 월건 월건) {
        assertThat(월건.is윤달()).isSameAs(월건.assigned.is閏月());
    }
}
