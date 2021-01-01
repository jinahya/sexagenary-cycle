package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static java.util.Objects.requireNonNull;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
abstract class 五方間色Test<S extends Enum<S> & 五方間色<S, P>, P extends Enum<P> & 生剋五行<P>> {

    五方間色Test(final Class<S> 五方間色Class, final Class<P> 生剋五行Class) {
        super();
        this.五方間色Class = requireNonNull(五方間色Class, "五方間色Class is null");
        this.生剋五行Class = requireNonNull(生剋五行Class, "生剋五行Class is null");
    }

    @Test
    void get五方正色Set_NonNullNoNullsSize2_ForEach五方間色() {
        for (final S enumConstant : 五方間色Class.getEnumConstants()) {
            assertThat(enumConstant.get五方正色Set()).isNotNull().doesNotContainNull().hasSize(2);
        }
    }

    @Test
    void get生剋五行_NonNullUnique_ForEachValue() {
        final Set<P> set = EnumSet.noneOf(生剋五行Class);
        for (final S enumConstant : 五方間色Class.getEnumConstants()) {
            final P 生剋五行 = enumConstant.get生剋五行();
            assertThat(生剋五行).isNotNull();
            assertThat(set.add(生剋五行)).isTrue();
        }
        assertThat(set).isEqualTo(EnumSet.allOf(生剋五行Class));
    }

    final Class<S> 五方間色Class;

    final Class<P> 生剋五行Class;
}