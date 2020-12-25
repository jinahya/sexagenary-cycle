package com.github.jinahya.sexagenarycycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
class 天干Test {

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("REGEXP_NAME matches for every name")
    @Test
    void REGEXP_NAME_Match_EveryName() {
        final Pattern pattern = Pattern.compile(天干.REGEXP_NAME);
        for (final 天干 value : 天干.values()) {
            assertThat(pattern.matcher(value.name()).matches()).isTrue();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("valueOfName(name) returns valid value for known name")
    @Test
    void valueOfName_ExpectedResult_NameIsKnown() {
        final String[] names = new String[] {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
        for (int i = 0; i < names.length; i++) {
            final String name = names[i];
            assertThat(天干.ofName(name)).isNotNull().isSameAs(天干.valueOf(name));
            assertThat(天干.ofName(name).ordinal()).isSameAs(i);
        }
    }

    @DisplayName("valueOfName(name) throws IllegalArgumentException when name is unknown")
    @Test
    void valueOfName_IllegalArgumentException_NameIsUnknown() {
        assertThrows(IllegalArgumentException.class, () -> 天干.ofName(""));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("getPrevious() returns expected value")
    @Test
    void getPrevious_ExpectedResult() {
        final Set<天干> all = EnumSet.allOf(天干.class);
        for (final 天干 each : all) {
            assertThat(each.getPrevious()).isNotNull().isNotSameAs(each)
                    .satisfies(p -> {
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
        final Set<天干> all = EnumSet.allOf(天干.class);
        for (final 天干 each : all) {
            assertThat(each.getNext()).isNotNull().isNotSameAs(each)
                    .satisfies(n -> {
                        assertThat(n.getPrevious()).isNotNull().isSameAs(each);
                        assertThat(n.ordinal()).satisfiesAnyOf(
                                o -> assertThat(o).isSameAs(each.ordinal() + 1),
                                o -> assertThat(o).isZero()
                        );
                    });
        }
    }
}