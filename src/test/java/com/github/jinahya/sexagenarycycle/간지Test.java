package com.github.jinahya.sexagenarycycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
class 간지Test implements RollingTest<간지> {

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * An unmodifiable list of all valid names.
     */
    static final List<String> VALID_NAMES = Arrays.asList(
            "갑자", "을축", "병인", "정묘", "무진", "기사", "경오", "신미", "임신", "계유",
            "갑술", "을해", "병자", "정축", "무인", "기묘", "경진", "신사", "임오", "계미",
            "갑신", "을유", "병술", "정해", "무자", "기축", "경인", "신묘", "임진", "계사",
            "갑오", "을미", "병신", "정유", "무술", "기해", "경자", "신축", "임인", "계묘",
            "갑진", "을사", "병오", "정미", "무신", "기유", "경술", "신해", "임자", "계축",
            "갑인", "을묘", "병진", "정사", "무오", "기미", "경신", "신유", "임술", "계해"
    );

    static {
        assert VALID_NAMES.size() == 간지.VALUES.size();
    }

    static Stream<String> validNames() {
        return VALID_NAMES.stream();
    }

    /**
     * An unmodifiable list of invalid names among all the possible combinations.
     */
    static final List<String> INVALID_NAMES = Arrays.stream(천간.values())
            .map(Enum::name)
            .flatMap(s -> Arrays.stream(지지.values()).map(지지::name).map(b -> s + b))
            .filter(n -> !VALID_NAMES.contains(n))
            .collect(Collectors.toList());

    static {
        assert INVALID_NAMES.size() == 간지.VALUES.size(); // 60 == 120 - 60;
    }

    static Stream<String> invalidNames() {
        return INVALID_NAMES.stream();
    }

    // ----------------------------------------------------------------------------------------------------- REGEXP_NAME
    @Test
    void REGEXP_NAME_Match() {
        final Pattern pattern = Pattern.compile(간지.REGEXP_NAME);
        for (final 간지 value : 간지.VALUES) {
            final String name = value.name();
            assertThat(pattern.matcher(name)).satisfies(m -> {
                assertThat(m.matches()).isTrue();
            });
        }
    }

    // ---------------------------------------------------------------------------------------------------------- VALUES
    @Test
    void VALUES_() {
        assertThat(new HashSet<>(간지.VALUES).size()).isEqualTo(간지.VALUES.size());
        for (int i = 0; i < 간지.VALUES.size(); i++) {
            final 간지 value = 간지.VALUES.get(i);
            assertThat(VALID_NAMES.indexOf(value.name())).isEqualTo(i);
        }
    }

    // ----------------------------------------------------------------------------------------------------- valueOf(干支)
    @Test
    void valueOf干支_NonNullUnique() {
        final Set<간지> set = new HashSet<>();
        for (final 干支 value : 干支.VALUES) {
            assertThat(간지.valueOf(value)).isNotNull().satisfies(v -> {
                assertThat(set.add(v)).isTrue();
            });
        }
    }

    // ----------------------------------------------------------------------------------------------------- valueOfName
    @DisplayName("valueOfName(name) throws IllegalArgumentException when name is unknown")
    @ValueSource(strings = {"", "갑", "갑자갑"})
    @ParameterizedTest
    void valueOfName_IllegalArgumentException_NameIsUnknown(final String unknownName) {
        assertThrows(IllegalArgumentException.class, () -> 간지.valueOfName(unknownName));
    }

    @DisplayName("valueOfName(name) returns non-null when name is valid")
    @MethodSource({"validNames"})
    @ParameterizedTest
    void valueOfName_NonNull_NameIsKnown(final String validName) {
        assertThat(간지.valueOfName(validName)).isNotNull();
    }

    @DisplayName("valueOfName(name) throws IllegalArgumentException when name is invalid")
    @MethodSource({"invalidNames"})
    @ParameterizedTest
    void valueOfName_IllegalArgumentException_NameIsInvalid(final String invalidName) {
        assertThrows(IllegalArgumentException.class, () -> 간지.valueOfName(invalidName));
    }

    @Test
    void valueOfName_NonNullSame_OwnName() {
        for (final 간지 value : 간지.VALUES) {
            assertThat(간지.valueOfName(value.name())).isNotNull().isSameAs(value);
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
    @DisplayName("equals(obj) returns false when obj is null")
    @Test
    void equals_False_ObjIsNull() {
        for (final 간지 value : 간지.VALUES) {
            assertThat(value.equals(null)).isFalse();
            assertThat(value).isNotEqualTo(null);
        }
    }

    @DisplayName("equals(obj) returns true when obj is same")
    @Test
    void equals_True_AgainstSelf() {
        for (final 간지 value : 간지.VALUES) {
            assertThat(value.equals(value)).isTrue();
            assertThat(value).isEqualTo(value);
        }
    }

    @DisplayName("equals(obj) returns false when obj.class is not same")
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
    @DisplayName("hashCode() throws no exception")
    @Test
    void hashCode_NoExceptionThrown_() {
        for (final 간지 value : 간지.VALUES) {
            assertThatNoException().isThrownBy(value::hashCode);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("name() returns a non-null and two-characters long value")
    @Test
    void name_NonNullAndHasSize2() {
        for (final 간지 value : 간지.VALUES) {
            assertThat(value.name()).isNotNull().hasSize(2);
        }
    }

    // ------------------------------------------------------------------------------------------- getPrevious / getNext
    @Override
    public 간지[] values() {
        return 간지.VALUES.toArray(new 간지[0]);
    }
}