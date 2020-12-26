package com.github.jinahya.sexagenarycycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
class 지지Test {

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("REGEXP_NAME matches for every name")
    @Test
    void REGEXP_NAME_Match_EveryName() {
        final Pattern pattern = Pattern.compile(지지.REGEXP_NAME);
        for (final 지지 value : 지지.values()) {
            assertThat(pattern.matcher(value.name()).matches()).isTrue();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("ofName(name) returns valid value for known name")
    @Test
    void ofName_ExpectedResult_NameIsKnown() {
        final EnumSet<지지> set = EnumSet.allOf(지지.class);
        final String[] names = new String[] {"자", "축", "인", "묘", "진", "사", "오", "미", "신", "유", "술", "해"};
        for (int i = 0; i < names.length; i++) {
            final String name = names[i];
            final 지지 value = 지지.valueOfName(name);
            assertThat(value).isNotNull().isSameAs(지지.valueOf(name));
            assertThat(value.ordinal()).isSameAs(i);
            assertThat(set.remove(value)).isTrue();
        }
        assertThat(set).isEmpty();
    }

    @DisplayName("ofName(name) throws IllegalArgumentException when name is unknown")
    @Test
    void ofName_IllegalArgumentException_NameIsUnknown() {
        assertThrows(IllegalArgumentException.class, () -> 지지.valueOfName(""));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("of地支(地支) returns valid value for known 地支")
    @Test
    void of地支_ExpectedResult_地支IsKnown() {
        final EnumSet<지지> set = EnumSet.noneOf(지지.class);
        for (final 地支 地支 : 地支.values()) {
            final 지지 value = 지지.valueOf(地支);
            assertThat(value).isNotNull();
            assertThat(value.地支).isSameAs(地支);
            assertThat(set.add(value)).isTrue();
        }
        assertThat(set).isEqualTo(EnumSet.allOf(지지.class));
    }
}