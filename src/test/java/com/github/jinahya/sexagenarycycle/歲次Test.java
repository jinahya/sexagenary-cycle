package com.github.jinahya.sexagenarycycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Year;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class 歲次Test { // 歲次Test

    // ------------------------------------------------------------------------------------------------------------ 2020
    static 歲次 of2020庚子年() { // 경자년
        return new 歲次(干支.valueOfName("庚子"), Year.of(2020));
    }

    // -----------------------------------------------------------------------------------------------------------------
    static Stream<歲次> parameters() {
        return Stream.of(
                of2020庚子年()
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"parameters"})
    @ParameterizedTest
    void testToString(final 歲次 歲次) {
        assertThat(歲次.toString()).isNotBlank();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void testEquals() {
        assertThat(of2020庚子年()).isEqualTo(new 歲次(干支.valueOfKoreanName("경자"), Year.of(2020)));
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void testEquals(final 歲次 歲次) throws CloneNotSupportedException {
        assertThat(歲次).isEqualTo(歲次.clone());
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void testCompareTo() {
        {
            final 歲次 庚子年 = of2020庚子年();
            final 歲次 己亥年 = new 歲次(干支.valueOfName("己亥"), Year.of(2019));
            assertThat(庚子年).isGreaterThan(己亥年);
            assertThat(己亥年).isLessThan(庚子年);
        }
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void testCompareTo(final 歲次 歲次) throws CloneNotSupportedException {
        assertThat(歲次.compareTo(歲次.clone())).isZero();
        assertThat(歲次).isGreaterThan(歲次.getPrevious());
        assertThat(歲次.getPrevious()).isLessThan(歲次);
        assertThat(歲次).isLessThan(歲次.getNext());
        assertThat(歲次.getNext()).isGreaterThan(歲次);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void testGetPrevious() {
        {
            final 歲次 庚子年 = of2020庚子年();
            final 歲次 己亥年 = new 歲次(干支.valueOfName("己亥"), Year.of(2019));
            assertThat(庚子年.getPrevious()).isNotNull().isEqualTo(己亥年);
        }
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void testGetPrevious(final 歲次 歲次) {
        assertThat(歲次.getPrevious()).isNotNull().satisfies(p -> {
            assertThat(p.getYear()).isNotNull().isEqualTo(歲次.getYear().minusYears(1L));
        });
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void testGetNext() {
        {
            final 歲次 庚子年 = of2020庚子年();
            final 歲次 辛丑年 = new 歲次(干支.valueOfName("辛丑"), Year.of(2021));
            assertThat(庚子年.getNext()).isNotNull().isEqualTo(辛丑年);
        }
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void testGetNext(final 歲次 歲次) {
        assertThat(歲次.getNext()).isNotNull().satisfies(n -> {
            assertThat(n.getYear()).isNotNull().isEqualTo(歲次.getYear().plusYears(1L));
        });
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"parameters"})
    @ParameterizedTest
    void testGet干支(final 歲次 歲次) {
        assertThat(歲次.get干支()).satisfies(v -> {
        });
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"parameters"})
    @ParameterizedTest
    void testGetYear(final 歲次 歲次) {
        assertThat(歲次.getYear()).satisfies(v -> {
        });
    }
}