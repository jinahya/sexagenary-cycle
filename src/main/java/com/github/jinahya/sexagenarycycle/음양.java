package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public enum 음양 {

    음(com.github.jinahya.sexagenarycycle.陰陽.陰),
    양(com.github.jinahya.sexagenarycycle.陰陽.陽);

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<陰陽, 음양> VALUES_BY_陰陽S;

    static {
        final Map<陰陽, 음양> m = new EnumMap<>(陰陽.class);
        for (final 음양 value : values()) {
            m.put(value.陰陽, value);
        }
        VALUES_BY_陰陽S = Collections.unmodifiableMap(m);
    }

    public static 음양 valueOf(final 陰陽 陰陽) {
        Objects.requireNonNull(陰陽, "陰陽 is null");
        return VALUES_BY_陰陽S.get(陰陽);
    }

    // -----------------------------------------------------------------------------------------------------------------
    음양(final 陰陽 陰陽) {
        this.陰陽 = Objects.requireNonNull(陰陽, "陰陽 is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    public final 陰陽 陰陽;
}
