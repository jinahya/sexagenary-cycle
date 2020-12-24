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
class 천간Test {

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("REGEXP_NAME matches for every value's name")
    @Test
    void REGEXP_NAME_Match_EveryValueName() {
        final Pattern pattern = Pattern.compile(천간.REGEXP_NAME);
        for (final 천간 value : 천간.values()) {
            assertThat(pattern.matcher(value.name()).matches()).isTrue();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("valueOfName(name) returns valid value for known name")
    @Test
    void valueOfName_ExpectedResult_NameIsKnown() {
        final EnumSet<天干> set = EnumSet.noneOf(天干.class);
        final String[] names = new String[] {"갑", "을", "병", "정", "무", "기", "경", "신", "임", "계"};
        for (int i = 0; i < names.length; i++) {
            final String name = names[i];
            final 천간 value = 천간.valueOfName(name);
            assertThat(value).isNotNull().isSameAs(천간.valueOf(name));
            assertThat(value.ordinal()).isSameAs(i);
            assertThat(set.add(value.天干)).isTrue();
        }
    }

    @DisplayName("valueOfName(name) throws IllegalArgumentException when name is unknown")
    @Test
    void valueOfName_IllegalArgumentException_NameIsUnknown() {
        assertThrows(IllegalArgumentException.class, () -> 천간.valueOfName(""));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("valueOf天干(天干) returns valid value for known 天干")
    @Test
    void valueOfName天干_ExpectedResult_天干IsKnown() {
        final EnumSet<천간> set = EnumSet.noneOf(천간.class);
        for (final 天干 天干 : 天干.values()) {
            final 천간 value = 천간.valueOf天干(天干);
            assertThat(value).isNotNull();
            assertThat(value.天干).isSameAs(天干);
            assertThat(set.add(value)).isTrue();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("getPrevious() returns expected value")
    @Test
    void getPrevious_ExpectedResult() {
        final Set<천간> all = Collections.unmodifiableSet(EnumSet.allOf(천간.class));
        for (final 천간 each : all) {
            assertThat(each.getPrevious()).isNotNull().isNotSameAs(each)
                    .satisfies(p -> {
                        assertThat(p.天干).isSameAs(each.天干.getPrevious());
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
        final Set<천간> all = Collections.unmodifiableSet(EnumSet.allOf(천간.class));
        for (final 천간 each : all) {
            assertThat(each.getNext()).isNotNull().isNotSameAs(each)
                    .satisfies(n -> {
                        assertThat(n.天干).isSameAs(each.天干.getNext());
                        assertThat(n.getPrevious()).isNotNull().isSameAs(each);
                        assertThat(n.ordinal()).satisfiesAnyOf(
                                o -> assertThat(o).isSameAs(each.ordinal() + 1),
                                o -> assertThat(o).isZero()
                        );
                    });
        }
    }
}