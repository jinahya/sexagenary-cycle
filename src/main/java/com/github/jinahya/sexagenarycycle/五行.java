package com.github.jinahya.sexagenarycycle;

/**
 * Constants for <a href="https://en.wikipedia.org/wiki/Wuxing_(Chinese_philosophy)">Wuxing (Chinese philosophy)</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see 五方正色#valueOf(com.github.jinahya.sexagenarycycle.五行)
 * @see 五行相剋
 * @see 五行相生
 * @see <a href="https://zh.wikipedia.org/wiki/%E4%BA%94%E8%A1%8C">五行 (Wikipedia)</a>
 */
// https://www.compart.com/en/unicode/block/U+1F300
// https://www.compart.com/en/unicode/block/U+1F700 (Alchemical Symbols)
// https://www.compart.com/en/unicode/block/U+3200 (Enclosed CJK Letters and Months)
@SuppressWarnings({"NonAsciiCharacters", "java:S115"})
public enum 五行 implements RotatingEnum<五行> {

    /**
     * Constant for Wood.
     */
    // https://www.compart.com/en/unicode/block/U+1F300
    // https://www.compart.com/en/unicode/U+1F332 (Evergreen Tree \ Miscellaneous Symbols and Pictographs)
    // https://www.compart.com/en/unicode/U+328D (Enclosed CJK Letters and Months)
    木,

    /**
     * Constant for Fire.
     */
    // https://www.compart.com/en/unicode/U+1F525 (Miscellaneous Symbols and Pictographs)
    // https://www.compart.com/en/unicode/U+1F702 (Alchemical Symbols)
    // https://www.compart.com/en/unicode/U+328B (Enclosed CJK Letters and Months)
    火,

    /**
     * Constant for Earth (or Soil).
     */
    // https://www.compart.com/en/unicode/U+1F30F (Miscellaneous Symbols and Pictographs)
    // https://www.compart.com/en/unicode/U+1F703 (Alchemical Symbols)
    // https://www.compart.com/en/unicode/U+328F (Enclosed CJK Letters and Months)
    土,

    /**
     * Constant for Metal (or Gold).
     */
    // https://www.compart.com/en/unicode/U+1F71A (Alchemical Symbols)
    // https://www.compart.com/en/unicode/U+328E (Enclosed CJK Letters and Months)
    金,

    /**
     * Constant for Water.
     */
    // https://www.compart.com/en/unicode/U+1F30A
    // https://www.compart.com/en/unicode/U+1F704 (Alchemical Symbols)
    // https://www.compart.com/en/unicode/U+328C (Enclosed CJK Letters and Months)
    水;
}
