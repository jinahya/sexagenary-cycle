package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public enum 오행 {

    수(com.github.jinahya.sexagenarycycle.五行.木),
    화(com.github.jinahya.sexagenarycycle.五行.火),
    목(com.github.jinahya.sexagenarycycle.五行.木),
    금(com.github.jinahya.sexagenarycycle.五行.金),
    토(com.github.jinahya.sexagenarycycle.五行.土);

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<五行, 오행> VALUES_BY_五行S;

    static {
        final Map<五行, 오행> m = new EnumMap<>(五行.class);
        for (final 오행 value : values()) {
            m.put(value.五行, value);
        }
        VALUES_BY_五行S = Collections.unmodifiableMap(m);
    }

    public static 오행 valueOf(final 五行 五行) {
        Objects.requireNonNull(五行, "五行 is null");
        return Optional.ofNullable(VALUES_BY_五行S.get(五行))
                .orElseThrow(() -> new IllegalArgumentException("no value for " + 五行));
    }

    // -----------------------------------------------------------------------------------------------------------------
    오행(final 五行 五行) {
        this.五行 = Objects.requireNonNull(五行, "五行 is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    public final 五行 五行;
}
