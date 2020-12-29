package com.github.jinahya.sexagenarycycle;

import java.util.Collections;
import java.util.Map;

/**
 * Constants for five directions.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S115"})
public enum 五方 {

    /**
     * East.
     */
    東,

    /**
     * South.
     */
    南,

    /**
     * Center.
     */
    中,

    /**
     * West.
     */
    西,

    /**
     * North.
     */
    北;

    // -----------------------------------------------------------------------------------------------------------------
    static final Map<Integer, 五方> VALUES_BY_ORDINALS
            = Collections.unmodifiableMap(EnumUtils.mapValuesByOrdinals(五方.class));
}
