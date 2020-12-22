package com.github.jinahya.sexagenarycycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class 地支Test {

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void test_REGEXP_NAME() {
        final Pattern pattern = Pattern.compile(地支.REGEXP_NAME);
        for (final 地支 value : 地支.values()) {
            assertThat(pattern.matcher(value.name()).matches()).isTrue();
        }
    }

    @Test
    void test_REGEXP_KOREAN_NAME() {
        final Pattern pattern = Pattern.compile(地支.REGEXP_KOREAN_NAME);
        for (final 地支 value : 地支.values()) {
            assertThat(pattern.matcher(value.koreanName()).matches()).isTrue();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void testPrevious() {
        for (final 地支 value : 地支.values()) {
            assertThat(value.getPrevious()).isNotNull().isNotSameAs(value)
                    .satisfiesAnyOf(
                            p -> {
                                assertThat(p.ordinal()).isSameAs(value.ordinal() - 1);
                            },
                            p -> {
                                assertThat(p.ordinal()).isSameAs(地支.values().length - 1);
                            }
                    )
                    .satisfies(p -> {
                        assertThat(p.getNext()).isNotNull().isSameAs(value);
                    });
        }
    }

    @Test
    void testNext() {
        for (final 地支 value : 地支.values()) {
            assertThat(value.getNext()).isNotNull().isNotSameAs(value)
                    .satisfiesAnyOf(
                            n -> {
                                assertThat(n.ordinal()).isSameAs(value.ordinal() + 1);
                            },
                            n -> {
                                assertThat(n.ordinal()).isZero();
                            }
                    )
                    .satisfies(n -> {
                        assertThat(n.getPrevious()).isNotNull().isSameAs(value);
                    })
            ;
        }
    }
}