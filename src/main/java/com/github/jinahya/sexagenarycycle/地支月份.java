package com.github.jinahya.sexagenarycycle;

import java.time.Month;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

final class 地支月份 {

    private static final Map<地支, Month> MAP;

    static {
        final Map<地支, Month> map = new EnumMap<>(地支.class);
        {
            final Month[] months = Month.values();
            for (final 地支 value : 地支.values()) {
                map.put(value, months[(value.ordinal() + 11) % months.length]);
            }
        }
        MAP = Collections.unmodifiableMap(map);
    }

    static Month valueOf(final 地支 地支) {
        Objects.requireNonNull(地支, "地支 is null");
        return MAP.get(地支);
    }

    private 地支月份() {
        throw new AssertionError("instantiation is not allowed");
    }
}
