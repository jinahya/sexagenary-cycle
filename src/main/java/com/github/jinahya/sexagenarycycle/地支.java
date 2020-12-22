package com.github.jinahya.sexagenarycycle;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Constants of <a href="https://en.wikipedia.org/wiki/Earthly_Branches">Earthly Branches</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://en.wikipedia.org/wiki/Earthly_Branches">Earthly Branches</a>
 * @see <a href="https://ko.wikipedia.org/wiki/%EC%A7%80%EC%A7%80_(%EC%97%AD%EB%B2%95)">지지 (역법)</a>
 */
public enum 地支 { // \u5730\u652f 지지(\uc9c0\uc9c0)

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
    static final String REGEXP_NAME = "[\u5b50\u4e11\u5bc5\u536f\u8fb0\u5df3\u5348\u672a\u7533\u9149\u620c\u4ea5]";

    static final String REGEXP_KOREAN_NAME
            = "[\uc790\ucd95\uc778\ubb18\uc9c4\uc0ac\uc624\ubbf8\uc2e0\uc720\uc220\ud574]";

    private static final Map<地支, String> KOREAN_NAMES_BY_VALUES;

    static {
        final Map<地支, String> m = new EnumMap<>(地支.class);
        m.put(子, "자");
        m.put(丑, "축");
        m.put(寅, "인");
        m.put(卯, "묘");
        m.put(辰, "진");
        m.put(巳, "사");
        m.put(午, "오");
        m.put(未, "미");
        m.put(申, "신");
        m.put(酉, "유");
        m.put(戌, "술");
        m.put(亥, "해");
        KOREAN_NAMES_BY_VALUES = Collections.unmodifiableMap(m);
    }

    private static final Map<String, 地支> VALUES_BY_KOREAN_NAMES;

    static {
        final Map<String, 地支> m = new HashMap<>();
        KOREAN_NAMES_BY_VALUES.forEach((k, v) -> m.put(v, k));
        VALUES_BY_KOREAN_NAMES = Collections.unmodifiableMap(m);
    }

    public static 地支 valueOfKoreanName(final String koreanName) {
        return VALUES_BY_KOREAN_NAMES.get(koreanName);
    }

    // -----------------------------------------------------------------------------------------------------------------
    public String koreanName() {
        return KOREAN_NAMES_BY_VALUES.get(this);
    }

    // -----------------------------------------------------------------------------------------------------------------
    public 地支 getPrevious() {
        地支 p = previous;
        if (p == null) {
            final 地支[] values = values();
            if (ordinal() == 0) {
                previous = p = values[values.length - 1];
            } else {
                previous = p = values()[ordinal() - 1];
            }
        }
        return p;
    }

    public 地支 getNext() {
        地支 n = next;
        if (n == null) {
            final 地支[] values = values();
            if (ordinal() == values.length - 1) {
                next = n = values[0];
            } else {
                next = n = values()[ordinal() + 1];
            }
        }
        return n;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private volatile 地支 previous;

    private volatile 地支 next;
}
