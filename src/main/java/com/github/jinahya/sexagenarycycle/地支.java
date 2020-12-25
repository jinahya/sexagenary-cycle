package com.github.jinahya.sexagenarycycle;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Constants of 10 <a href="https://en.wikipedia.org/wiki/Earthly_Branches">Earthly Branches</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see 지지
 * @see <a href="https://zh.wikipedia.org/wiki/%E5%9C%B0%E6%94%AF">地支</a>
 */
public enum 地支 implements Rolling<地支> { // \u5730\u652f

    子, // 자
    丑, // 축
    寅, // 인
    卯, // 묘
    辰, // 진
    巳, // 사
    午, // 오
    未, // 미
    申, // 신
    酉, // 유
    戌, // 술
    亥; // 해

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
        Objects.requireNonNull(name, "name is null");
        final 地支 value = VALUES_BY_NAMES.get(name);
        if (value == null) {
            throw new IllegalArgumentException("no value for name: " + name);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the previous value of this 地支.
     *
     * @return the previous value of this 地支.
     */
    public 地支 getPrevious() {
        地支 p = previous;
        if (p == null) {
            previous = p = Rolling.getPrevious(this);
        }
        return p;
    }

    /**
     * Returns the next value of this 地支.
     *
     * @return the next value of this 地支.
     */
    @Override
    public 地支 getNext() {
        地支 n = next;
        if (n == null) {
            next = n = Rolling.getNext(this);
        }
        return n;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private volatile 地支 previous;

    private volatile 地支 next;
}
