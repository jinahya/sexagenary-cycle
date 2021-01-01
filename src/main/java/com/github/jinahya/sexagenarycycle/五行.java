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
@SuppressWarnings({"NonAsciiCharacters", "java:S115"})
public enum 五行 implements RotatingEnum<五行> {

    /**
     * Constant for Wood.
     */
    木, // 나무 목

    /**
     * Constant for Fire.
     */
    火, // 불 화

    /**
     * Constant for Earth (or Soil).
     */
    土, // 흙 토

    /**
     * Constant for Metal (or Gold).
     */
    金, // 쇠 금

    /**
     * Constant for Water.
     */
    水; // 물 수
}
