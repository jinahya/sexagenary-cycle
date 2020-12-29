package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
class 天干五行Test {

    @DisplayName("五行Of(天干) returns non-null and expected")
    @Test
    void 五行Of天干_NonNullExpected() {
        assertThat(天干五行.五行Of(天干.甲)).isNotNull().isSameAs(五行.木);
        assertThat(天干五行.五行Of(天干.乙)).isNotNull().isSameAs(五行.木);
        assertThat(天干五行.五行Of(天干.丙)).isNotNull().isSameAs(五行.火);
        assertThat(天干五行.五行Of(天干.丁)).isNotNull().isSameAs(五行.火);
        assertThat(天干五行.五行Of(天干.戊)).isNotNull().isSameAs(五行.土);
        assertThat(天干五行.五行Of(天干.己)).isNotNull().isSameAs(五行.土);
        assertThat(天干五行.五行Of(天干.庚)).isNotNull().isSameAs(五行.金);
        assertThat(天干五行.五行Of(天干.辛)).isNotNull().isSameAs(五行.金);
        assertThat(天干五行.五行Of(天干.壬)).isNotNull().isSameAs(五行.水);
        assertThat(天干五行.五行Of(天干.癸)).isNotNull().isSameAs(五行.水);
    }
}