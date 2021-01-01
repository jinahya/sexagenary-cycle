package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Constants of <a href="https://en.wikipedia.org/wiki/Heavenly_Stems">the ten Heavenly Stems</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see 천간
 * @see <a href="https://zh.wikipedia.org/wiki/%E5%A4%A9%E5%B9%B2">天干</a>
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S100", "java:S115", "java:S116"})
public enum 天干 implements RotatingEnum<天干> { // \u5929\u5e72

    /**
     * The 1st.
     */
    甲, // 갑

    /**
     * The 2nd.
     */
    乙, // 을

    /**
     * The 3rd.
     */
    丙, // 병

    /**
     * The 4th.
     */
    丁, // 정

    /**
     * The 5th.
     */
    戊, // 무

    /**
     * The 6th.
     */
    己, // 기

    /**
     * The 7th.
     */
    庚, // 경

    /**
     * The 8th.
     */
    辛, // 신

    /**
     * The 9th.
     */
    壬, // 임

    /**
     * The 10th.
     */
    癸; // 계

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The regular expression for matching each name.
     */
    public static final String REGEXP_NAME = "[\u7532\u4e59\u4e19\u4e01\u620a\u5df1\u5e9a\u8f9b\u58ec\u7678]";

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the constant of specified name. This method, unlikely to {@link #valueOf(String)} method, uses a cache.
     *
     * @param name the name.
     * @return the constant associated with {@code name}.
     */
    public static 天干 valueOfName(final String name) {
        Objects.requireNonNull(name, "name is null");
        return EnumUtils.valueOfName(天干.class, name);
    }

    // -----------------------------------------------------------------------------------------------------------------
    天干() {
        五方 = com.github.jinahya.sexagenarycycle.五方.values()[ordinal() >> 1];
        二十四方 = 五方 == com.github.jinahya.sexagenarycycle.五方.中
               ? null : com.github.jinahya.sexagenarycycle.二十四方.valueOf(name());
        五行 = com.github.jinahya.sexagenarycycle.五行.values()[ordinal() >> 1];
        陰陽 = (ordinal() & 0x01) == 0x00
             ? com.github.jinahya.sexagenarycycle.陰陽.陽 : com.github.jinahya.sexagenarycycle.陰陽.陰;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The 二十四方 of this 天干; {@code null} when {@link #五方} is {@link 五方#中 中}.
     */
    public final 二十四方 二十四方;

    /**
     * The 五方 associated with this 天干.
     */
    @NotNull
    public final 五方 五方;

    /**
     * The 五行 associated with this 天干.
     */
    @NotNull
    public final 五行 五行;

    /**
     * The 陰陽 associated with this 天干.
     */
    @NotNull
    public final 陰陽 陰陽;
}
