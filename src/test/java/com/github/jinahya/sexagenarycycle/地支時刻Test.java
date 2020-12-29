package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static com.github.jinahya.sexagenarycycle.時刻Assert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
class 地支時刻Test {

    @Test
    void valueOf地支_NonNullUnique() {
        final Set<地支時刻> set = EnumSet.noneOf(地支時刻.class);
        for (final 地支 地支 : 地支.values()) {
            assertThat(地支時刻.valueOf(地支)).isNotNull().satisfies(v -> {
                assertThat(v.ordinal()).isEqualTo(地支.ordinal());
                assertThat(set.add(v)).isTrue();
                assertThat(v.name()).isEqualTo(地支.name() + "時");
            });
        }
    }

    @Test
    void 時刻Of地支_HasExpectedHour() {
        assertThat(地支時刻.時刻Of(地支.子)).hasTimeOfHour(23);
        assertThat(地支時刻.時刻Of(地支.丑)).hasTimeOfHour(1);
        assertThat(地支時刻.時刻Of(地支.寅)).hasTimeOfHour(3);
        assertThat(地支時刻.時刻Of(地支.卯)).hasTimeOfHour(5);
        assertThat(地支時刻.時刻Of(地支.辰)).hasTimeOfHour(7);
        assertThat(地支時刻.時刻Of(地支.巳)).hasTimeOfHour(9);
        assertThat(地支時刻.時刻Of(地支.午)).hasTimeOfHour(11);
        assertThat(地支時刻.時刻Of(地支.未)).hasTimeOfHour(13);
        assertThat(地支時刻.時刻Of(地支.申)).hasTimeOfHour(15);
        assertThat(地支時刻.時刻Of(地支.酉)).hasTimeOfHour(17);
        assertThat(地支時刻.時刻Of(地支.戌)).hasTimeOfHour(19);
        assertThat(地支時刻.時刻Of(地支.亥)).hasTimeOfHour(21);
    }
}