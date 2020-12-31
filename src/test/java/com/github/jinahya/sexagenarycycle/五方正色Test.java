package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
class 五方正色Test {

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void valueOf五行_NonNullUnique_ForEach五行s() {
        final Set<五方正色> set = EnumSet.noneOf(五方正色.class);
        for (final 五行 value : 五行.values()) {
            assertThat(五方正色.valueOf(value)).isNotNull().satisfies(v -> {
                assertThat(set.add(v)).isTrue();
            });
        }
        assertThat(set).isEqualTo(EnumSet.allOf(五方正色.class));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void valueOf五方_NonNullUnique_ForEach五方s() {
        final Set<五方正色> set = EnumSet.noneOf(五方正色.class);
        for (final 五方 value : 五方.values()) {
            assertThat(五方正色.valueOf(value)).isNotNull().satisfies(v -> {
                assertThat(set.add(v)).isTrue();
            });
        }
        assertThat(set).isEqualTo(EnumSet.allOf(五方正色.class));
    }
}