package com.github.jinahya.sexagenarycycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Year;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class 歲次Test {

    // ------------------------------------------------------------------------------------------------------------ 2020
    static 歲次 of2020庚子年() { // 경자년
        return new 歲次(干支.ofName("庚子"), Year.of(2020));
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
    void toString_NonBlank(final 歲次 歲次) {
        assertThat(歲次.toString()).isNotBlank();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"parameters"})
    @ParameterizedTest
    void equals_True_Self(final 歲次 歲次) {
        assertThat(歲次).isEqualTo(歲次);
        assertThat(歲次.equals(歲次)).isTrue();
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void equals_True_Clone(final 歲次 歲次) throws CloneNotSupportedException {
        assertThat(歲次).isEqualTo(歲次.clone());
        assertThat(歲次.equals(歲次.clone())).isTrue();
    }

    // ---------------------------------------------------------------------------------- compareTo(Ljava.lang.Object;)B
    @Test
    void compareTo_() {
        {
            final 歲次 庚子年 = of2020庚子年();
            assertThat(庚子年).isEqualByComparingTo(庚子年);
            {
                final 歲次 己亥年 = new 歲次(干支.ofName("己亥"), Year.of(2019));
                assertThat(庚子年).isGreaterThan(己亥年);
                assertThat(己亥年).isLessThan(庚子年);
            }
        }
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void compareTo_(final 歲次 歲次) throws CloneNotSupportedException {
        assertThat(歲次).isEqualByComparingTo(歲次.clone());
        assertThat(歲次).isGreaterThan(歲次.getPrevious());
        assertThat(歲次.getPrevious()).isLessThan(歲次);
        assertThat(歲次).isLessThan(歲次.getNext());
        assertThat(歲次.getNext()).isGreaterThan(歲次);
    }

    // ------------------------------------------------------------ getPrevious()Lcom.github.jinahya.sexagenarycycle.歲次;
    @Test
    void testGetPrevious() {
        {
            final 歲次 庚子年 = of2020庚子年();
            final 歲次 己亥年 = new 歲次(干支.ofName("己亥"), Year.of(2019));
            assertThat(庚子年.getPrevious()).isNotNull().isEqualTo(己亥年);
        }
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void testGetPrevious(final 歲次 歲次) {
        AssignedAssertions.assertThat(歲次.getPrevious()).isNotNull().hasYear(歲次.年.minusYears(1L));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void getNext_() {
        {
            final 歲次 庚子年 = of2020庚子年();
            final 歲次 辛丑年 = new 歲次(干支.ofName("辛丑"), Year.of(2021));
            assertThat(庚子年.getNext()).isNotNull().isEqualTo(辛丑年);
        }
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void getNext_(final 歲次 歲次) {
        AssignedAssertions.assertThat(歲次.getNext()).isNotNull().hasYear(歲次.年.plusYears(1L));
    }
}