package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.LocalTime;
import java.time.Month;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

/**
 * Constants of 10 <a href="https://en.wikipedia.org/wiki/Earthly_Branches">Earthly Branches</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see 지지
 * @see <a href="https://zh.wikipedia.org/wiki/%E5%9C%B0%E6%94%AF">地支</a>
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S100", "java:S115", "java:S116", "java:S117"})
public enum 地支 implements RollingEnum<地支> { // \u5730\u652f

    子(com.github.jinahya.sexagenarycycle.五行.水), // 자
    丑(com.github.jinahya.sexagenarycycle.五行.土), // 축
    寅(com.github.jinahya.sexagenarycycle.五行.木), // 인
    卯(com.github.jinahya.sexagenarycycle.五行.木), // 묘
    辰(com.github.jinahya.sexagenarycycle.五行.土), // 진
    巳(com.github.jinahya.sexagenarycycle.五行.火), // 사
    午(com.github.jinahya.sexagenarycycle.五行.火), // 오
    未(com.github.jinahya.sexagenarycycle.五行.土), // 미
    申(com.github.jinahya.sexagenarycycle.五行.金), // 신
    酉(com.github.jinahya.sexagenarycycle.五行.金), // 유
    戌(com.github.jinahya.sexagenarycycle.五行.土), // 술
    亥(com.github.jinahya.sexagenarycycle.五行.水); // 해

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The regular expression for a single name.
     */
    public static final String REGEXP_NAME
            = "[\u5b50\u4e11\u5bc5\u536f\u8fb0\u5df3\u5348\u672a\u7533\u9149\u620c\u4ea5]";

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<String, 地支> VALUES_BY_NAMES;

    static {
        final Map<String, 地支> m = new HashMap<>();
        for (final 地支 value : values()) {
            m.put(value.name(), value);
        }
        VALUES_BY_NAMES = Collections.unmodifiableMap(m);
    }

    /**
     * Returns the constant of specified name. This method, unlikely to {@link #valueOf(String)} method, uses a cache.
     *
     * @param name the name.
     * @return the constant associated with {@code name}.
     */
    public static 地支 ofName(final String name) {
        requireNonNull(name, "name is null");
        final 地支 value = VALUES_BY_NAMES.get(name);
        if (value == null) {
            throw new IllegalArgumentException("no value for name: " + name);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    地支(com.github.jinahya.sexagenarycycle.五行 五行) {
        二十四方 = com.github.jinahya.sexagenarycycle.二十四方.valueOfDirection(ordinal() * 30, true);
        this.五行 = requireNonNull(五行, "五行 is null");
        時刻 = new com.github.jinahya.sexagenarycycle.時刻(
                LocalTime.MIDNIGHT.plus(Duration.ofHours(((long) ordinal() << 1L) - 1L)),
                Duration.ofHours(2L)
        );
        月份 = Month.JANUARY.plus((long) ordinal() + 10L);
        陰陽 = (ordinal() & 0x01) == 0
             ? com.github.jinahya.sexagenarycycle.陰陽.陽 : com.github.jinahya.sexagenarycycle.陰陽.陰;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The 二十四方 associated with this 地支.
     */
    @NotNull
    public final 二十四方 二十四方;

    /**
     * The 五行 associated with this 地支.
     */
    @NotNull
    public final 五行 五行;

    /**
     * The 時刻 associated with this 地支.
     */
    @NotNull
    public final 時刻 時刻;

    /**
     * The Month associated with this 地支.
     */
    @NotNull
    public final Month 月份;

    /**
     * The 陰陽 associated with this 地支.
     */
    @NotNull
    public final 陰陽 陰陽;
}
