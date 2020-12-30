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

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
@Slf4j
class 天干Test implements RollingEnumTest<天干> {

    static final List<String> VALID_NAMES = Arrays.asList("甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸");

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
        assertThat(天干.valueOfName(name)).isNotNull().isSameAs(天干.valueOf(name));
        assertThat(天干.valueOfName(name).ordinal()).isSameAs(index);
    }

    @DisplayName("valueOfName(name) throws IllegalArgumentException when name is unknown")
    @Test
    void valueOfName_IllegalArgumentException_NameIsUnknown() {
        assertThrows(IllegalArgumentException.class, () -> 天干.valueOfName(""));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("五方 is non-null and expected")
    @Test
    void 五方_NonNullExpected() {
        assertThat(天干.甲.五方).isNotNull().isSameAs(五方.東);
        assertThat(天干.乙.五方).isNotNull().isSameAs(五方.東);
        assertThat(天干.丙.五方).isNotNull().isSameAs(五方.南);
        assertThat(天干.丁.五方).isNotNull().isSameAs(五方.南);
        assertThat(天干.戊.五方).isNotNull().isSameAs(五方.中);
        assertThat(天干.己.五方).isNotNull().isSameAs(五方.中);
        assertThat(天干.庚.五方).isNotNull().isSameAs(五方.西);
        assertThat(天干.辛.五方).isNotNull().isSameAs(五方.西);
        assertThat(天干.壬.五方).isNotNull().isSameAs(五方.北);
        assertThat(天干.癸.五方).isNotNull().isSameAs(五方.北);
    }

    @Test
    void 方位Of天干_HasExpectedExpected() {
        assertThat(天干.甲.二十四方.direction).isEqualTo(75);
        assertThat(天干.乙.二十四方.direction).isEqualTo(105);
        assertThat(天干.丙.二十四方.direction).isEqualTo(165);
        assertThat(天干.丁.二十四方.direction).isEqualTo(195);
        assertThat(天干.戊.二十四方).isNull();
        assertThat(天干.己.二十四方).isNull();
        assertThat(天干.庚.二十四方.direction).isEqualTo(255);
        assertThat(天干.辛.二十四方.direction).isEqualTo(285);
        assertThat(天干.壬.二十四方.direction).isEqualTo(345);
        assertThat(天干.癸.二十四方.direction).isEqualTo(15);
    }

    @DisplayName("五行 is non-null and expected")
    @Test
    void 五行_NonNullExpected() {
        assertThat(天干.甲.五行).isNotNull().isSameAs(五行.木);
        assertThat(天干.乙.五行).isNotNull().isSameAs(五行.木);
        assertThat(天干.丙.五行).isNotNull().isSameAs(五行.火);
        assertThat(天干.丁.五行).isNotNull().isSameAs(五行.火);
        assertThat(天干.戊.五行).isNotNull().isSameAs(五行.土);
        assertThat(天干.己.五行).isNotNull().isSameAs(五行.土);
        assertThat(天干.庚.五行).isNotNull().isSameAs(五行.金);
        assertThat(天干.辛.五行).isNotNull().isSameAs(五行.金);
        assertThat(天干.壬.五行).isNotNull().isSameAs(五行.水);
        assertThat(天干.癸.五行).isNotNull().isSameAs(五行.水);
    }

    @DisplayName("陰陽 is non-null and expected")
    @Test
    void 陰陽Of天干_NonNullExpected() {
        assertThat(天干.甲.陰陽).isNotNull().isSameAs(陰陽.陽);
        assertThat(天干.乙.陰陽).isNotNull().isSameAs(陰陽.陰);
        assertThat(天干.丙.陰陽).isNotNull().isSameAs(陰陽.陽);
        assertThat(天干.丁.陰陽).isNotNull().isSameAs(陰陽.陰);
        assertThat(天干.戊.陰陽).isNotNull().isSameAs(陰陽.陽);
        assertThat(天干.己.陰陽).isNotNull().isSameAs(陰陽.陰);
        assertThat(天干.庚.陰陽).isNotNull().isSameAs(陰陽.陽);
        assertThat(天干.辛.陰陽).isNotNull().isSameAs(陰陽.陰);
        assertThat(天干.壬.陰陽).isNotNull().isSameAs(陰陽.陽);
        assertThat(天干.癸.陰陽).isNotNull().isSameAs(陰陽.陰);
    }
}