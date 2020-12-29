package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
class 地支月份Test {

    @Test
    void valueOf_Expected() {
        final List<地支> values = Arrays.asList(地支.values());
        final List<Month> months = new ArrayList<>(Arrays.asList(Month.values()));
        for (int i = 0; i < 10; i++) {
            months.add(months.remove(0));
        }
        assertThat(months.get(0)).isSameAs(Month.NOVEMBER);
        for (int i = 0; i < values.size(); i++) {
            assertThat(地支月份.valueOf(values.get(i))).isSameAs(months.get(i));
        }
    }
}