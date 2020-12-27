package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static com.github.jinahya.sexagenarycycle.時刻Assert.assertThat;

class 地支時刻Test {

    @Test
    void 時刻time_Expected() {
        assertThat(地支時刻.時刻Of(地支.子)).hasTime(LocalTime.of(23, 0));
        assertThat(地支時刻.時刻Of(地支.丑)).hasTime(LocalTime.of(1, 0));
        assertThat(地支時刻.時刻Of(地支.寅)).hasTime(LocalTime.of(3, 0));
        assertThat(地支時刻.時刻Of(地支.卯)).hasTime(LocalTime.of(5, 0));
        assertThat(地支時刻.時刻Of(地支.辰)).hasTime(LocalTime.of(7, 0));
        assertThat(地支時刻.時刻Of(地支.巳)).hasTime(LocalTime.of(9, 0));
        assertThat(地支時刻.時刻Of(地支.午)).hasTime(LocalTime.of(11, 0));
        assertThat(地支時刻.時刻Of(地支.未)).hasTime(LocalTime.of(13, 0));
        assertThat(地支時刻.時刻Of(地支.申)).hasTime(LocalTime.of(15, 0));
        assertThat(地支時刻.時刻Of(地支.酉)).hasTime(LocalTime.of(17, 0));
        assertThat(地支時刻.時刻Of(地支.戌)).hasTime(LocalTime.of(19, 0));
        assertThat(地支時刻.時刻Of(地支.亥)).hasTime(LocalTime.of(21, 0));
    }
}