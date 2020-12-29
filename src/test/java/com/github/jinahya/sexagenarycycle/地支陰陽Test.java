package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
class 地支陰陽Test {

    @Test
    void valueOf_Expected_() {
        assertThat(地支陰陽.valueOf(地支.子)).isSameAs(陰陽.陽);
        assertThat(地支陰陽.valueOf(地支.丑)).isSameAs(陰陽.陰);
        assertThat(地支陰陽.valueOf(地支.寅)).isSameAs(陰陽.陽);
        assertThat(地支陰陽.valueOf(地支.卯)).isSameAs(陰陽.陰);
        assertThat(地支陰陽.valueOf(地支.辰)).isSameAs(陰陽.陽);
        assertThat(地支陰陽.valueOf(地支.巳)).isSameAs(陰陽.陰);
        assertThat(地支陰陽.valueOf(地支.午)).isSameAs(陰陽.陽);
        assertThat(地支陰陽.valueOf(地支.未)).isSameAs(陰陽.陰);
        assertThat(地支陰陽.valueOf(地支.申)).isSameAs(陰陽.陽);
        assertThat(地支陰陽.valueOf(地支.酉)).isSameAs(陰陽.陰);
        assertThat(地支陰陽.valueOf(地支.戌)).isSameAs(陰陽.陽);
        assertThat(地支陰陽.valueOf(地支.亥)).isSameAs(陰陽.陰);
    }
}