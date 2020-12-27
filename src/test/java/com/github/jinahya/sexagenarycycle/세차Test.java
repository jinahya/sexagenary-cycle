package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class 세차Test implements RollingTest<세차> {

    // -----------------------------------------------------------------------------------------------------------------
    static Stream<세차> parameters() {
        return 歲次Test.parameters()
                .map(세차::new);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"parameters"})
    @ParameterizedTest
    void toString_NonBlank(final 세차 세차) {
        assertThat(세차.toString()).isNotBlank();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"parameters"})
    @ParameterizedTest
    void equals_True_Self(final 세차 세차) {
        assertThat(세차).isEqualTo(세차);
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void equals_True_Clone(final 세차 세차) {
        assertThat(세차).isEqualTo(세차.clone());
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"parameters"})
    @ParameterizedTest
    void hashCode_NoException_(final 세차 세차) {
        assertThatNoException().isThrownBy(세차::hashCode);
    }

    // ------------------------------------------------------------------------------------------------------- compareTo
    @MethodSource({"parameters"})
    @ParameterizedTest
    void compareTo_Zero(final 세차 세차) {
        assertThat(세차).isEqualByComparingTo(세차);
        assertThat(세차).isEqualByComparingTo(세차.clone());
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public 세차[] values() {
        return parameters().toArray(세차[]::new);
    }
}
