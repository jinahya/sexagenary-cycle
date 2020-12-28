package com.github.jinahya.sexagenarycycle;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings("NonAsciiCharacters")
final class 天干五行 {

    private static final Map<天干, 五行> MAP;

    static {
        final Map<天干, 五行> map = new EnumMap<>(天干.class);
        map.put(天干.甲, 五行.木);
        map.put(天干.乙, 五行.木);
        map.put(天干.丙, 五行.火);
        map.put(天干.丁, 五行.火);
        map.put(天干.戊, 五行.土);
        map.put(天干.己, 五行.土);
        map.put(天干.庚, 五行.金);
        map.put(天干.辛, 五行.金);
        map.put(天干.壬, 五行.水);
        map.put(天干.癸, 五行.水);
        MAP = Collections.unmodifiableMap(map);
    }

    static 五行 valueOf(final 天干 天干) {
        Objects.requireNonNull(天干, "天干 is null");
        return MAP.get(天干);
    }

    private 天干五行() {
        throw new AssertionError("instantiation is not allowed");
    }
}
