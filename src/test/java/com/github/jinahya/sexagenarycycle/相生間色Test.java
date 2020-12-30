package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static java.util.Arrays.stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class 相生間色Test extends 五方間色Test<相生間色> {

    相生間色Test() {
        super(相生間色.class);
    }

    @EnumSource(五行相生.class)
    @ParameterizedTest
    void valueOf_NonNull_ForEach五行相生(final 五行相生 五行相生) {
        assertThat(相生間色.valueOf(五行相生)).isNotNull();
    }

    @Test
    void valueOf_AllValues_ForAll五行相生() {
        assertThat(stream(五行相生.values()).map(相生間色::valueOf).toArray(相生間色[]::new)).isEqualTo(相生間色.values());
    }
}