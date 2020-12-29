package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings({"NonAsciiCharacters", "java:S115", "java:S116", "java:S117"})
public enum 生肖 {

    鼠(com.github.jinahya.sexagenarycycle.地支.子),
    牛(com.github.jinahya.sexagenarycycle.地支.丑),
    虎(com.github.jinahya.sexagenarycycle.地支.寅),
    兔(com.github.jinahya.sexagenarycycle.地支.卯),
    龙(com.github.jinahya.sexagenarycycle.地支.辰),
    蛇(com.github.jinahya.sexagenarycycle.地支.巳),
    马(com.github.jinahya.sexagenarycycle.地支.午),
    羊(com.github.jinahya.sexagenarycycle.地支.未),
    猴(com.github.jinahya.sexagenarycycle.地支.申),
    鸡(com.github.jinahya.sexagenarycycle.地支.酉),
    狗(com.github.jinahya.sexagenarycycle.地支.戌),
    猪(com.github.jinahya.sexagenarycycle.地支.亥);

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<地支, 生肖> VALUES_BY_地支S = Collections.unmodifiableMap(EnumUtils.mapValuesBy(
            生肖.class, v -> v.地支, () -> new EnumMap<>(地支.class)
    ));

    /**
     * Returns the value associated with specified 地支.
     *
     * @param 地支 the 地支.
     * @return the value associated with {@code 地支}.
     */
    public static 生肖 valueOf(final 地支 地支) {
        Objects.requireNonNull(地支, "地支 is null");
        final 生肖 value = VALUES_BY_地支S.get(地支);
        if (value == null) {
            throw new AssertionError("no value for " + 地支);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    生肖(final 地支 地支) {
        this.地支 = Objects.requireNonNull(地支, "地支 is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    public final 地支 地支;
}
