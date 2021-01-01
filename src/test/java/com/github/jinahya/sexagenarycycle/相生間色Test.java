package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.EnumSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
class 相生間色Test extends 五方間色Test<相生間色, 五行相生> {

    相生間色Test() {
        super(相生間色.class, 五行相生.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @EnumSource(五行相生.class)
    @ParameterizedTest
    void valueOf五行相生_NonNull_ForEach五行相生(final 五行相生 五行相生) {
        assertThat(相生間色.valueOf(五行相生)).isNotNull();
    }

    @Test
    void valueOf五行相生_NonNullExpected_ForEach五行相生() {
        final Set<相生間色> set = EnumSet.noneOf(相生間色.class);
        for (final 五行相生 五行相生 : 五行相生.values()) {
            final 相生間色 value = 相生間色.valueOf(五行相生);
            assertThat(set.add(value)).isTrue();
        }
        assertThat(set).isEqualTo(EnumSet.allOf(相生間色.class));
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    void get五方正色Set_Expected_ForEachValue() {
        assertThat(相生間色.靘.get五方正色Set()).containsExactly(五方正色.靑, 五方正色.赤);
        assertThat(相生間色.纁.get五方正色Set()).containsExactly(五方正色.赤, 五方正色.黃);
        assertThat(相生間色.硅.get五方正色Set()).containsExactly(五方正色.黃, 五方正色.白);
        assertThat(相生間色.黻.get五方正色Set()).containsExactly(五方正色.白, 五方正色.黑);
        assertThat(相生間色.黯.get五方正色Set()).containsExactly(五方正色.黑, 五方正色.靑);
    }
}