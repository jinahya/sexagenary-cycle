package com.github.jinahya.sexagenarycycle;

/**
 * An interface for defining relationships between {@link 五行}s.
 *
 * @param <E> implementation type parameter.
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://zh.wikipedia.org/wiki/%E4%BA%94%E8%A1%8C#%E7%94%9F%E5%89%8B%E4%BA%94%E8%A1%8C">生剋五行
 * (Wikipedia)</a>
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S114"})
interface 生剋五行<E extends Enum<E> & 生剋五行<E>> extends RollingEnum<E> {

}
