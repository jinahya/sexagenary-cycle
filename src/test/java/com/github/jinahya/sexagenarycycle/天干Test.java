package com.github.jinahya.sexagenarycycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
class 天干Test implements RollingEnumTest<天干> {

    static final List<String> VALID_NAMES = Arrays.asList("甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸");

    static List<String> validNames() {
        return validNames();
    }

    static Stream<Arguments> validNamesWithIndices() {
        return IntStream.range(0, VALID_NAMES.size()).mapToObj(i -> Arguments.of(VALID_NAMES.get(i), i));
    }

    // ----------------------------------------------------------------------------------------------------- REGEXP_NAME
    @DisplayName("REGEXP_NAME matches for every value's name")
    @Test
    void REGEXP_NAME_Match_EveryValueName() {
        final Pattern pattern = Pattern.compile(天干.REGEXP_NAME);
        for (final 天干 value : 天干.values()) {
            assertThat(pattern.matcher(value.name()).matches()).isTrue();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("valueOfName(name) returns valid value for known name")
    @MethodSource({"validNamesWithIndices"})
    @ParameterizedTest
    void valueOfName_ExpectedResult_NameIsKnown(final String name, final int index) {
        assertThat(天干.ofName(name)).isNotNull().isSameAs(天干.valueOf(name));
        assertThat(天干.ofName(name).ordinal()).isSameAs(index);
    }

    @DisplayName("valueOfName(name) throws IllegalArgumentException when name is unknown")
    @Test
    void valueOfName_IllegalArgumentException_NameIsUnknown() {
        assertThrows(IllegalArgumentException.class, () -> 天干.ofName(""));
    }

    // --------------------------------------------------------------------------------------------------------- get二十四方
    @Test
    void get二十四方_Null_五方Is中() {
        for (final 天干 value : 天干.values()) {
            if (value.get五方() != 五方.中) {
                continue;
            }
            assertThat(value.get二十四方()).isNull();
        }
    }

    @Test
    void get二十四方_NonNull_五方IsNot中() {
        for (final 天干 value : 天干.values()) {
            if (value.get五方() == 五方.中) {
                continue;
            }
            assertThat(value.get二十四方()).isNotNull();
        }
    }

    // ----------------------------------------------------------------------------------------------------------- get五方
    @Test
    void get五方_NonNull() {
        for (final 天干 value : 天干.values()) {
            assertThat(value.get五方()).isNotNull();
        }
    }

    // ----------------------------------------------------------------------------------------------------------- get五行
    @Test
    void get五行_NonNull() {
        for (final 天干 value : 天干.values()) {
            assertThat(value.get五行()).isNotNull();
        }
    }

    // ----------------------------------------------------------------------------------------------------------- get陰陽
    @Test
    void get陰陽_NonNull() {
        for (final 天干 value : 天干.values()) {
            assertThat(value.get陰陽()).isNotNull();
        }
    }
}