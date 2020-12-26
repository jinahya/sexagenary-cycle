package com.github.jinahya.sexagenarycycle;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

public enum 二十四方 implements Rolling<二十四方> {

    子,
    癸,
    丑,
    艮, // 易經
    寅,
    甲,
    卯,
    乙,
    辰,
    巽, // 易經
    巳,
    丙,
    午,
    丁,
    未,
    坤, // 易經
    申,
    庚,
    酉,
    辛,
    戌,
    乾, // 易經
    亥,
    壬;

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<Integer, 二十四方> VALUES_BY_INDICES = Collections.unmodifiableMap(
            Arrays.stream(values()).collect(Collectors.toMap(
                    Enum::ordinal,
                    Function.identity(),
                    (o1, o2) -> {
                        throw new AssertionError("duplicate ordinals; " + o1 + ", " + o2);
                    },
                    HashMap::new))
    );

    static 二十四方 valueOfIndex(final int index) {
        final int i = (index % 24) + (index < 0 ? 24 : 0);
        final 二十四方 value = VALUES_BY_INDICES.get(i);
        if (value == null) {
            throw new AssertionError("invalid index(" + i + ") calculated from " + index);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<Integer, 二十四方> VALUES_BY_DIRECTIONS = Collections.unmodifiableMap(
            Arrays.stream(values()).collect(Collectors.toMap(
                    v -> v.direction,
                    Function.identity(),
                    (o1, o2) -> {
                        throw new AssertionError("duplicate ordinals; " + o1 + ", " + o2);
                    },
                    HashMap::new))
    );

    public static 二十四方 valueOfDirection(final int direction, final boolean exact) {
        final int d = (direction % 360) + (direction < 0 ? 360 : 0);
        if (exact) {
            return ofNullable(VALUES_BY_DIRECTIONS.get(d % 360))
                    .orElseThrow(() -> new IllegalArgumentException("no value for direction " + direction));
        } else {
            final int index = Math.round(d / 15.0f);
            return valueOfIndex(index);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    二十四方() {
        direction = ordinal() * 15;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public 二十四方 getPrevious() {
        {
            final 二十四方 result = previous;
            if (result != null) {
                return result;
            }
        }
        synchronized (this) {
            if (previous == null) {
                previous = Rolling.getPrevious(this);
            }
            return previous;
        }
    }

    @Override
    public 二十四方 getNext() {
        {
            final 二十四方 result = next;
            if (result != null) {
                return result;
            }
        }
        synchronized (this) {
            if (next == null) {
                next = Rolling.getNext(this);
            }
            return next;
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    public final int direction;

    // -----------------------------------------------------------------------------------------------------------------
    private volatile 二十四方 previous;

    private volatile 二十四方 next;
}
