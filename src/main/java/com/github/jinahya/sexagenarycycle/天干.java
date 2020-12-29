package com.github.jinahya.sexagenarycycle;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/**
 * Constants of <a href="https://en.wikipedia.org/wiki/Heavenly_Stems">Heavenly Stems</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see 천간
 * @see <a href="https://zh.wikipedia.org/wiki/%E5%A4%A9%E5%B9%B2">天干</a>
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S100", "java:S115"})
public enum 天干 implements RollingEnum<天干> { // \u5929\u5e72

    甲, // 갑

    乙, // 을

    丙, // 병

    丁, // 정

    戊, // 무

    己, // 기

    庚, // 경

    辛, // 신

    壬, // 임

    癸; // 계

    // -----------------------------------------------------------------------------------------------------------------
    static final String REGEXP_NAME = "[\u7532\u4e59\u4e19\u4e01\u620a\u5df1\u5e9a\u8f9b\u58ec\u7678]";

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<String, 天干> VALUES_BY_NAMES
            = Collections.unmodifiableMap(EnumUtils.mapValuesByNames(天干.class));

    /**
     * Returns the constant of specified name. This method, unlikely to {@link #valueOf(String)} method, uses a cache.
     *
     * @param name the name.
     * @return the constant associated with {@code name}.
     */
    public static 天干 valueOfName(final String name) {
        Objects.requireNonNull(name, "name is null");
        final 天干 value = VALUES_BY_NAMES.get(name);
        if (value == null) {
            throw new IllegalArgumentException("no value for name: " + name);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the 二十四方 associated to this 天干.
     *
     * @return the 二十四方 associated to this 天干; may be {@code null} when associated to none.
     */
    public 二十四方 get二十四方() {
        return 天干方位.方位Of(this);
    }

    /**
     * Returns the 五方 associated to this 天干.
     *
     * @return the 五方 associated to this 天干.
     */
    public 五方 get五方() {
        return 天干五方.五方Of(this);
    }

    /**
     * Returns the 五行 associated to this 天干.
     *
     * @return the 五行 associated to this 天干.
     */
    public 五行 get五行() {
        return 天干五行.五行Of(this);
    }

    /**
     * Returns the 陰陽 associated to this 天干.
     *
     * @return the 陰陽 associated to this 天干.
     */
    public 陰陽 get陰陽() {
        return 天干陰陽.陰陽Of(this);
    }
}
