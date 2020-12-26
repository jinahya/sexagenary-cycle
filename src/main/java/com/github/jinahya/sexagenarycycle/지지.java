package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.github.jinahya.sexagenarycycle.地支.丑;
import static com.github.jinahya.sexagenarycycle.地支.亥;
import static com.github.jinahya.sexagenarycycle.地支.午;
import static com.github.jinahya.sexagenarycycle.地支.卯;
import static com.github.jinahya.sexagenarycycle.地支.子;
import static com.github.jinahya.sexagenarycycle.地支.寅;
import static com.github.jinahya.sexagenarycycle.地支.巳;
import static com.github.jinahya.sexagenarycycle.地支.戌;
import static com.github.jinahya.sexagenarycycle.地支.未;
import static com.github.jinahya.sexagenarycycle.地支.申;
import static com.github.jinahya.sexagenarycycle.地支.辰;
import static com.github.jinahya.sexagenarycycle.地支.酉;

/**
 * Constants of 10 <a href="https://en.wikipedia.org/wiki/Earthly_Branches">Earthly Branches</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see 地支
 * @see <a href="https://ko.wikipedia.org/wiki/%EC%A7%80%EC%A7%80_(%EC%97%AD%EB%B2%95)">지지 (역법)</a>
 */
public enum 지지 { // \uc9c0\uc9c0

    자(子),
    축(丑),
    인(寅),
    묘(卯),
    진(辰),
    사(巳),
    오(午),
    미(未),
    신(申),
    유(酉),
    술(戌),
    해(亥);

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The regular expression for a single Korean name.
     */
    public static final String REGEXP_NAME
            = "[\uc790\ucd95\uc778\ubb18\uc9c4\uc0ac\uc624\ubbf8\uc2e0\uc720\uc220\ud574]";

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<String, 지지> VALUES_BY_NAMES;

    static {
        final Map<String, 지지> m = new HashMap<>();
        for (final 지지 value : values()) {
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
    public static 지지 ofName(final String name) {
        Objects.requireNonNull(name, "name is null");
        final 지지 value = VALUES_BY_NAMES.get(name);
        if (value == null) {
            throw new IllegalArgumentException("no value for name: " + name);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<地支, 지지> VALUES_BY_地支S;

    static {
        final Map<地支, 지지> m = new EnumMap<>(地支.class);
        for (final 지지 value : values()) {
            m.put(value.地支, value);
        }
        VALUES_BY_地支S = Collections.unmodifiableMap(m);
    }

    /**
     * Returns the constant for specified 地支.
     *
     * @param 地支 the 地支.
     * @return the constant associated with {@code name}.
     */
    public static 지지 of(final 地支 地支) {
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
