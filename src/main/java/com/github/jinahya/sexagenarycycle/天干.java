package com.github.jinahya.sexagenarycycle;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Constants of <a href="https://en.wikipedia.org/wiki/Heavenly_Stems">Heavenly Stems</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see 천간
 * @see <a href="https://zh.wikipedia.org/wiki/%E5%A4%A9%E5%B9%B2">天干</a>
 */
public enum 天干 implements Rolling<天干> { // \u5929\u5e72

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
    private static final Map<String, 天干> VALUES_BY_NAMES;

    static {
        final Map<String, 天干> m = new HashMap<>();
        for (final 天干 value : values()) {
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
    public static 天干 ofName(final String name) {
        Objects.requireNonNull(name, "name is null");
        final 天干 value = VALUES_BY_NAMES.get(name);
        if (value == null) {
            throw new IllegalArgumentException("no value for name: " + name);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the previous value of this 天干.
     *
     * @return the previous value of this 天干.
     */
    @Override
    public 天干 getPrevious() {
        {
            final 天干 p = previous;
            if (p != null) {
                return p;
            }
        }
        synchronized (this) {
            if (previous == null) {
                previous = Rolling.getPrevious(this);
            }
            return previous;
        }
    }

    /**
     * Returns the next value of this 天干.
     *
     * @return the next value of this 天干.
     */
    @Override
    public 天干 getNext() {
        {
            final 天干 n = next;
            if (n != null) {
                return n;
            }
        }
        synchronized (this) {
            if (next == null) {
                next = Rolling.getNext(this);
            }
            return next;
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    private volatile 天干 previous;

    private volatile 天干 next;
}
