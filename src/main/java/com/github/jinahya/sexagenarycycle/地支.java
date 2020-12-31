package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

/**
 * Constants of 10 <a href="https://en.wikipedia.org/wiki/Earthly_Branches">Earthly Branches</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
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
    private static final Map<String, 地支> VALUES_BY_NAMES
            = Collections.unmodifiableMap(EnumUtils.mapValuesByNames(地支.class));

    /**
     * Returns the constant of specified name. This method, unlikely to {@link #valueOf(String)} method, uses a cache.
     *
     * @param name the name.
     * @return the constant associated with {@code name}.
     */
    public static 地支 valueOfName(final String name) {
        requireNonNull(name, "name is null");
        final 地支 value = VALUES_BY_NAMES.get(name);
        if (value == null) {
            throw new IllegalArgumentException("no value for name: " + name);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<二十四方, 地支> VALUES_BY_二十四方S = Collections.unmodifiableMap(
            EnumUtils.mapValuesBy(地支.class, v -> v.二十四方, () -> new EnumMap<>(二十四方.class))
    );

    /**
     * Returns the value associated with specified 二十四方.
     *
     * @param 二十四方 the 二十四方.
     * @return the value associated with {@code 二十四方}.
     */
    public static @NotNull 地支 valueOf(final @NotNull 二十四方 二十四方) {
        requireNonNull(二十四方, "二十四方 is null");
        final 地支 value = VALUES_BY_二十四方S.get(二十四方);
        if (value == null) {
            throw new AssertionError("no value for " + 二十四方);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns values associated with specified 五行.
     *
     * @param 五行 the 五行.
     * @return a list of values which each is associated with {@code 五行}.
     */
    public static @NotEmpty List<@NotNull 地支> valuesOf(final @NotNull 五行 五行) {
        requireNonNull(五行, "五行 is null");
        return Arrays.stream(values())
                .filter(v -> v.五行 == 五行)
                .collect(Collectors.toList());
    }

    // -----------------------------------------------------------------------------------------------------------------
    public static @NotNull 地支 valueOf(final @NotNull LocalTime time) {
        requireNonNull(time, "time is null");
        return Arrays.stream(values())
                .filter(v -> v.includes(time))
                .findAny()
                .orElseThrow(() -> new AssertionError("no value includes " + time));
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<Month, 地支> VALUES_BY_MONTHS = Collections.unmodifiableMap(
            EnumUtils.mapValuesBy(地支.class, v -> v.月份, () -> new EnumMap<>(Month.class))
    );

    public static @NotNull 地支 valueOf(final @NotNull Month month) {
        requireNonNull(month, "month is null");
        final 地支 value = VALUES_BY_MONTHS.get(month);
        if (value == null) {
            throw new AssertionError("no value for " + month);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns values associated with specified 陰陽.
     *
     * @param 陰陽 the 陰陽.
     * @return a list of values which each is associated with {@code 陰陽}.
     */
    public static @NotEmpty List<@NotNull 地支> valuesOf(final @NotNull 陰陽 陰陽) {
        requireNonNull(陰陽, "陰陽 is null");
        return Arrays.stream(values())
                .filter(v -> v.陰陽 == 陰陽)
                .collect(Collectors.toList());
    }

    // -----------------------------------------------------------------------------------------------------------------
    地支(final @NotNull com.github.jinahya.sexagenarycycle.五行 五行) {
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
     * Checks whether the time this value represents includes specified time.
     *
     * @param time the time.
     * @return {@code true} when the time of this value includes {@code time}; {@code false} otherwise.
     */
    public boolean includes(final LocalTime time) {
        requireNonNull(time, "time is null");
        return 時刻.includes(time);
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
    final 時刻 時刻;

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
