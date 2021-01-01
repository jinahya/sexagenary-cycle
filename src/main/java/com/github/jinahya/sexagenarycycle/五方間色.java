package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Defines relationships between two values of 五方正色.
 *
 * @param <S> self type parameter.
 * @param <P> 生剋五行 type parameter.
 * @see 五方正色
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S100", "java:S114"})
public interface 五方間色<S extends Enum<S> & 五方間色<S, P>, P extends Enum<P> & 生剋五行<P>> {

    /**
     * Returns an ordered set of two 五方正色 composing this 五方間色.
     *
     * @return two 五方正色 composing this 五方間色.
     */
    @Size(min = 2, max = 2) Set<@NotNull 五方正色> get五方正色Set();

    /**
     * Returns the 生剋五行 associated with this 五方間色.
     *
     * @return the 生剋五行 associated with this 五方間色.
     */
    P get生剋五行();
}
