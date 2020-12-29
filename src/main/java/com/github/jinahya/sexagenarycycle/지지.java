package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/**
 * Constants of 10 <a href="https://en.wikipedia.org/wiki/Earthly_Branches">Earthly Branches</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see 地支
 * @see <a href="https://ko.wikipedia.org/wiki/%EC%A7%80%EC%A7%80_(%EC%97%AD%EB%B2%95)">지지 (역법)</a>
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S115", "java:S116", "java:S117"})
public enum 지지 { // \uc9c0\uc9c0

    자(com.github.jinahya.sexagenarycycle.地支.子),
    축(com.github.jinahya.sexagenarycycle.地支.丑),
    인(com.github.jinahya.sexagenarycycle.地支.寅),
    묘(com.github.jinahya.sexagenarycycle.地支.卯),
    진(com.github.jinahya.sexagenarycycle.地支.辰),
    사(com.github.jinahya.sexagenarycycle.地支.巳),
    오(com.github.jinahya.sexagenarycycle.地支.午),
    미(com.github.jinahya.sexagenarycycle.地支.未),
    신(com.github.jinahya.sexagenarycycle.地支.申),
    유(com.github.jinahya.sexagenarycycle.地支.酉),
    술(com.github.jinahya.sexagenarycycle.地支.戌),
    해(com.github.jinahya.sexagenarycycle.地支.亥);

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The regular expression for a single Korean name.
     */
    public static final String REGEXP_NAME
            = "[\uc790\ucd95\uc778\ubb18\uc9c4\uc0ac\uc624\ubbf8\uc2e0\uc720\uc220\ud574]";

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<String, 지지> VALUES_BY_NAMES
            = Collections.unmodifiableMap(EnumUtils.mapValuesByNames(지지.class));

    /**
     * Returns the constant of specified name. This method, unlikely to {@link #valueOf(String)} method, uses a cache.
     *
     * @param name the name.
     * @return the constant associated with {@code name}.
     */
    public static 지지 valueOfName(final String name) {
        Objects.requireNonNull(name, "name is null");
        final 지지 value = VALUES_BY_NAMES.get(name);
        if (value == null) {
            throw new IllegalArgumentException("no value for name: " + name);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<地支, 지지> VALUES_BY_地支S
            = Collections.unmodifiableMap(EnumUtils.mapValuesBy(지지.class, v -> v.地支));

    /**
     * Returns the constant for specified 地支.
     *
     * @param 地支 the 地支.
     * @return the constant associated with {@code name}.
     */
    public static 지지 valueOf(final 地支 地支) {
        return VALUES_BY_地支S.get(Objects.requireNonNull(地支, "地支 is null"));
    }

    // -----------------------------------------------------------------------------------------------------------------
    지지(final 地支 地支) {
        this.地支 = Objects.requireNonNull(地支, "地支 is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    public final 地支 地支;
}
