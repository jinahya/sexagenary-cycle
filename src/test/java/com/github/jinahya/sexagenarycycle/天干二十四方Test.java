package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Test;

import static com.github.jinahya.sexagenarycycle.二十四方Assert.assertThatValueOf;

class 天干二十四方Test {

    @Test
    void valueOf_Expected() {
        assertThatValueOf(天干.甲).hasDirection(75);
        assertThatValueOf(天干.乙).hasDirection(105);
        assertThatValueOf(天干.丙).hasDirection(165);
        assertThatValueOf(天干.丁).hasDirection(195);
        assertThatValueOf(天干.戊).isNull();
        assertThatValueOf(天干.己).isNull();
        assertThatValueOf(天干.庚).hasDirection(255);
        assertThatValueOf(天干.辛).hasDirection(285);
        assertThatValueOf(天干.壬).hasDirection(345);
        assertThatValueOf(天干.癸).hasDirection(15);
    }
}
