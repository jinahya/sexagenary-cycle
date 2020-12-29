package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.EnumSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
class 오행Test {

    @DisplayName("ordinal() is same as its 五行's ordinal()")
    @EnumSource(오행.class)
    @ParameterizedTest
    void ordinal_SameAsThatOf五行_ForEachValue(final 오행 value) {
        assertThat(value.ordinal()).isEqualTo(value.五行.ordinal());
    }

    // ----------------------------------------------------------------------------------------------------- valueOf(五行)
    @DisplayName("valueOf(五行) returns non null and unique for all 五行s")
    @Test
    void valueOf五行_NonNullUnique_ForAll五行s() {
        final Set<오행> set = EnumSet.noneOf(오행.class);
        for (final 五行 value : 五行.values()) {
            assertThat(오행.valueOf(value)).isNotNull().satisfies(v -> {
                assertThat(set.add(v)).isTrue();
            });
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("all 五行 fields of all values are unique")
    @Test
    void 五行_NonNullUnique_() {
        final Set<五行> set = EnumSet.noneOf(五行.class);
        for (final 오행 value : 오행.values()) {
            assertThat(value.五行).isNotNull().satisfies(v -> {
                assertThat(set.add(v)).isTrue();
            });
        }
    }
}
