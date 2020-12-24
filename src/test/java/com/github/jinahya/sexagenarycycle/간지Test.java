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
class 간지Test {

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * An unmodifiable list of all valid names.
     */
    static final List<String> ALL_NAMES = Arrays.asList(
            "갑자", "을축", "병인", "정묘", "무진", "기사", "경오", "신미", "임신", "계유",
            "갑술", "을해", "병자", "정축", "무인", "기묘", "경진", "신사", "임오", "계미",
            "갑신", "을유", "병술", "정해", "무자", "기축", "경인", "신묘", "임진", "계사",
            "갑오", "을미", "병신", "정유", "무술", "기해", "경자", "신축", "임인", "계묘",
            "갑진", "을사", "병오", "정미", "무신", "기유", "경술", "신해", "임자", "계축",
            "갑인", "을묘", "병진", "정사", "무오", "기미", "경신", "신유", "임술", "계해"
    );

    static {
        assert ALL_NAMES.size() == 간지.VALUES.size();
    }

    /**
     * An unmodifiable list of invalid names among all the possible combinations.
     */
    static final List<String> ALL_INVALID_NAMES = stream(천간.values())
            .map(Enum::name)
            .flatMap(stemName -> stream(지지.values()).map(지지::name).map(branchName -> stemName + branchName))
            .filter(n -> !ALL_NAMES.contains(n))
            .collect(Collectors.toList());

    static {
        assert ALL_INVALID_NAMES.size() == 간지.VALUES.size(); // 60 == 120 - 60;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void test_REGEXP_NAME() {
        final Pattern pattern = Pattern.compile(간지.REGEXP_NAME);
        for (final 간지 value : 간지.VALUES) {
            final String name = value.getName();
            assertThat(pattern.matcher(name)).satisfies(m -> {
                assertThat(m.matches()).isTrue();
                assertThat(m.group(干支.REGEXP_NAME_GROUP_STEM)).isNotNull().isEqualTo(value.get간().name());
                assertThat(m.group(干支.REGEXP_NAME_GROUP_BRANCH)).isNotNull().isEqualTo(value.get지().name());
            });
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void test_VALUES() {
        assertThat(new HashSet<>(간지.VALUES).size()).isEqualTo(간지.VALUES.size());
        for (int i = 0; i < 간지.VALUES.size(); i++) {
            final 간지 value = 간지.VALUES.get(i);
            assertThat(ALL_NAMES.indexOf(value.getName())).isEqualTo(i);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void testValueOf() {
        for (final 간지 value : 간지.VALUES) {
            assertThat(간지.valueOf(value.get간(), value.get지())).isNotNull().isSameAs(value);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("valueOfName(nameWithInvalidNumberOfCodePoints) throws IllegalArgumentException")
    @ValueSource(strings = {"", "갑", "갑자갑"})
    @ParameterizedTest
    void testValueOfNameWithNameOfInvalidNumberOfCodepoints(final String nameWithInvalidNumberOfCodepoints) {
        assertThrows(IllegalArgumentException.class, () -> 간지.valueOfName(nameWithInvalidNumberOfCodepoints));
    }

    @Test
    void testValueOfName() {
        for (final 간지 value : 간지.VALUES) {
            assertThat(간지.valueOfName(value.getName())).isNotNull().isSameAs(value);
        }
    }

    @Test
    void testValueOfName_against_ALL_NAMES() {
        for (final String name : ALL_NAMES) {
            assertThat(간지.valueOfName(name)).isNotNull();
        }
    }

    @Test
    void testValueOfName_against_ALL_INVALID_NAMES() {
        for (final String invalidName : ALL_INVALID_NAMES) {
            assertThrows(IllegalArgumentException.class, () -> 간지.valueOfName(invalidName));
        }
    }

    // ------------------------------------------------------------------------------------ toString()Ljava.lang.String;
    @DisplayName("toString() returns non-blank")
    @Test
    void toString_NonBlank() {
        for (final 간지 value : 간지.VALUES) {
            assertThat(value.toString()).isNotBlank();
        }
    }

    // ------------------------------------------------------------------------------------- equals(Ljava.lang.Object;)B
    @DisplayName("equals(o) returns true when o is same")
    @Test
    void equals_True_AgainstSelf() {
        for (final 간지 value : 간지.VALUES) {
            assertThat(value.equals(value)).isTrue();
        }
    }

    @DisplayName("equals(obj) returns false when obj is null")
    @Test
    void equals_False_ObjIsNull() {
        for (final 간지 value : 간지.VALUES) {
            assertThat(value.equals(null)).isFalse();
        }
    }

    @DisplayName("equals(obj) returns false when obj.class is same")
    @Test
    void equals_False_ObjClassIsNotSame() {
        for (final 간지 value : 간지.VALUES) {
            assertThat(value.equals(new Object())).isFalse();
        }
    }

    @DisplayName("equals(obj) returns false when obj is not same")
    @Test
    void equals_False_ForEachOther() {
        for (final 간지 value : 간지.VALUES) {
            assertThat(value).satisfies(v -> {
                간지.VALUES.forEach(obj -> {
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
        for (final 간지 value : 간지.VALUES) {
            assertThat(value.hashCode()).satisfies(v -> {
            });
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("getName() returns valid value")
    @Test
    void getName_Valid() {
        for (final 간지 value : 간지.VALUES) {
            final String name = value.getName();
            assertThat(name).isNotNull().hasSize(2);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void getPrevious_Valid() {
        for (final 간지 value : 간지.VALUES) {
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
        for (final 간지 value : 간지.VALUES) {
            assertThat(value.getNext()).isNotNull().satisfies(n -> {
                assertThat(n).isNotEqualTo(value);
                assertThat(n.getPrevious()).isNotNull().isEqualTo(value);
                assertThat(n.getPrevious()).isNotNull().isSameAs(value);
            });
        }
    }
}