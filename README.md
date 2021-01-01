# sexagenary-cycle

[![Java CI with Maven](https://github.com/jinahya/sexagenary-cycle/workflows/Java%20CI%20with%20Maven/badge.svg?branch=develop)](https://github.com/jinahya/sexagenary-cycle/actions)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=jinahya_sexagenary-cycle&metric=alert_status)](https://sonarcloud.io/dashboard?id=jinahya_sexagenary-cycle)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.jinahya/sexagenary-cycle)](https://search.maven.org/search?q=g:com.github.jinahya%20a:sexagenary-cycle)
[![javadoc](https://javadoc.io/badge2/com.github.jinahya/sexagenary-cycle/javadoc.svg)](https://javadoc.io/doc/com.github.jinahya/sexagenary-cycle)

A small library for [Sexagenary cycle](https://en.wikipedia.org/wiki/Sexagenary_cycle) depends on 0 external libraries.

Note that this library is not for converting dates between the lunar calendar and the sonar calendar. Please
check [음양력변환계산 (한국천문연구원/천문우주시직정보)](https://astro.kasi.re.kr/life/pageView/8)
and/or [음양력 정보 (공공데이터포탈)](https://www.data.go.kr/data/15012679/openapi.do).

See
also [datagokr-api-b090041-lrsrcldinfoservice-client-spring](https://github.com/jinahya/datagokr-api-b090041-lrsrcldinfoservice-client-spring)
.

## [천간][천간]\([天干][天干], [Heavenly Stems][Heavenly_Stems])

```java
final 天干 甲 = 天干.valueOf("甲");
assertThat(甲.getPrevious()).isSameAs(天干.valueOfName("癸"));
final 天干 乙 = 天干.valueOfName("乙");
assertThat(乙.getNext()).isSameAs(天干.valueOfName("丙"));
assertThat(乙.getPrevious()).isSameAs(甲);
```

## [지지][지지]\([地支][地支], [Earthly Branches][Earthly_Branches])

```java
final 地支 子 = 地支.valueOfName("子");
assertThat(子.getPrevious()).isSameAs(地支.valueOfName("亥"));
final 地支 丑 = 地支.valueOf("丑");
assertThat(丑.getNext()).isSameAs(地支.valueOf("寅"));
assertThat(丑.getPrevious()).isSameAs(子);
```

## [간지][간지]\([干支][干支], [Sexagenary cycle][Sexagenary_cycle])

```java
final 干支 甲子 = 干支.valueOfName("甲子");
assertThat(甲子.getName()).isEqualTo("甲子");
assertThat(甲子).isSameAs(干支.valueOf(天干.valueOfName("甲"), 地支.valueOfName("子")));
assertThat(甲子.getPrevious()).isSameAs(干支.valueOfName("癸亥"));
assertThat(甲子.getNext()).isSameAs(干支.valueOfName("乙丑"));
```

## [세차][세차]\(歲次) / [월건][월건]\(月建) / [일진][일진]\(日辰)

```java
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