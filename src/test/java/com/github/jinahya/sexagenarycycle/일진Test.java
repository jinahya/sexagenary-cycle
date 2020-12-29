package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
class 일진Test {

    // -----------------------------------------------------------------------------------------------------------------
    static Stream<일진> parameters() {
        return 日辰Test.parameters().map(일진::new);
    }

    // -------------------------------------------------------------------------------------------------------- toString
    @MethodSource({"parameters"})
    @ParameterizedTest
    void toString_NonBlank(final 일진 일진) {
        assertThat(일진.toString()).isNotBlank();
    }

    // ---------------------------------------------------------------------------------------------------------- equals
    @MethodSource({"parameters"})
    @ParameterizedTest
    void equals_True_Self(final 일진 일진) {
        assertThat(일진).isEqualTo(일진);
    }

    // -------------------------------------------------------------------------------------------------------- hashCode
    @MethodSource({"parameters"})
    @ParameterizedTest
    void hashCode_NoException_(final 일진 일진) {
        assertThatNoException().isThrownBy(일진::hashCode);
    }

    // ------------------------------------------------------------------------------------------------------- compareTo
    @MethodSource({"parameters"})
    @ParameterizedTest
    void compareTo_True_Self(final 일진 일진) {
        assertThat(일진).isEqualByComparingTo(일진);
    }
}
