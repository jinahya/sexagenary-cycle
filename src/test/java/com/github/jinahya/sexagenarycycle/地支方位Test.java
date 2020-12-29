package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Test;

import static com.github.jinahya.sexagenarycycle.二十四方Assert.assertThat方位Of;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
class 地支方位Test {

    @Test
    void 方位Of_NoNull_Expected() {
        assertThat方位Of(地支.子).isNotNull().hasDirection(0);
        assertThat方位Of(地支.丑).isNotNull().hasDirection(30);
        assertThat方位Of(地支.寅).isNotNull().hasDirection(60);
        assertThat方位Of(地支.卯).isNotNull().hasDirection(90);
        assertThat方位Of(地支.辰).isNotNull().hasDirection(120);
        assertThat方位Of(地支.巳).isNotNull().hasDirection(150);
        assertThat方位Of(地支.午).isNotNull().hasDirection(180);
        assertThat方位Of(地支.未).isNotNull().hasDirection(210);
        assertThat方位Of(地支.申).isNotNull().hasDirection(240);
        assertThat方位Of(地支.酉).isNotNull().hasDirection(270);
        assertThat方位Of(地支.戌).isNotNull().hasDirection(300);
        assertThat方位Of(地支.亥).isNotNull().hasDirection(330);
    }
}
