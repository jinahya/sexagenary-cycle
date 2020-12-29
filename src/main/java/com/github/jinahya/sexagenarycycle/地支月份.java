package com.github.jinahya.sexagenarycycle;

import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Maps months to {@link 地支}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S101", "java:S117"})
final class 地支月份 {

    private static final Map<地支, Month> 月份 = Collections.unmodifiableMap(
            Arrays.stream(地支.values()).collect(Collectors.toMap(
                    Function.identity(), v -> Month.JANUARY.plus((long) v.ordinal() + 10L)
            ))
    );

    /**
     * Returns the {@link Month} associated to specified 地支.
     *
     * @param 地支 the 地支.
     * @return the {@link Month} associated to {@code 地支}.
     */
    public static Month valueOf(final 地支 地支) {
        Objects.requireNonNull(地支, "地支 is null");
        return 月份.get(地支);
    }

    private 地支月份() {
        throw new AssertionError("instantiation is not allowed");
    }
}
