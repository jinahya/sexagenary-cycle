package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static java.util.Arrays.stream;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
abstract class 生剋五行Test<E extends Enum<E> & 生剋五行<E>> implements RollingEnumTest<E> {

    生剋五行Test(final Class<E> enumClass) {
        super();
        this.enumClass = requireNonNull(enumClass, "enumClass is null");
    }

    // ------------------------------------------------------------------------------------------------- getSubjective()
    @Test
    void getSubjective_NonNull_ForEachValue() {
        for (final E enumConstant : enumClass.getEnumConstants()) {
            assertThat(enumConstant.getSubjective()).isNotNull();
        }
    }

    @Test
    void getSubjective_CollectToSame_AsAll五行() {
        final Set<五行> actual = stream(enumClass.getEnumConstants()).map(生剋五行::getSubjective).collect(toSet());
        final Set<五行> expected = EnumSet.allOf(五行.class);
        assertThat(actual).isEqualTo(expected);
    }

    // -------------------------------------------------------------------------------------------------- getObjective()
    @Test
    void getObjective_NonNull_ForEachValue() {
        for (final E enumConstant : enumClass.getEnumConstants()) {
            assertThat(enumConstant.getObjective()).isNotNull();
        }
    }

    @Test
    void getObjective_CollectToSame_AsAll五行() {
        final Set<五行> actual = stream(enumClass.getEnumConstants()).map(生剋五行::getObjective).collect(toSet());
        final Set<五行> expected = EnumSet.allOf(五行.class);
        assertThat(actual).isEqualTo(expected);
    }

    // -----------------------------------------------------------------------------------------------------------------
    final Class<E> enumClass;
}