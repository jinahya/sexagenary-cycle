package com.github.jinahya.sexagenarycycle;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;
import static java.util.Optional.ofNullable;

/**
 * Constants of <a href="https://en.wikipedia.org/wiki/Heavenly_Stems">Heavenly Stems</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://en.wikipedia.org/wiki/Heavenly_Stems">Heavenly Stems</a>
 * @see <a href="https://ko.wikipedia.org/wiki/%EC%B2%9C%EA%B0%84">천간</a>
 */
public enum 天干 { // 天干(\u5929\u5e72) 천간(\ucc9c\uac04)

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

    static final String REGEXP_KOREAN_NAME = "[\uac11\uc744\ubcd1\uc815\ubb34\uae30\uacbd\uc2e0\uc784\uacc4]";

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<String, 天干> VALUES_BY_NAMES;

    static {
        final Map<String, 天干> m = new HashMap<>();
        for (final 天干 value : values()) {
            m.put(value.name(), value);
        }
        VALUES_BY_NAMES = Collections.unmodifiableMap(m);
    }

    public static 天干 valueOfName(final String name) {
        requireNonNull(name, "name is null");
        final 天干 value = VALUES_BY_NAMES.get(name);
        if (value == null) {
            throw new IllegalArgumentException("no value for name: " + name);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<天干, String> KOREAN_NAMES_BY_VALUES;

    static {
        final Map<天干, String> m = new EnumMap<>(天干.class);
        m.put(甲, "갑");
        m.put(乙, "을");
        m.put(丙, "병");
        m.put(丁, "정");
        m.put(戊, "무");
        m.put(己, "기");
        m.put(庚, "경");
        m.put(辛, "신");
        m.put(壬, "임");
        m.put(癸, "계");
        KOREAN_NAMES_BY_VALUES = Collections.unmodifiableMap(m);
    }

    private static final Map<String, 天干> VALUES_BY_KOREAN_NAMES;

    static {
        final Map<String, 天干> m = new HashMap<>();
        KOREAN_NAMES_BY_VALUES.forEach((k, v) -> m.put(v, k));
        VALUES_BY_KOREAN_NAMES = Collections.unmodifiableMap(m);
    }

    /**
     * Returns the value of specified Korean name.
     *
     * @param koreanName the Korean name.
     * @return the value of specified Korean name.
     */
    public static 天干 valueOfKoreanName(final String koreanName) {
        return ofNullable(VALUES_BY_KOREAN_NAMES.get(koreanName))
                .orElseThrow(() -> new IllegalArgumentException("no value for " + koreanName));
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the Korean name of this 天干.
     *
     * @return the Korean name of this 天干.
     */
    public String koreanName() {
        return KOREAN_NAMES_BY_VALUES.get(this);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the previous value of this 天干.
     *
     * @return the previous value of this 天干.
     */
    public 天干 getPrevious() {
        天干 p = previous;
        if (p == null) {
            final 天干[] values = values();
            if (ordinal() == 0) {
                previous = p = values[values.length - 1];
            } else {
                previous = p = values()[ordinal() - 1];
            }
        }
        return p;
    }

    /**
     * Returns the next value of this 天干.
     *
     * @return the next value of this 天干.
     */
    public 天干 getNext() {
        天干 n = next;
        if (n == null) {
            final 天干[] values = values();
            if (ordinal() == values.length - 1) {
                next = n = values[0];
            } else {
                next = n = values()[ordinal() + 1];
            }
        }
        return n;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private volatile 天干 previous;

    private volatile 天干 next;
}
