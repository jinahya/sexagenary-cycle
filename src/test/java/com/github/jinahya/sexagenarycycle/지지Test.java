package com.github.jinahya.sexagenarycycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
class 지지Test {

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("REGEXP_NAME matches for every value's name")
    @Test
    void REGEXP_NAME_Match_EveryValueName() {
        final Pattern pattern = Pattern.compile(지지.REGEXP_NAME);
        for (final 지지 value : 지지.values()) {
            assertThat(pattern.matcher(value.name()).matches()).isTrue();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("valueOfName(name) returns valid value for known name")
    @Test
    void valueOfName_ExpectedResult_NameIsKnown() {
        final EnumSet<地支> set = EnumSet.noneOf(地支.class);
        final String[] names = new String[] {"자", "축", "인", "묘", "진", "사", "오", "미", "신", "유", "술", "해"};
        for (int i = 0; i < names.length; i++) {
            final String name = names[i];
            final 지지 value = 지지.valueOfName(name);
            assertThat(value).isNotNull().isSameAs(지지.valueOf(name));
            assertThat(value.ordinal()).isSameAs(i);
            assertThat(set.add(value.地支)).isTrue();
        }
    }

    @DisplayName("valueOfName(name) throws IllegalArgumentException when name is unknown")
    @Test
    void valueOfName_IllegalArgumentException_NameIsUnknown() {
        assertThrows(IllegalArgumentException.class, () -> 지지.valueOfName(""));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("valueOf地支(地支) returns valid value for known 地支")
    @Test
    void valueOf地支_ExpectedResult_地支IsKnown() {
        final EnumSet<지지> set = EnumSet.noneOf(지지.class);
        for (final 地支 地支 : 地支.values()) {
            final 지지 value = 지지.valueOf地支(地支);
            assertThat(value).isNotNull();
            assertThat(value.地支).isSameAs(地支);
            assertThat(set.add(value)).isTrue();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("getPrevious() returns expected value")
    @Test
    void getPrevious_ExpectedResult() {
        final Set<지지> all = Collections.unmodifiableSet(EnumSet.allOf(지지.class));
        for (final 지지 each : all) {
            assertThat(each.getPrevious()).isNotNull().isNotSameAs(each)
                    .satisfies(p -> {
                        assertThat(p.地支).isSameAs(each.地支.getPrevious());
                        assertThat(p.getNext()).isNotNull().isSameAs(each);
                        assertThat(p.ordinal()).satisfiesAnyOf(
                                o -> assertThat(o).isSameAs(each.ordinal() - 1),
                                o -> assertThat(o).isSameAs(all.size() - 1)
                        );
                    });
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("getNext() returns expected value")
    @Test
    void getNext_ExpectedResult() {
        final Set<지지> all = Collections.unmodifiableSet(EnumSet.allOf(지지.class));
        for (final 지지 each : all) {
            assertThat(each.getNext()).isNotNull().isNotSameAs(each)
                    .satisfies(n -> {
                        assertThat(n.地支).isSameAs(each.地支.getNext());
                        assertThat(n.getPrevious()).isNotNull().isSameAs(each);
                        assertThat(n.ordinal()).satisfiesAnyOf(
                                o -> assertThat(o).isSameAs(each.ordinal() + 1),
                                o -> assertThat(o).isZero()
                        );
                    });
        }
    }
}