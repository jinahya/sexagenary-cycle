package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

/**
 * Constants for <a href="https://en.wikipedia.org/wiki/Wuxing_(Chinese_philosophy)">Wuxing (Chinese philosophy)</a>.
 *
 * @see 五行
 * @see <a href="https://ko.wikipedia.org/wiki/%EC%98%A4%ED%96%89">오행</a>
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S115", "java:S116", "java:S117"})
public enum 오행 {

    /**
     * 나무.
     *
     * @see 五行#木
     */
    목(com.github.jinahya.sexagenarycycle.五行.木),

    /**
     * 불.
     *
     * @see 五行#火
     */
    화(com.github.jinahya.sexagenarycycle.五行.火),

    /**
     * 흙.
     *
     * @see 五行#土
     */
    토(com.github.jinahya.sexagenarycycle.五行.土),

    /**
     * 쇠.
     *
     * @see 五行#金
     */
    금(com.github.jinahya.sexagenarycycle.五行.金),

    /**
     * 물.
     *
     * @see 五行#水
     */
    수(com.github.jinahya.sexagenarycycle.五行.水);

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<五行, 오행> VALUES_BY_五行S = Collections.unmodifiableMap(
            EnumUtils.mapValuesBy(오행.class, v -> v.五行, () -> new EnumMap<>(五行.class))
    );

    /**
     * Returns the value of specified 五行.
     *
     * @param 五行 the 五行.
     * @return the value of {@code 五行}.
     */
    public static 오행 valueOf(final 五行 五行) {
        Objects.requireNonNull(五行, "五行 is null");
        final 오행 value = VALUES_BY_五行S.get(五行);
        if (value == null) {
            throw new AssertionError("no value for " + 五行);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    오행(final 五行 五行) {
        this.五行 = Objects.requireNonNull(五行, "五行 is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    public final 五行 五行;
}
