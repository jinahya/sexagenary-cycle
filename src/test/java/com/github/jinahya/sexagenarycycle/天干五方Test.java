package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
class 天干五方Test {

    @Test
    void 五方Of_NonNullExpected() {
        assertThat(天干五方.五方Of(天干.甲)).isNotNull().isSameAs(五方.東);
        assertThat(天干五方.五方Of(天干.乙)).isNotNull().isSameAs(五方.東);
        assertThat(天干五方.五方Of(天干.丙)).isNotNull().isSameAs(五方.南);
        assertThat(天干五方.五方Of(天干.丁)).isNotNull().isSameAs(五方.南);
        assertThat(天干五方.五方Of(天干.戊)).isNotNull().isSameAs(五方.中);
        assertThat(天干五方.五方Of(天干.己)).isNotNull().isSameAs(五方.中);
        assertThat(天干五方.五方Of(天干.庚)).isNotNull().isSameAs(五方.西);
        assertThat(天干五方.五方Of(天干.辛)).isNotNull().isSameAs(五方.西);
        assertThat(天干五方.五方Of(天干.壬)).isNotNull().isSameAs(五方.北);
        assertThat(天干五方.五方Of(天干.癸)).isNotNull().isSameAs(五方.北);
    }
}