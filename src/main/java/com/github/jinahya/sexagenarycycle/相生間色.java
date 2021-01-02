package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.EnumMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@SuppressWarnings({"NonAsciiCharacters", "java:S115", "java:S116", "java:S117"})
public enum 相生間色 implements 五方間色<相生間色, 五行相生> {

    靘, // 검푸른 빛 정

    纁, // 분홍빛 훈

    硅, // 규소 규, 연두록

    黻, // 수 불, 잿빛

    黯; // 검을 암

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<五行相生, 相生間色> VALUES_BY_五行相生S = Collections.unmodifiableMap(
            EnumUtils.mapValuesBy(相生間色.class, v -> v.五行相生, () -> new EnumMap<>(五行相生.class))
    );

    /**
     * Returns the value associated with specified 五行相生.
     *
     * @param 五行相生 the 五行相生.
     * @return the value associated with {@code 五行相生}.
     */
    public static 相生間色 valueOf(final 五行相生 五行相生) {
        Objects.requireNonNull(五行相生, "五行相生 is null");
        final 相生間色 value = VALUES_BY_五行相生S.get(五行相生);
        if (value == null) {
            throw new AssertionError("no value for " + 五行相生);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    相生間色() {
        五行相生 = com.github.jinahya.sexagenarycycle.五行相生.values()[ordinal()];
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public @Size(min = 2, max = 2) Set<@NotNull 五方正色> get五方正色Set() {
        Set<五方正色> result = 五方正色;
        if (result == null) {
            final 五方正色[] values = com.github.jinahya.sexagenarycycle.五方正色.values();
            final Set<五方正色> set = new LinkedHashSet<>(2);
            set.add(values[ordinal()]);
            set.add(values[(ordinal() + 1) % values.length]);
            五方正色 = result = Collections.unmodifiableSet(set);
        }
        return result;
    }

    @Override
    public com.github.jinahya.sexagenarycycle.五行相生 get生剋五行() {
        return 五行相生;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The 五行相生 associated with this 相生間色.
     */
    private final 五行相生 五行相生;

    // -----------------------------------------------------------------------------------------------------------------
    // a lazy-initialized unmodifiable set of two 五方正色s.
    @SuppressWarnings({"java:S3077"})
    private volatile @Size(min = 2, max = 2) Set<@NotNull 五方正色> 五方正色;
}
