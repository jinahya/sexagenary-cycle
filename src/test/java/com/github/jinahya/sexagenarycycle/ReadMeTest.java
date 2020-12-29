package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.Year;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class ReadMeTest {

    @Test
    void 天干() {
        final 天干 甲 = 天干.valueOf("甲");
        assertThat(甲.getPrevious()).isSameAs(天干.valueOfName("癸"));
        final 天干 乙 = 天干.valueOfName("乙");
        assertThat(乙.getNext()).isSameAs(天干.valueOfName("丙"));
        assertThat(乙.getPrevious()).isSameAs(甲);
    }

    @Test
    void 地支() {
        final 地支 子 = 地支.ofName("子");
        assertThat(子.getPrevious()).isSameAs(地支.ofName("亥"));
        final 地支 丑 = 地支.valueOf("丑");
        assertThat(丑.getNext()).isSameAs(地支.valueOf("寅"));
        assertThat(丑.getPrevious()).isSameAs(子);
    }

    @Test
    void 干支() {
        final 干支 甲子 = 干支.valueOfName("甲子");
        assertThat(甲子.getName()).isEqualTo("甲子");
        assertThat(甲子).isSameAs(干支.valueOf(天干.valueOfName("甲"), 地支.ofName("子")));
        assertThat(甲子.getPrevious()).isSameAs(干支.valueOfName("癸亥"));
        assertThat(甲子.getNext()).isSameAs(干支.valueOfName("乙丑"));
    }

    @Test
    void assigned() {
        // (陰曆) 2020
        final 歲次 庚子年 = new 歲次(干支.valueOfName("庚子"), Year.of(2020));
        assertThat(庚子年.年.getValue()).isEqualTo(2020);
        assertThat(庚子年.getPrevious()).isEqualTo(new 歲次(干支.valueOfName("庚子").getPrevious(), Year.of(2019)));
        assertThat(庚子年.getNext()).isEqualTo(new 歲次(干支.valueOfName("庚子").getNext(), Year.of(2021)));
        // (陰曆) 2020-12
        final 月建 戊子月 = new 月建(干支.valueOfName("戊子"), Month.DECEMBER, 庚子年);
        assertThat(戊子月.月).isSameAs(Month.DECEMBER);
        assertThat(戊子月.is閏月()).isFalse();
        // (陰曆) 2020-12-23 / (陽曆) 2021-02-04.
        final 日辰 庚子日 = new 日辰(干支.valueOfName("庚子"), 23, 戊子月);
        assertThat(庚子日.日).isEqualTo(23);
        // Two APRIL(4月)s in 2020
        {
            // (陰曆) 2020-04; the 1st APRIL of 2020
            final 月建 辛巳月 = new 月建(干支.valueOfName("辛巳"), Month.APRIL, 庚子年);
            assertThat(辛巳月.is閏月()).isFalse();
            // (陰曆) 2020-04-01 / (陽曆) 2020-04-23
            final 日辰 丙申日 = new 日辰(干支.valueOfName("丙申"), 23, 辛巳月);
            assertThat(丙申日.日).isEqualTo(23);
        }
        {
            // (陰曆) 2020-04; the 2nd APRIL of 2020
            final 月建 閏四月 = 月建.newInstanceOf閏月(Month.APRIL, 庚子年);
            assertThat(閏四月.is閏月()).isTrue();
            // (陰曆) 2020-04-01 / (陽曆) 2020-05-23.
            final 日辰 丙寅日 = new 日辰(干支.valueOfName("丙寅"), 1, 閏四月);
            assertThat(丙寅日.日).isEqualTo(1);
        }
    }
}
