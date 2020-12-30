package com.github.jinahya.sexagenarycycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
@Slf4j
class 천간Test {

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("REGEXP_NAME matches for each name")
    @Test
    void REGEXP_NAME_Match_ForEachName() {
        final Pattern pattern = Pattern.compile(천간.REGEXP_NAME);
        for (final 천간 value : 천간.values()) {
            assertThat(pattern.matcher(value.name()).matches()).isTrue();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("valueOfName(name) returns valid value for known name")
    @Test
    void valueOfName_ExpectedResult_NameIsKnown() {
        final EnumSet<천간> set = EnumSet.allOf(천간.class);
        final String[] names = new String[] {"갑", "을", "병", "정", "무", "기", "경", "신", "임", "계"};
        for (int i = 0; i < names.length; i++) {
            final String name = names[i];
            final 천간 value = 천간.valueOfName(name);
            assertThat(value.ordinal()).isSameAs(i);
            assertThat(set.remove(value)).isTrue();
        }
        assertThat(set).isEmpty();
    }

    @DisplayName("valueOfName(name) throws IllegalArgumentException when name is unknown")
    @Test
    void valueOfName_IllegalArgumentException_NameIsUnknown() {
        assertThrows(IllegalArgumentException.class, () -> 천간.valueOfName(""));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("valueOf(天干) returns valid value for known 天干")
    @Test
    void valueOf天干_ExpectedResult_天干IsKnown() {
        final EnumSet<천간> set = EnumSet.noneOf(천간.class);
        for (final 天干 天干 : 天干.values()) {
            final 천간 value = 천간.valueOf(天干);
            assertThat(value).isNotNull();
            assertThat(value.天干).isSameAs(天干);
            assertThat(set.add(value)).isTrue();
        }
        assertThat(set).isEqualTo(EnumSet.allOf(천간.class));
    }
}