package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
class 地支五行Test {

    @DisplayName("五行Of(地支) returns non-null for each 地支")
    @EnumSource(地支.class)
    @ParameterizedTest
    void 五行Of地支_NonNull_ForEach地支(final 地支 地支) {
        assertThat(地支五行.五行Of(地支)).isNotNull();
    }
}