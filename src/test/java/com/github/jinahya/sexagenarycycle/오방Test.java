package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
class 오방Test {

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("all 五方 fields of all values are unique")
    @Test
    void 五方_Unique_() {
        final Set<五方> set = EnumSet.noneOf(五方.class);
        for (final 오방 value : 오방.values()) {
            assertThat(set.add(value.五方)).isTrue();
        }
    }

    // ----------------------------------------------------------------------------------------------------- valueOf(五方)
    @DisplayName("valueOf(五方) returns non null and unique for all 五方s")
    @Test
    void valueOf五方_NonNullUnique_ForAll五方s() {
        final Set<오방> set = EnumSet.noneOf(오방.class);
        for (final 五方 value : 五方.values()) {
            assertThat(오방.valueOf(value)).isNotNull().satisfies(v -> {
                assertThat(set.add(v)).isTrue();
            });
        }
    }
}
