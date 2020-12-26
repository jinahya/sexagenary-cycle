package com.github.jinahya.sexagenarycycle;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

final class 地支陰陽 {

    private static final Map<地支, 陰陽> MAP;

    static {
        final Map<地支, 陰陽> map = new EnumMap<>(地支.class);
        {
            map.put(地支.子, 陰陽.陽);
            map.put(地支.丑, 陰陽.陰);
            map.put(地支.寅, 陰陽.陽);
            map.put(地支.卯, 陰陽.陰);
            map.put(地支.辰, 陰陽.陽);
            map.put(地支.巳, 陰陽.陰);
            map.put(地支.午, 陰陽.陽);
            map.put(地支.未, 陰陽.陰);
            map.put(地支.申, 陰陽.陽);
            map.put(地支.酉, 陰陽.陰);
            map.put(地支.戌, 陰陽.陽);
            map.put(地支.亥, 陰陽.陰);
        }
        MAP = Collections.unmodifiableMap(map);
    }

    static 陰陽 valueOf(final 地支 地支) {
        requireNonNull(地支, "地支 is null");
        return MAP.get(地支);
    }

    private 地支陰陽() {
        throw new AssertionError("instantiation is not allowed");
    }
}
