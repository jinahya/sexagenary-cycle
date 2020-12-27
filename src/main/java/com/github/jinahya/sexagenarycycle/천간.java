package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.github.jinahya.sexagenarycycle.天干.丁;
import static com.github.jinahya.sexagenarycycle.天干.丙;
import static com.github.jinahya.sexagenarycycle.天干.乙;
import static com.github.jinahya.sexagenarycycle.天干.壬;
import static com.github.jinahya.sexagenarycycle.天干.己;
import static com.github.jinahya.sexagenarycycle.天干.庚;
import static com.github.jinahya.sexagenarycycle.天干.戊;
import static com.github.jinahya.sexagenarycycle.天干.甲;
import static com.github.jinahya.sexagenarycycle.天干.癸;
import static com.github.jinahya.sexagenarycycle.天干.辛;

/**
 * Constants of <a href="https://en.wikipedia.org/wiki/Heavenly_Stems">Heavenly Stems</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see 天干
 * @see <a href="https://ko.wikipedia.org/wiki/%EC%B2%9C%EA%B0%84">천간</a>
 */
public enum 천간 { // \ucc9c\uac04

    갑(甲),
    을(乙),
    병(丙),
    정(丁),
    무(戊),
    기(己),
    경(庚),
    신(辛),
    임(壬),
    계(癸);

    // -----------------------------------------------------------------------------------------------------------------
    static final String REGEXP_NAME = "[\uac11\uc744\ubcd1\uc815\ubb34\uae30\uacbd\uc2e0\uc784\uacc4]";

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<String, 천간> VALUES_BY_NAMES;

    static {
        final Map<String, 천간> map = new HashMap<>();
        for (final 천간 value : values()) {
            map.put(value.name(), value);
        }
        VALUES_BY_NAMES = Collections.unmodifiableMap(map);
    }

    /**
     * Returns the constant of specified name. This method, unlikely to {@link #valueOf(String)} method, uses a cache.
     *
     * @param name the name.
     * @return the constant associated with {@code name}.
     */
    public static 천간 valueOfName(final String name) {
        Objects.requireNonNull(name, "name is null");
        final 천간 value = VALUES_BY_NAMES.get(name);
        if (value == null) {
            throw new IllegalArgumentException("no value for name: " + name);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<天干, 천간> VALUES_BY_天干S;

    static {
        final Map<天干, 천간> m = new EnumMap<>(天干.class);
        for (final 천간 value : values()) {
            m.put(value.天干, value);
        }
        VALUES_BY_天干S = Collections.unmodifiableMap(m);
    }

    /**
     * Returns the constant for specified 天干.
     *
     * @param 天干 the 天干.
     * @return the constant associated with {@code name}.
     */
    public static 천간 valueOf(final 天干 天干) {
        return VALUES_BY_天干S.get(Objects.requireNonNull(天干, "天干 is null"));
    }

    // -----------------------------------------------------------------------------------------------------------------
    천간(final 天干 天干) {
        this.天干 = Objects.requireNonNull(天干, "天干 is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    public final 天干 天干;
}
