package com.github.jinahya.sexagenarycycle;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

final class 天干陰陽 {

    private static final Map<天干, 陰陽> MAP;

    static {
        final Map<天干, 陰陽> map = new EnumMap<>(天干.class);
        map.put(天干.甲, 陰陽.陽);
        map.put(天干.乙, 陰陽.陰);
        map.put(天干.丙, 陰陽.陽);
        map.put(天干.丁, 陰陽.陰);
        map.put(天干.戊, 陰陽.陽);
        map.put(天干.己, 陰陽.陰);
        map.put(天干.庚, 陰陽.陽);
        map.put(天干.辛, 陰陽.陰);
        map.put(天干.壬, 陰陽.陽);
        map.put(天干.癸, 陰陽.陰);
        MAP = Collections.unmodifiableMap(map);
    }

    static 陰陽 valueOf(final 天干 天干) {
        Objects.requireNonNull(天干, "天干 is null");
        return MAP.get(天干);
    }

    private 天干陰陽() {
        throw new AssertionError("instantiation is not allowed");
    }
}
