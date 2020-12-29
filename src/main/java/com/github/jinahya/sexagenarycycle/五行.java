package com.github.jinahya.sexagenarycycle;

import java.util.Collections;
import java.util.Map;

/**
 * Constants for <a href="https://en.wikipedia.org/wiki/Wuxing_(Chinese_philosophy)">Wuxing (Chinese philosophy)</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://zh.wikipedia.org/wiki/%E4%BA%94%E8%A1%8C">五行</a>
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S115"})
public enum 五行 implements RollingEnum<五行> {

    /**
     * Constant for Wood.
     */
    木,

    /**
     * Constant for Fire.
     */
    火,

    /**
     * Constant for Earth (or Soil).
     */
    土,

    /**
     * Constant for Metal (or Gold).
     */
    金,

    /**
     * Constant for Water.
     */
    水;

    // -----------------------------------------------------------------------------------------------------------------
    static final Map<Integer, 五行> VALUES_BY_ORDINALS
            = Collections.unmodifiableMap(EnumUtils.mapValuesByOrdinals(五行.class));
}
