package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
class 生肖Test {

    @DisplayName("valueOf(地支) returns non-null and unique for each 地支")
    @Test
    void valueOf地支_NonNullUnique_ForEach地支() {
        final Set<生肖> set = EnumSet.noneOf(生肖.class);
        for (final 地支 地支 : 地支.values()) {
            assertThat(生肖.valueOf(地支)).isNotNull().satisfies(v -> {
                assertThat(set.add(v)).isTrue();
            });
        }
        assertThat(set).isEqualTo(EnumSet.allOf(生肖.class));
    }
}