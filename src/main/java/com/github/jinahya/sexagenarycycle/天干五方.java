package com.github.jinahya.sexagenarycycle;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings("NonAsciiCharacters")
final class 天干五方 {

    private static final Map<天干, 五方> MAP;

    static {
        final Map<天干, 五方> map = new EnumMap<>(天干.class);
        map.put(天干.甲, 五方.東);
        map.put(天干.乙, 五方.東);
        map.put(天干.丙, 五方.南);
        map.put(天干.丁, 五方.南);
        map.put(天干.戊, 五方.中);
        map.put(天干.己, 五方.中);
        map.put(天干.庚, 五方.西);
        map.put(天干.辛, 五方.西);
        map.put(天干.壬, 五方.北);
        map.put(天干.癸, 五方.北);
        MAP = Collections.unmodifiableMap(map);
    }

    static 五方 valueOf(final 天干 天干) {
        Objects.requireNonNull(天干, "天干 is null");
        return MAP.get(天干);
    }

    private 天干五方() {
        throw new AssertionError("instantiation is not allowed");
    }
}
