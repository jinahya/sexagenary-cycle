package com.github.jinahya.sexagenarycycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
class 干支Test {

    /**
     * An unmodifiable list of all valid names.
     */
    static final List<String> ALL_NAMES = Arrays.asList(
            "甲子", "乙丑", "丙寅", "丁卯", "戊辰", "己巳", "庚午", "辛未", "壬申", "癸酉",
            "甲戌", "乙亥", "丙子", "丁丑", "戊寅", "己卯", "庚辰", "辛巳", "壬午", "癸未",
            "甲申", "乙酉", "丙戌", "丁亥", "戊子", "己丑", "庚寅", "辛卯", "壬辰", "癸巳",
            "甲午", "乙未", "丙申", "丁酉", "戊戌", "己亥", "庚子", "辛丑", "壬寅", "癸卯",
            "甲辰", "乙巳", "丙午", "丁未", "戊申", "己酉", "庚戌", "辛亥", "壬子", "癸丑",
            "甲寅", "乙卯", "丙辰", "丁巳", "戊午", "己未", "庚申", "辛酉", "壬戌", "癸亥"
    );

    static {
        assert ALL_NAMES.size() == 干支.VALUES.size();
    }

    /**
     * An unmodifiable list of all invalid names among all the possible combinations.
     */
    static final List<String> ALL_INVALID_NAMES = stream(天干.values())
            .map(Enum::name)
            .flatMap(stemName -> stream(地支.values()).map(Enum::name).map(branchName -> stemName + branchName))
            .filter(n -> !ALL_NAMES.contains(n))
            .collect(Collectors.toList());

    static {
        assert ALL_INVALID_NAMES.size() == 干支.VALUES.size(); // 60 == 120 - 60;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * An unmodifiable list of all valid Korean names.
     */
    static final List<String> ALL_KOREAN_NAMES = Arrays.asList(
            "갑자", "을축", "병인", "정묘", "무진", "기사", "경오", "신미", "임신", "계유",
            "갑술", "을해", "병자", "정축", "무인", "기묘", "경진", "신사", "임오", "계미",
            "갑신", "을유", "병술", "정해", "무자", "기축", "경인", "신묘", "임진", "계사",
            "갑오", "을미", "병신", "정유", "무술", "기해", "경자", "신축", "임인", "계묘",
            "갑진", "을사", "병오", "정미", "무신", "기유", "경술", "신해", "임자", "계축",
            "갑인", "을묘", "병진", "정사", "무오", "기미", "경신", "신유", "임술", "계해"
    );

    static {
        assert ALL_KOREAN_NAMES.size() == 干支.VALUES.size();
    }

    /**
     * An unmodifiable list of invalid Korean names among all the possible combinations.
     */
    static final List<String> ALL_INVALID_KOREAN_NAMES = stream(天干.values())
            .map(天干::koreanName)
            .flatMap(stemName -> stream(地支.values()).map(地支::koreanName).map(branchName -> stemName + branchName))
            .filter(n -> !ALL_KOREAN_NAMES.contains(n))
            .collect(Collectors.toList());

    static {
        assert ALL_INVALID_KOREAN_NAMES.size() == 干支.VALUES.size(); // 60 == 120 - 60;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void test_REGEXP_NAME() {
        final Pattern pattern = Pattern.compile(干支.REGEXP_NAME);
        for (final 干支 value : 干支.VALUES) {
            final String name = value.getName();
            assertThat(pattern.matcher(name)).satisfies(m -> {
                assertThat(m.matches()).isTrue();
                assertThat(m.group(干支.REGEXP_NAME_GROUP_STEM)).isNotNull().isEqualTo(value.getStem().name());
                assertThat(m.group(干支.REGEXP_NAME_GROUP_BRANCH)).isNotNull().isEqualTo(value.getBranch().name());
            });
        }
    }

    @Test
    void test_REGEXP_KOREAN_NAME() {
        final Pattern pattern = Pattern.compile(干支.REGEXP_KOREAN_NAME);
        for (final 干支 value : 干支.VALUES) {
            final String koreanName = value.getKoreanName();
            assertThat(pattern.matcher(koreanName)).satisfies(m -> {
                assertThat(m.matches()).isTrue();
                assertThat(m.group("stem")).isNotNull().isEqualTo(value.getStem().koreanName());
                assertThat(m.group("branch")).isNotNull().isEqualTo(value.getBranch().koreanName());
            });
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void test_VALUES() {
        assertThat(new HashSet<>(干支.VALUES).size()).isEqualTo(干支.VALUES.size());
        for (int i = 0; i < 干支.VALUES.size(); i++) {
            final 干支 value = 干支.VALUES.get(i);
            assertThat(ALL_NAMES.indexOf(value.getName())).isEqualTo(i);
            assertThat(ALL_KOREAN_NAMES.indexOf(value.getKoreanName())).isEqualTo(i);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void testValueOf() {
        for (final 干支 value : 干支.VALUES) {
            assertThat(干支.valueOf(value.get干(), value.get支())).isNotNull().isSameAs(value);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("valueOfName(nameWithInvalidNumberOfCodePoints) throws IllegalArgumentException")
    @ValueSource(strings = {"", "甲", "甲子甲"})
    @ParameterizedTest
    void testValueOfNameWithNameOfInvalidNumberOfCodepoints(final String nameWithInvalidNumberOfCodepoints) {
        assertThrows(IllegalArgumentException.class, () -> 干支.valueOfName(nameWithInvalidNumberOfCodepoints));
    }

    @Test
    void testValueOfName() {
        for (final 干支 value : 干支.VALUES) {
            assertThat(干支.valueOfName(value.getName())).isNotNull().isSameAs(value);
        }
    }

    @Test
    void testValueOfName_against_ALL_NAMES() {
        for (final String name : ALL_NAMES) {
            assertThat(干支.valueOfName(name)).isNotNull();
        }
    }

    @Test
    void testValueOfName_against_ALL_INVALID_NAMES() {
        for (final String invalidName : ALL_INVALID_NAMES) {
            assertThrows(IllegalArgumentException.class, () -> 干支.valueOfName(invalidName));
        }
    }

    // --------------------------------------------------------------------- valueOfKoreanName(Lj.l.String;)Lc.g.j.s.干支
    @DisplayName("valueOfKoreanName(koreanName) throws NullPointerException when koreanName is null")
    @Test
    void valueOfKoreanName_NullPointerException_KoreaNameIsNull() {
        assertThrows(NullPointerException.class, () -> 干支.valueOfKoreanName(null));
    }

    @DisplayName("valueOfKoreanName(koreanName) throws IllegalArgumentException when koreanName is unknown")
    @ValueSource(strings = {"", "갈", "갑자갑"})
    @ParameterizedTest
    void valueOfKoreanName_IllegalArgumentException_KoreaNameIsUnknown(final String unknownKoreanName) {
        assertThrows(IllegalArgumentException.class,
                     () -> 干支.valueOfKoreanName(unknownKoreanName));
    }

    @DisplayName("valueOfKoreanName(koreanName) returns non-null when koreanName is known")
    @Test
    void valueOfKoreanName_NonNull_KoreanNameIsKnown() {
        for (final String koreanName : ALL_KOREAN_NAMES) {
            assertThat(干支.valueOfKoreanName(koreanName)).isNotNull();
        }
    }

    @DisplayName("valueOfKoreanName(koreanName) throws IllegalArgumentException when koreanName is unknown")
    @Test
    void valueOfKoreanName_IllegalArgumentException_KoreanNameIsUnknown() {
        for (final String invalidKoreanName : ALL_INVALID_KOREAN_NAMES) {
            assertThrows(IllegalArgumentException.class, () -> 干支.valueOfKoreanName(invalidKoreanName));
        }
    }

    // ------------------------------------------------------------------------------------ toString()Ljava.lang.String;
    @DisplayName("toString() returns non-blank")
    @Test
    void toString_NonBlank() {
        for (final 干支 value : 干支.VALUES) {
            assertThat(value.toString()).isNotBlank();
        }
    }

    // ------------------------------------------------------------------------------------- equals(Ljava.lang.Object;)B
    @DisplayName("equals(o) returns true when o is same")
    @Test
    void equals_True_AgainstSelf() {
        for (final 干支 value : 干支.VALUES) {
            assertThat(value.equals(value)).isTrue();
        }
    }

    @DisplayName("equals(obj) returns false when obj is null")
    @Test
    void equals_False_ObjIsNull() {
        for (final 干支 value : 干支.VALUES) {
            assertThat(value.equals(null)).isFalse();
        }
    }

    @DisplayName("equals(obj) returns false when obj.class is same")
    @Test
    void equals_False_ObjClassIsNotSame() {
        for (final 干支 value : 干支.VALUES) {
            assertThat(value.equals(new Object())).isFalse();
        }
    }

    @DisplayName("equals(obj) returns false when obj is not same")
    @Test
    void equals_False_ForEachOther() {
        for (final 干支 value : 干支.VALUES) {
            assertThat(value).satisfies(v -> {
                干支.VALUES.forEach(obj -> {
                    if (obj != v) {
                        assertThat(v).isNotEqualTo(obj);
                        assertThat(obj).isNotEqualTo(v);
                    }
                });
            });
        }
    }

    // ----------------------------------------------------------------------------------------------------- hashCode()I
    @Test
    void hashCode_ResultValid() {
        for (final 干支 value : 干支.VALUES) {
            assertThat(value.hashCode()).satisfies(v -> {
            });
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("getName() returns valid value")
    @Test
    void getName_Valid() {
        for (final 干支 value : 干支.VALUES) {
            final String name = value.getName();
            assertThat(name).isNotNull().hasSize(2);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("getKoreanName() returns valid value")
    @Test
    void getKoreanName_Valid() {
        for (final 干支 value : 干支.VALUES) {
            final String koreanName = value.getKoreanName();
            assertThat(koreanName).isNotNull().hasSize(2);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("getStem() returns non-null")
    @Test
    void getStem_NonNull() {
        for (final 干支 value : 干支.VALUES) {
            assertThat(value.getStem()).isNotNull();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("getBranch() returns non-null")
    @Test
    void getBranch_NonNull() {
        for (final 干支 value : 干支.VALUES) {
            assertThat(value.getBranch()).isNotNull();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void getPrevious_Valid() {
        for (final 干支 value : 干支.VALUES) {
            assertThat(value.getPrevious()).isNotNull().satisfies(p -> {
                assertThat(p).isNotEqualTo(value);
                assertThat(p.getNext()).isNotNull().isEqualTo(value);
                assertThat(p.getNext()).isNotNull().isSameAs(value);
            });
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void getNext_Valid() {
        for (final 干支 value : 干支.VALUES) {
            assertThat(value.getNext()).isNotNull().satisfies(n -> {
                assertThat(n).isNotEqualTo(value);
                assertThat(n.getPrevious()).isNotNull().isEqualTo(value);
                assertThat(n.getPrevious()).isNotNull().isSameAs(value);
            });
        }
    }
}