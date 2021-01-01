package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
class 相生間色Test extends 五方間色Test<相生間色, 五行相生> {

    相生間色Test() {
        super(相生間色.class, 五行相生.class);
    }

    @Test
    void get五方正色Set_Expected_ForEachValue() {
        assertThat(相生間色.靘.get五方正色Set()).containsExactly(五方正色.靑, 五方正色.赤);
        assertThat(相生間色.纁.get五方正色Set()).containsExactly(五方正色.赤, 五方正色.黃);
        assertThat(相生間色.硅.get五方正色Set()).containsExactly(五方正色.黃, 五方正色.白);
        assertThat(相生間色.黻.get五方正色Set()).containsExactly(五方正色.白, 五方正色.黑);
        assertThat(相生間色.黯.get五方正色Set()).containsExactly(五方正色.黑, 五方正色.靑);
    }
}