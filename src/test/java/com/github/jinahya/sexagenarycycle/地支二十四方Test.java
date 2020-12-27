package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Test;

import static com.github.jinahya.sexagenarycycle.二十四方Assert.assertThatValueOf;

class 地支二十四方Test {

    @Test
    void valueOf_Expected() {
        assertThatValueOf(地支.子).hasDirection(0);
        assertThatValueOf(地支.丑).hasDirection(30);
        assertThatValueOf(地支.寅).hasDirection(60);
        assertThatValueOf(地支.卯).hasDirection(90);
        assertThatValueOf(地支.辰).hasDirection(120);
        assertThatValueOf(地支.巳).hasDirection(150);
        assertThatValueOf(地支.午).hasDirection(180);
        assertThatValueOf(地支.未).hasDirection(210);
        assertThatValueOf(地支.申).hasDirection(240);
        assertThatValueOf(地支.酉).hasDirection(270);
        assertThatValueOf(地支.戌).hasDirection(300);
        assertThatValueOf(地支.亥).hasDirection(330);
    }
}
