package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings({"NonAsciiCharacters", "java:S115", "java:S116", "java:S117"})
public enum 오방 {

    동(com.github.jinahya.sexagenarycycle.五方.東),
    남(com.github.jinahya.sexagenarycycle.五方.南),
    중(com.github.jinahya.sexagenarycycle.五方.中),
    서(com.github.jinahya.sexagenarycycle.五方.西),
    북(com.github.jinahya.sexagenarycycle.五方.北);

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<五方, 오방> VALUES_BY_五方S = Collections.unmodifiableMap(
            Arrays.stream(values()).collect(Collectors.toMap(
                    v -> v.五方,
                    Function.identity(),
                    (v1, v2) -> {
                        throw new AssertionError("duplicate value: " + v1 + ", " + v2);
                    },
                    () -> new EnumMap<>(五方.class)
            ))
    );

    public static 오방 valueOf(final 五方 五方) {
        Objects.requireNonNull(五方, "五方 is null");
        final 오방 value = VALUES_BY_五方S.get(五方);
        if (value == null) {
            throw new AssertionError("shouldn't happen; no value for " + 五方);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    오방(final 五方 五方) {
        this.五方 = Objects.requireNonNull(五方, "五方 is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    public final 五方 五方;
}
