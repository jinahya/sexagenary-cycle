package com.github.jinahya.sexagenarycycle;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings("NonAsciiCharacters")
final class 地支五行 {

    public static final Map<地支, 五行> 五行S_BY_地支S;

    static {
        final Map<地支, 五行> map = new EnumMap<>(地支.class);
        map.put(地支.子, 五行.水);
        map.put(地支.丑, 五行.土);
        map.put(地支.寅, 五行.木);
        map.put(地支.卯, 五行.木);
        map.put(地支.辰, 五行.土);
        map.put(地支.巳, 五行.火);
        map.put(地支.午, 五行.火);
        map.put(地支.未, 五行.土);
        map.put(地支.申, 五行.金);
        map.put(地支.酉, 五行.金);
        map.put(地支.戌, 五行.土);
        map.put(地支.亥, 五行.水);
        五行S_BY_地支S = Collections.unmodifiableMap(map);
    }

    static 五行 valueOf(final 地支 地支) {
        Objects.requireNonNull(地支, "地支 is null");
        return 五行S_BY_地支S.get(地支);
    }

    private 地支五行() {
        throw new AssertionError("instantiation is not allowed");
    }
}
