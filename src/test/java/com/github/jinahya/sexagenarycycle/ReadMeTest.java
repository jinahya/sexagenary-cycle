package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.Year;

class ReadMeTest {

    @Test
    void 天干() {
        final 天干 甲 = 天干.valueOf("甲");
        assert 甲.getPrevious() == 天干.valueOfName("癸");
        final 天干 乙 = 天干.valueOfName("乙");
        assert 乙.getNext() == 天干.valueOfName("丙");
        assert 乙.getPrevious() == 甲;
    }

    @Test
    void branch() {
        final 地支 子 = 地支.valueOfName("子");
        assert 子.getPrevious() == 地支.valueOfName("亥");
        final 地支 丑 = 地支.valueOf("丑");
        assert 丑.getNext() == 地支.valueOf("寅");
        assert 丑.getPrevious() == 子;
    }

    @Test
    void 干支() {
//        final 干支 c = 干支.valueOfName("甲子");
//        assert c.equals(干支.valueOf(天干.valueOfName("甲"), 地支.valueOfKoreanName("자")));
//        assert c.getName().equals("甲子");
//        assert c.getKoreanName().equals("갑자");
//        assert c.getPrevious().equals(干支.valueOfName("癸亥"));
//        assert c.getPrevious().equals(干支.valueOfKoreanName("계해"));
//
//        final 干支 k = 干支.valueOfKoreanName("갑자");
//        assert k.equals(干支.valueOf(天干.valueOfKoreanName("갑"), 地支.valueOfName("子")));
//        assert k.getName().equals("甲子");
//        assert k.getKoreanName().equals("갑자");
//        assert k.getNext().equals(干支.valueOfKoreanName("을축"));
//        assert c.getNext().equals(干支.valueOfName("乙丑"));
//
//        assert c.equals(k);
//        assert c == k;
//        assert k.equals(c);
//        assert k == c;
    }

    @Test
    void assigned() {

        // (陰曆) 2020.
        final 歲次 庚子年 = new 歲次(干支.valueOfName("庚子"), Year.of(2020));
        assert 庚子年.getYear().getValue() == 2020;
        assert 庚子年.getPrevious().equals(new 歲次(干支.valueOfName("庚子").getPrevious(), Year.of(2019)));
        assert 庚子年.getNext().equals(new 歲次(干支.valueOfName("庚子").getNext(), Year.of(2021)));

        // (陰曆) 2020-12.
        final 月建 戊子月 = new 月建(干支.valueOfName("戊子"), Month.DECEMBER, 庚子年);
        assert !戊子月.isLeapMonth();
        assert 戊子月.getMonth() == Month.DECEMBER;
        assert 戊子月.get歲次().getYear().getValue() == 2020;

        // (陰曆) 2020-12-23 represents (陽曆) 2021-02-04.
        final 日辰 庚子日 = new 日辰(干支.valueOfName("庚子"), 23, 戊子月);
        assert 庚子日.getDayOfMonth() == 23;
        assert 庚子日.get月建().getMonth() == 戊子月.getMonth();

        // There are two APRIL(4月)s in 2020.
        {
            // (陰曆) 2020-04; the 1st APRIL of 2020.
            final 月建 辛巳月 = new 月建(干支.valueOfName("辛巳"), Month.APRIL, 庚子年);
            assert !辛巳月.isLeapMonth();
            // (陰曆) 2020-04-01 represents (陽曆) 2020-04-23
            final 日辰 丙申日 = new 日辰(干支.valueOfName("丙申"), 23, 辛巳月);
        }
        {
            // (陰曆) 2020-04; the 2nd APRIL of 2020.
            final 月建 閏四月 = 月建.ofLeapMonth(Month.APRIL, 庚子年);
            assert 閏四月.isLeapMonth();
            // (陰曆) 2020-04-01 represents (陽曆) 2020-05-23.
            final 日辰 丙寅日 = new 日辰(干支.valueOfName("丙寅"), 1, 閏四月);
        }
    }
}
