# sexagenary-cycle

[![Java CI with Maven](https://github.com/jinahya/sexagenary-cycle/workflows/Java%20CI%20with%20Maven/badge.svg?branch=develop)](https://github.com/jinahya/sexagenary-cycle/actions)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=jinahya_sexagenary-cycle&metric=alert_status)](https://sonarcloud.io/dashboard?id=jinahya_sexagenary-cycle)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.jinahya/sexagenary-cycle)](https://search.maven.org/search?q=g:com.github.jinahya%20a:sexagenary-cycle)
[![javadoc](https://javadoc.io/badge2/com.github.jinahya/sexagenary-cycle/javadoc.svg)](https://javadoc.io/doc/com.github.jinahya/sexagenary-cycle)

A small library for [Sexagenary cycle](https://en.wikipedia.org/wiki/Sexagenary_cycle) depends on 0 external libraries.

Note that this library is not for converting dates between lunar calendar and sonar calendar. Please see [음양력변환계산 (한국천문연구원/천문우주시직정보)](https://astro.kasi.re.kr/life/pageView/8) and/or [음양력 정보 (공공데이터포탈)](https://www.data.go.kr/data/15012679/openapi.do).

See also [datagokr-api-b090041-lrsrcldinfoservice-client-spring](https://github.com/jinahya/datagokr-api-b090041-lrsrcldinfoservice-client-spring).

## [천간][천간]\([天干][天干], [Heavenly Stems][Heavenly_Stems])

```java
final 天干 甲 = 天干.valueOf("甲");
assert 甲.getPrevious() == 天干.valueOfName("癸");
final 天干 乙 = 天干.valueOfName("乙");
assert 乙.getNext() == 天干.valueOfName("丙");
assert 乙.getPrevious() == 甲;
```

## [지지][지지]\([地支][地支], [Earthly Branches][Earthly_Branches])

```java
final 地支 子 = 地支.valueOfName("子");
assert 子.getPrevious() == 地支.valueOfName("亥");
final 地支 丑 = 地支.valueOf("丑");
assert 丑.getNext() == 地支.valueOf("寅");
assert 丑.getPrevious() == 子;
```

## [간지][간지]\([干支][干支], [Sexagenary cycle][Sexagenary_cycle])

```java
final 干支 甲子 = 干支.valueOfName("甲子");
assert 甲子.getName().equals("甲子");
assert 甲子.equals(干支.valueOf(天干.valueOfName("甲"), 地支.valueOfName("子")));
assert 甲子.getPrevious().equals(干支.valueOfName("癸亥"));
assert 甲子.getNext().equals(干支.valueOfName("乙丑"));
```

## [세차][세차]\(歲次) / [월건][월건]\(月建) / [일진][일진]\(日辰)

```java
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
```

[천간]: https://ko.wikipedia.org/wiki/%EC%B2%9C%EA%B0%84
[天干]: https://zh.wikipedia.org/wiki/%E5%A4%A9%E5%B9%B2
[Heavenly_Stems]: https://en.wikipedia.org/wiki/Heavenly_Stems

[지지]: https://ko.wikipedia.org/wiki/%EC%A7%80%EC%A7%80_(%EC%97%AD%EB%B2%95)
[地支]: https://zh.wikipedia.org/wiki/%E5%9C%B0%E6%94%AF
[Earthly_Branches]: https://en.wikipedia.org/wiki/Earthly_Branches

[간지]: https://ko.wikipedia.org/wiki/%EA%B0%84%EC%A7%80
[干支]: https://zh.wikipedia.org/wiki/%E5%B9%B2%E6%94%AF
[Sexagenary_cycle]: https://en.wikipedia.org/wiki/Sexagenary_cycle

[세차]: https://ko.wikipedia.org/wiki/%EC%84%B8%EC%B0%A8_(%EA%B0%84%EC%A7%80)

[월건]: https://ko.wikipedia.org/wiki/%EC%9B%94%EA%B1%B4

[일진]: https://ko.wikipedia.org/wiki/%EC%9D%BC%EC%A7%84_(%EA%B0%84%EC%A7%80)