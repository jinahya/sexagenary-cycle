package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Test;

import static com.github.jinahya.sexagenarycycle.二十四方Assert.assertThat方位Of;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
class 天干方位Test {

    @Test
    void 方位Of天干_HasExpectedExpected() {
        assertThat方位Of(天干.甲).hasDirection(75);
        assertThat方位Of(天干.乙).hasDirection(105);
        assertThat方位Of(天干.丙).hasDirection(165);
        assertThat方位Of(天干.丁).hasDirection(195);
        assertThat方位Of(天干.戊).isNull();
        assertThat方位Of(天干.己).isNull();
        assertThat方位Of(天干.庚).hasDirection(255);
        assertThat方位Of(天干.辛).hasDirection(285);
        assertThat方位Of(天干.壬).hasDirection(345);
        assertThat方位Of(天干.癸).hasDirection(15);
    }
}
