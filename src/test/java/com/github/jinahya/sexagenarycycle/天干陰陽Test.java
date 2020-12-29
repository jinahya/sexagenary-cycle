package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
class 天干陰陽Test {

    @DisplayName("陰陽Of(天干) returns non-null and expected")
    @Test
    void 陰陽Of天干_NonNullExpected() {
        assertThat(天干陰陽.陰陽Of(天干.甲)).isNotNull().isSameAs(陰陽.陽);
        assertThat(天干陰陽.陰陽Of(天干.乙)).isNotNull().isSameAs(陰陽.陰);
        assertThat(天干陰陽.陰陽Of(天干.丙)).isNotNull().isSameAs(陰陽.陽);
        assertThat(天干陰陽.陰陽Of(天干.丁)).isNotNull().isSameAs(陰陽.陰);
        assertThat(天干陰陽.陰陽Of(天干.戊)).isNotNull().isSameAs(陰陽.陽);
        assertThat(天干陰陽.陰陽Of(天干.己)).isNotNull().isSameAs(陰陽.陰);
        assertThat(天干陰陽.陰陽Of(天干.庚)).isNotNull().isSameAs(陰陽.陽);
        assertThat(天干陰陽.陰陽Of(天干.辛)).isNotNull().isSameAs(陰陽.陰);
        assertThat(天干陰陽.陰陽Of(天干.壬)).isNotNull().isSameAs(陰陽.陽);
        assertThat(天干陰陽.陰陽Of(天干.癸)).isNotNull().isSameAs(陰陽.陰);
    }
}