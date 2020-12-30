package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings({"NonAsciiCharacters", "java:S115", "java:S116", "java:S117"})
public enum 음양 {

    음(com.github.jinahya.sexagenarycycle.陰陽.陰),

    양(com.github.jinahya.sexagenarycycle.陰陽.陽);

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<陰陽, 음양> VALUES_BY_陰陽S = Collections.unmodifiableMap(
            Arrays.stream(values()).collect(Collectors.toMap(v -> v.陰陽, Function.identity()))
    );

    public static 음양 valueOf(final 陰陽 陰陽) {
        Objects.requireNonNull(陰陽, "陰陽 is null");
        final 음양 value = VALUES_BY_陰陽S.get(陰陽);
        if (value == null) {
            throw new AssertionError("no value for " + 陰陽);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    음양(final 陰陽 陰陽) {
        this.陰陽 = Objects.requireNonNull(陰陽, "陰陽 is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    public final 陰陽 陰陽;
}
